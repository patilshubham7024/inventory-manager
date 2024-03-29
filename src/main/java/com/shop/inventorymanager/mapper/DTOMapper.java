package com.shop.inventorymanager.mapper;

import com.shop.inventorymanager.entity.*;
//import com.shop.inventorymanager.entity.Sell;
import com.shop.inventorymanager.model.*;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class DTOMapper {

    public List<SellOrderDTO> mapSellEntityToSellDTO(List<SellOrder> sellOrders) {
        if(CollectionUtils.isEmpty(sellOrders)){
            return null;
        }
        return sellOrders.stream().map(this::mapSellEntityToSellDTO).collect(Collectors.toList());
    }
//
    public SellOrderDTO mapSellEntityToSellDTO(SellOrder sellOrder) {
        if (sellOrder == null)
            return null;

        return SellOrderDTO.builder()
                .customerName(sellOrder.getCustomerName())
                .sellAmount(sellOrder.getTotalAmount())
                .products(mapProductEntityToSoldProductDTO(sellOrder.getItems()))
                .build();
    }

    public List<SoldProductDTO> mapProductEntityToSoldProductDTO(List<Item> items) {
        if (CollectionUtils.isEmpty(items))
            return null;
        return items.stream().map(this::mapProductEntityToSoldProductDTO).collect(Collectors.toList());
    }
    public SoldProductDTO mapProductEntityToSoldProductDTO(Item item) {
        if(item == null)
            return null;
        return SoldProductDTO.builder()
                .product(item.getProduct().getName())
                .quantity(item.getQuantity())
                .price(item.getSellPrice())
                .build();
    }

//    public List<SoldProductDTO> mapSellEntityToSellDTO2(List<Sell> sells) {
//        if(CollectionUtils.isEmpty(sells)){
//            return null;
//        }
//        return sells.stream().map(this::mapSellEntityToSellDTO).collect(Collectors.toList());
//    }
//
//    public SoldProductDTO mapSellEntityToSellDTO(Sell sell) {
//        if (sell == null)
//           return null;
//        return SoldProductDTO.builder()
//                .product(Optional.ofNullable(sell.getProduct()).map().orElse(null))
//                .price(sell.getSellAmount())
//                .quantity(sell.getSellQuantity())
//                .build();
//    }
//
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

//    public UserDTO mapUserEntityToUserDTO(User user) {
//        if (user == null)
//            return null;
//        return UserDTO.builder()
//                .username(user.getUsername())
//                .role(user.getRole())
//                .password(user.getPassword())
//                .firstName(user.getFirstName() + " " + user.getLastName())
//                .build();
//    }
}
