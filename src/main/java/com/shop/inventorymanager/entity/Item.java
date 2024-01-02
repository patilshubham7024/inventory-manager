package com.shop.inventorymanager.entity;

import jakarta.persistence.*;
import lombok.*;

@Table(name = "item")
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "sell_order_id")
    private SellOrder sellOrder;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    private Integer quantity;

    private Double sellPrice;

}
