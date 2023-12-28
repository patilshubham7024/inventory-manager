package com.shop.inventorymanager.mapper;

import com.shop.inventorymanager.entity.Product;
import com.shop.inventorymanager.entity.Purchase;
import com.shop.inventorymanager.entity.Sell;
import com.shop.inventorymanager.entity.User;
import com.shop.inventorymanager.model.ProductDTO;
import com.shop.inventorymanager.model.PurchaseDTO;
import com.shop.inventorymanager.model.SellDTO;
import com.shop.inventorymanager.model.UserDTO;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class DTOMapper {

    public List<SellDTO> mapSellEntityToSellDTO(List<Sell> sells) {
        if(CollectionUtils.isEmpty(sells)){
            return null;
        }
        return sells.stream().map(this::mapSellEntityToSellDTO).collect(Collectors.toList());
    }

    public SellDTO mapSellEntityToSellDTO(Sell sell) {
        if (sell == null)
           return null;
        return SellDTO.builder()
                .product(Optional.ofNullable(sell.getProduct()).map(Product::getName).orElse(null))
                .price(sell.getSellPrice())
                .quantity(sell.getSellQuantity())
                .build();
    }

    public List<ProductDTO> mapProductEntityToProductDTO(List<Product> products) {
        if(CollectionUtils.isEmpty(products)){
            return null;
        }
        return products.stream().map(this::mapProductEntityToProductDTO).collect(Collectors.toList());
    }

    public ProductDTO mapProductEntityToProductDTO(Product product) {
        if (product == null)
            return null;
        return ProductDTO.builder()
                .code(product.getCode())
                .name(product.getName())
                .sellPrice(product.getSellPrice())
                .build();
    }

    public List<PurchaseDTO> mapPurchaseEntityToPurchaseDTO(List<Purchase> purchases) {
        if(CollectionUtils.isEmpty(purchases)){
            return null;
        }
        return purchases.stream().map(this::mapPurchaseEntityToPurchaseDTO).collect(Collectors.toList());
    }

    public PurchaseDTO mapPurchaseEntityToPurchaseDTO(Purchase purchase) {
        if (purchase == null)
            return null;
        return PurchaseDTO.builder()
                .productName(purchase.getProduct().getName())
                .purchasePrice(purchase.getPurchasePrice())
                .purchaseQuantity(purchase.getPurchaseQuantity())
                .build();
    }

    public UserDTO mapUserEntityToUserDTO(User user) {
        if (user == null)
            return null;
        return UserDTO.builder()
                .username(user.getUsername())
                .role(user.getRole())
                .password(user.getPassword())
                .firstName(user.getFirstName() + " " + user.getLastName())
                .build();
    }
}
