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
@Table(name = "USERS")
@NoArgsConstructor
@Setter
@Getter
public class FavouriteDiningItem {

    @Id
    @GeneratedValue
    private Integer id;
    @ManyToOne
    @JoinColumn(name = "dining-item-id", referencedColumnName = "id")
    @JsonIgnore
    private DiningItem diningItem;
    @ManyToOne
    @JoinColumn(name = "owner-id", referencedColumnName = "id")
    @JsonIgnore
    private User owner;
    private Date createdAt;


    public FavouriteDiningItem(DiningItem diningItem,
                               User owner, Date createdAt) {
        this.diningItem = diningItem;
        this.owner = owner;
        this.createdAt = createdAt;
    }
}
