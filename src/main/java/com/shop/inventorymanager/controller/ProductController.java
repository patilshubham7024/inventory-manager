package com.shop.inventorymanager.controller;

import com.shop.inventorymanager.entity.Product;
import com.shop.inventorymanager.model.ProductAddRequest;
import com.shop.inventorymanager.model.ProductAddResponse;
import com.shop.inventorymanager.model.ProductDTO;
import com.shop.inventorymanager.service.ProductService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.shop.inventorymanager.constant.Messages.*;

@RestController
@RequestMapping("/product")
@Log4j2
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping
    public List<ProductDTO> get() {
        log.info("ProductController -> get");
        return productService.get();
    }

    @PostMapping
    public ProductAddResponse add(@RequestBody ProductAddRequest addRequest) {
        log.info("ProductController -> add");
        Product added = productService.add(addRequest);
        if(added != null) {
            return ProductAddResponse.builder().message(PRODUCT_ADD_SUCCESS).code(added.getCode()).build();
        }
        return ProductAddResponse.builder().message(PRODUCT_ADD_ERROR).build();
    }

    @PutMapping
    public void update() {
        productService.update();
    }

    @DeleteMapping
    public void delete() {
        productService.delete();
    }


}
