package com.devsuperior.dscommerce.repositories;
//Responsável por operações de banco de dados para produtos


import com.devsuperior.dscommerce.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
