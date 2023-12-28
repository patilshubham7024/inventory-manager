package com.shop.inventorymanager.repository;

import com.shop.inventorymanager.entity.Product;
import com.shop.inventorymanager.entity.Sell;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    Product findByCode(String code);

}
