package com.dhotels.hotelsbackend.modules;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Entity
@Data
@Table(name = "DINING-CART")
@NoArgsConstructor
@Setter
@Getter
public class DiningCart {

    @Id
    @GeneratedValue
    private Integer id;
    @OneToMany(mappedBy = "cart", cascade = CascadeType.REMOVE, fetch = FetchType.LAZY)
    private List<DiningCartItem> cartItems;
    @ManyToOne()
    @JoinColumn(name = "owner_id", referencedColumnName = "id")
    @JsonIgnore
    private User client;
    private double totalCost;
    private Date createdAt;
//    @ManyToOne
//    @JoinColumn(name = "dining-order-id", referencedColumnName = "id")
//    private DiningOrder order;


    public DiningCart(List<DiningCartItem> cartItems, User client,
                      double totalCost, Date createdAt) {
        this.cartItems = cartItems;
        this.client = client;
        this.totalCost = totalCost;
        this.createdAt = createdAt;
    }
}
