package com.shop.inventorymanager.service;

import com.shop.inventorymanager.entity.Product;
import com.shop.inventorymanager.entity.Stock;
import com.shop.inventorymanager.exception.customException.SellException;
import com.shop.inventorymanager.model.StockDTO;
import com.shop.inventorymanager.repository.ProductRepository;
import com.shop.inventorymanager.repository.StockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StockService {
    @Autowired
    private StockRepository stockRepository;

    @Autowired
    private ProductRepository productRepository;

    public Stock purchase(StockDTO stockDTO) {
        Product product = productRepository.findByCode(stockDTO.getProductCode());
        if(product == null){
            throw new RuntimeException("Product not found : " + stockDTO.getProductCode());
        }

        Stock stock = stockRepository.findByProduct(product);
        if(stock !=null) {
            stock.setStockQuantity(stock.getStockQuantity() + stockDTO.getPurchaseQuantity());
            return stockRepository.save(stock);
        }
        return stockRepository.save(Stock.builder()
                .product(product)
                .stockQuantity(stockDTO.getPurchaseQuantity())
                .build());
    }

    public Stock sell(StockDTO stockDTO) {
        Product product = productRepository.findByCode(stockDTO.getProductCode());
        if(product == null){
            throw new SellException("Product not found : " + stockDTO.getProductCode());
        }

        Stock stock = stockRepository.findByProduct(product);
        if(stock !=null) {
            if(stockDTO.getSoldQuantity()>stock.getStockQuantity()){
                throw new SellException("Limited stock : " + stock.getStockQuantity() + " for product :" +stockDTO.getProductCode());
            }
            stock.setStockQuantity(stock.getStockQuantity() - stockDTO.getSoldQuantity());
            return stockRepository.save(stock);
        } else {
            throw new SellException("No stock found for " + stockDTO.getProductCode());
        }
    }

}
