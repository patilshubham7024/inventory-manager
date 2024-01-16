package com.shop.inventorymanager.service;

import com.shop.inventorymanager.entity.Item;
import com.shop.inventorymanager.entity.SellOrder;
import com.shop.inventorymanager.entity.Product;
import com.shop.inventorymanager.exception.customException.SellException;
import com.shop.inventorymanager.mapper.DTOMapper;
import com.shop.inventorymanager.model.SellAddRequest;
import com.shop.inventorymanager.model.SellOrderDTO;
import com.shop.inventorymanager.model.SoldProductDTO;
import com.shop.inventorymanager.model.StockDTO;
import com.shop.inventorymanager.repository.SellOrderRepository;
import com.shop.inventorymanager.repository.ProductRepository;
//import com.shop.inventorymanager.repository.SellRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
@Log4j2
public class SellService {

//    @Autowired
//    private SellRepository sellRepository;

    @Autowired
    private SellOrderRepository orderRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private DTOMapper dTOMapper;

    @Autowired
    private StockService stockService;

    public List<SellOrderDTO> get(LocalDateTime from, LocalDateTime to) {
        log.info("SellService -> get");
        List<SellOrder> allSells = orderRepository.findByOrderDateTimeBetweenOrderByOrderDateTimeDesc(from, to);
        return dTOMapper.mapSellEntityToSellDTO(allSells);
    }

    public SellOrder add(SellAddRequest sellAdd) {
        log.info("SellService -> add");
            List<Item> items = new ArrayList<>();
            SellOrder sellOrder = SellOrder.builder()
                    .items(items)
                    .customerName(sellAdd.getCustomerName())
                    .totalAmount(sellAdd.getSellAmount())
                    .build();

            sellAdd.getProducts().forEach(product -> {
                Product product1 = productRepository.findByCode(product.getProductCode());
                if(product1 == null){
                    throw new SellException("Product not found : " + product.getProductCode());
                }
                stockService.sell(StockDTO.builder().productCode(product.getProductCode())
                                .soldQuantity(product.getQuantity())
                        .build());
                items.add(Item.builder()
                        .product(product1)
                                .sellOrder(sellOrder)
                        .sellPrice(product.getPrice())
                        .quantity(product.getQuantity()).build());
            });
            return orderRepository.save(sellOrder);
    }

    public void update() {

    }

    public void delete() {

    }
}
