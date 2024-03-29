package com.shop.inventorymanager.repository;

import com.shop.inventorymanager.entity.Product;
import com.shop.inventorymanager.entity.Stock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StockRepository extends JpaRepository<Stock, Long> {

    Stock findByProduct(Product product);
}
