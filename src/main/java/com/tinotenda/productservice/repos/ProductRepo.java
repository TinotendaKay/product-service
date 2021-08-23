package com.tinotenda.productservice.repos;

import com.tinotenda.productservice.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepo extends JpaRepository <Product, Long> {
}
