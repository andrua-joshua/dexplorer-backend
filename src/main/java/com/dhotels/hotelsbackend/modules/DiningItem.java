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
@Table(name = "DINING-ITEMS")
@NoArgsConstructor
@Setter
@Getter
public class DiningItem {

    @Id
    @GeneratedValue
    private Integer id;
    private List<String> images;
    private String name;
    @ManyToOne
    @JoinColumn(name = "business-id", referencedColumnName = "id")
    @JsonIgnore
    private Business business;
    private double price;
    private Date createdAt;
    @OneToMany(mappedBy = "item", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    private List<DiningCartItem> diningCartItems;
    @OneToMany(mappedBy = "diningItem", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    private List<FavouriteDiningItem> favouriteDiningItems;


    public DiningItem(List<String> images, String name, Business business,
                      double price, Date createdAt, List<DiningCartItem> diningCartItems,
                      List<FavouriteDiningItem> favouriteDiningItems) {
        this.images = images;
        this.name = name;
        this.business = business;
        this.price = price;
        this.createdAt = createdAt;
        this.diningCartItems = diningCartItems;
        this.favouriteDiningItems = favouriteDiningItems;
    }
}
