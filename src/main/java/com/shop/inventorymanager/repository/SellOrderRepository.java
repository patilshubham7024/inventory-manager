package com.shop.inventorymanager.repository;

import com.shop.inventorymanager.entity.SellOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface SellOrderRepository extends JpaRepository<SellOrder, Integer> {
    List<SellOrder> findByOrderDateTimeBetweenOrderByOrderDateTimeDesc(LocalDateTime from, LocalDateTime to);

}
