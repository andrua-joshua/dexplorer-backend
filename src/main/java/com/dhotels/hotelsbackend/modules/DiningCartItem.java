package com.dhotels.hotelsbackend.modules;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@Data
@Table(name = "DINING-CART-ITEMS")
@NoArgsConstructor
@Setter
@Getter
public class DiningCartItem {

    @Id
    @GeneratedValue
    private Integer id;
    @ManyToOne
    @JoinColumn(name = "dining-item-id", referencedColumnName = "id")
    @JsonIgnore
    private DiningItem item;
    @ManyToOne()
    @JoinColumn(name = "dining-cart-id", referencedColumnName = "id")
    @JsonIgnore
    private DiningCart cart;
    private double quantity;
    private double cost;
    private Date createdAt;


    public DiningCartItem(DiningItem item, DiningCart cart,
                          double quantity, double cost, Date createdAt) {
        this.item = item;
        this.cart = cart;
        this.quantity = quantity;
        this.cost = cost;
        this.createdAt = createdAt;
    }
}
