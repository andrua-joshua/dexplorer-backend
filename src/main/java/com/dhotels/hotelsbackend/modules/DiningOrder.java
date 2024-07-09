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
@Table(name = "DINING-ORDER")
@NoArgsConstructor
@Setter
@Getter
public class DiningOrder {

    @Id
    @GeneratedValue
    private Integer id;
//    @OneToMany
//    private List<DiningCart> carts;
    private double amount;
    @ManyToOne
    @JoinColumn(name = "client-id", referencedColumnName = "id")
    @JsonIgnore
    private User client;
    private Date createdAt;


    public DiningOrder(double amount, User client, Date createdAt) {
        this.amount = amount;
        this.client = client;
        this.createdAt = createdAt;
    }
}
