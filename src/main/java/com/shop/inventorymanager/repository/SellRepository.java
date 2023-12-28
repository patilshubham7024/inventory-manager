package com.shop.inventorymanager.repository;

import com.shop.inventorymanager.entity.Sell;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface SellRepository extends JpaRepository<Sell, Long> {

    List<Sell> findBySellDateTimeBetweenOrderBySellDateTimeDesc(LocalDateTime from, LocalDateTime to);

    List<Sell> findByProduct_NameAndSellDateTimeBetweenOrderBySellDateTimeDesc(String product_name, LocalDateTime sellDateTime, LocalDateTime sellDateTime2);

    List<Sell> findByProduct_Name(String product_name);
}
