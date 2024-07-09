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
@Table(name = "FAVOURITE-BUSINESS")
@NoArgsConstructor
@Setter
@Getter

public class FavouriteBusiness {

    @Id
    @GeneratedValue
    private Integer id;
    @ManyToOne
    @JoinColumn(name = "business-id", referencedColumnName = "id")
    @JsonIgnore
    private Business business;
    @ManyToOne
    @JoinColumn(name = "owner-id", referencedColumnName = "id")
    @JsonIgnore
    private User owner;
    private Date createdAt;


    public FavouriteBusiness(Business business, User owner, Date createdAt) {
        this.business = business;
        this.owner = owner;
        this.createdAt = createdAt;
    }
}
