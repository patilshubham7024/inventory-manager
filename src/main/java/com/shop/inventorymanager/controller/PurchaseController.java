package com.shop.inventorymanager.controller;

import com.shop.inventorymanager.entity.Purchase;
import com.shop.inventorymanager.model.PurchaseAddRequest;
import com.shop.inventorymanager.model.PurchaseAddResponse;
import com.shop.inventorymanager.model.PurchaseDTO;
import com.shop.inventorymanager.service.PurchaseService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.shop.inventorymanager.constant.Messages.PURCHASE_ADD_ERROR;
import static com.shop.inventorymanager.constant.Messages.PURCHASE_ADD_SUCCESS;

@RestController
@RequestMapping("/purchase")
@Log4j2
public class PurchaseController {

    @Autowired
    private PurchaseService purchaseService;

    @GetMapping
    public List<PurchaseDTO> get() {
        log.info("PurchaseController -> get");
        return purchaseService.get();
    }

    @PostMapping
    public PurchaseAddResponse add(@RequestBody PurchaseAddRequest addRequest) {
        log.info("PurchaseController -> add");
        Purchase added = purchaseService.add(addRequest);
        if(added != null) {
            return PurchaseAddResponse.builder().message(PURCHASE_ADD_SUCCESS).productName(added.getProduct().getName()).build();
        } else {
            return PurchaseAddResponse.builder().message(PURCHASE_ADD_ERROR).build();
        }
    }

    @PutMapping
    public void update() {
        purchaseService.update();
    }

    @DeleteMapping
    public void delete() {
        purchaseService.delete();
    }


}
