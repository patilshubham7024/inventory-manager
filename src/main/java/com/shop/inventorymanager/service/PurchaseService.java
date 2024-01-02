package com.shop.inventorymanager.service;

import com.shop.inventorymanager.entity.Product;
import com.shop.inventorymanager.entity.Purchase;
import com.shop.inventorymanager.mapper.DTOMapper;
import com.shop.inventorymanager.model.ProductAddRequest;
import com.shop.inventorymanager.model.PurchaseAddRequest;
import com.shop.inventorymanager.model.PurchaseDTO;
import com.shop.inventorymanager.repository.ProductRepository;
import com.shop.inventorymanager.repository.PurchaseRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Log4j2
public class PurchaseService {

    @Autowired
    private PurchaseRepository purchaseRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private DTOMapper dTOMapper;

    @Autowired
    private ProductService productService;

    public List<PurchaseDTO> get() {
        log.info("PurchaseService -> get");
        List<Purchase> purchaseList = purchaseRepository.findAll(Sort.by(Sort.Direction.DESC, "createdDate"));
//        return dTOMapper.mapPurchaseEntityToPurchaseDTO(purchaseList);
        return null;
    }

    public Purchase add(PurchaseAddRequest addRequest) {
        log.info("PurchaseService -> add");
        Product product = productRepository.findByCode(addRequest.getProductCode());
        if(product == null) {
            product = addProduct(addRequest);
        }
        return purchaseRepository.save(Purchase.builder()
                .product(product)
                .purchasePrice(addRequest.getPrice())
                .purchaseQuantity(addRequest.getQuantity())
                .build());
    }

    private Product addProduct(PurchaseAddRequest addRequest) {
        return productService.add(ProductAddRequest.builder()
                .code(addRequest.getProductCode())
                .name(addRequest.getProductCode())
                .sellPrice(addRequest.getPrice())
                .build());
    }

    public void update() {

    }

    public void delete() {

    }
}
