package com.shop.inventorymanager.service;

import com.shop.inventorymanager.entity.Product;
import com.shop.inventorymanager.mapper.DTOMapper;
import com.shop.inventorymanager.model.ProductAddRequest;
import com.shop.inventorymanager.model.ProductDTO;
import com.shop.inventorymanager.repository.ProductRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Log4j2
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private DTOMapper dtoMapper;

    public List<ProductDTO> get() {
        log.info("ProductService -> get");
        List<Product> productList = productRepository.findAll(Sort.by(Sort.Direction.DESC, "createdDate"));
        return dtoMapper.mapProductEntityToProductDTO(productList);
    }

    public Product add(ProductAddRequest addRequest) {
        log.info("ProductService -> add");
        return productRepository.save(Product.builder()
                .code(addRequest.getCode())
                .name(addRequest.getName())
                .sellPrice(addRequest.getSellPrice())
                .build());
    }

    public void update() {

    }

    public void delete() {

    }
}
