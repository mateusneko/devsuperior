package com.devsuperior.dscommerce.services;

import com.devsuperior.dscommerce.dto.ProductDTO;
import com.devsuperior.dscommerce.entities.Product;
import com.devsuperior.dscommerce.repositories.ProductRepository;
import com.devsuperior.dscommerce.services.exceptions.DatabaseException;
import com.devsuperior.dscommerce.services.exceptions.ResourceNotFoundException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

//service ou componnent
@Service
public class ProductService {
    @Autowired
    private ProductRepository repository;

    @Transactional(readOnly = true)
    public ProductDTO findById(Long id){
        Product product = repository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Id " + id + " não encontrado!"));
        //Copiar os dados para o DTO
        ProductDTO dto = new ProductDTO(product);
        return new ProductDTO(product);
    }

    @Transactional(readOnly = true)
    public Page<ProductDTO> findAll(Pageable pageable) {
        Page<Product> result = repository.findAll(pageable);
        return result.map(x -> new ProductDTO(x));
    }
        public ProductDTO insert(ProductDTO dto){
            Product entity = new Product();
            copyDtoToEntity(dto, entity);

            //Salvar no DB
            entity = repository.save(entity);
            return new ProductDTO(entity);
        }
@Transactional
    public ProductDTO update(Long id, ProductDTO dto){
            try {
                //Instanciar com a referência
                Product entity = repository.getReferenceById(id);
                copyDtoToEntity(dto, entity);
                //Salvar no DB
                entity = repository.save(entity);
                return new ProductDTO(entity);
            }
            catch (EntityNotFoundException e){
                throw new ResourceNotFoundException("Id " + id + " não encontrado. Verifique o id digitado!");
            }
    }

    @Transactional(propagation = Propagation.SUPPORTS)
    public void delete(Long id){
        if(!repository.existsById(id))
        {
            throw new ResourceNotFoundException("Id " + id + " não encontrado! Verifique o id e tente novamente");
        }
        try{
            repository.deleteById(id);
        }
       catch (DataIntegrityViolationException e){
            throw new DatabaseException("Falha de integridade referencial");
       }
    }

    private void copyDtoToEntity(ProductDTO dto, Product entity) {
        entity.setName((dto.getName()));
        entity.setDescription((dto.getDescription()));
        entity.setPrice((dto.getPrice()));
        entity.setImgUrl((dto.getImgUrl()));
    }



}

