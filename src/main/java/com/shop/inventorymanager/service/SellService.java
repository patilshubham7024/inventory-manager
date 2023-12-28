package com.shop.inventorymanager.service;

import com.shop.inventorymanager.entity.Product;
import com.shop.inventorymanager.entity.Sell;
import com.shop.inventorymanager.mapper.DTOMapper;
import com.shop.inventorymanager.model.SellAddRequest;
import com.shop.inventorymanager.model.SellDTO;
import com.shop.inventorymanager.repository.ProductRepository;
import com.shop.inventorymanager.repository.SellRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@Log4j2
public class SellService {

    @Autowired
    private SellRepository sellRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private DTOMapper dTOMapper;

    public List<SellDTO> get(LocalDateTime from, LocalDateTime to) {
        log.info("SellService -> get");
        List<Sell> allSells = sellRepository.findBySellDateTimeBetweenOrderBySellDateTimeDesc(from, to);
        return dTOMapper.mapSellEntityToSellDTO(allSells);
    }

    public Sell add(SellAddRequest sellAdd) {
        log.info("SellService -> add");
        try {
            Product product = productRepository.findByCode(sellAdd.getProductCode());
        return sellRepository.save(Sell.builder()
                    .product(product)
                    .sellPrice(sellAdd.getPrice())
                    .sellQuantity(sellAdd.getQuantity())
                    .sellDateTime(LocalDateTime.now())
                    .build());
        } catch (Exception e) {
            log.info(e);
            return null;
        }
    }

    public void update() {

    }

    public void delete() {

    }
}
