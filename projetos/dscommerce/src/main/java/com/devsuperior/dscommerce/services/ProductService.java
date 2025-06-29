package com.devsuperior.dscommerce.services;

import com.devsuperior.dscommerce.dto.ProductDTO;
import com.devsuperior.dscommerce.entities.Product;
import com.devsuperior.dscommerce.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

//service ou componnent
@Service
public class ProductService {
    @Autowired
    private ProductRepository repository;

    @Transactional(readOnly = true)
    public ProductDTO findById(Long id){

        //Optional<Product> result = repository.findById(id);
        //Product product = result.get();
        Product product = repository.findById(id).get();
        //Copiar os dados para o DTO
        ProductDTO dto = new ProductDTO(product);
        //return dto;
        return new ProductDTO(product);
    }
}
