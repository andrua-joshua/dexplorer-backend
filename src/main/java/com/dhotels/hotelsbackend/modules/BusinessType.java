package com.dhotels.hotelsbackend.modules;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;

@Entity
@Data
@Table(name = "BUSINESS-TYPES")
public class BusinessType {

    @Id
    @GeneratedValue
    private Integer id;
    @Column(unique = true)
    private String name;
    private String description;
    @OneToMany(mappedBy = "businessType", cascade = CascadeType.REMOVE, fetch = FetchType.LAZY)
    @JsonIgnore
    private ArrayList<Business> businesses;


    public BusinessType(String name, String description,
                        ArrayList<Business> businesses) {
        this.name = name;
        this.description = description;
        this.businesses = businesses;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ArrayList<Business> getBusinesses() {
        return businesses;
    }

    public void setBusinesses(ArrayList<Business> businesses) {
        this.businesses = businesses;
    }
}
