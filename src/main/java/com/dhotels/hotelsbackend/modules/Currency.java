package com.dhotels.hotelsbackend.modules;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;

@Entity
@Data
@Table(name = "CURRENCIES")
public class Currency {

    @Id
    @GeneratedValue
    private Integer id;
    @Column( unique = true)
    private String currencySymbol;
    private String description;
    @Column(unique = true)
    private String country;
    private String countryFlag;
    @OneToMany(mappedBy = "currency", cascade = CascadeType.REMOVE, fetch = FetchType.LAZY)
    @JsonIgnore
    private ArrayList<Business> businesses;


    public Currency(String currencySymbol, String description,
                    String country, String countryFlag,
                    ArrayList<Business> businesses) {
        this.currencySymbol = currencySymbol;
        this.description = description;
        this.country = country;
        this.countryFlag = countryFlag;
        this.businesses = businesses;
    }


    public Integer getId() {
        return id;
    }

    public String getCurrencySymbol() {
        return currencySymbol;
    }

    public void setCurrencySymbol(String currencySymbol) {
        this.currencySymbol = currencySymbol;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCountryFlag() {
        return countryFlag;
    }

    public void setCountryFlag(String countryFlag) {
        this.countryFlag = countryFlag;
    }

    public ArrayList<Business> getBusinesses() {
        return businesses;
    }

    public void setBusinesses(ArrayList<Business> businesses) {
        this.businesses = businesses;
    }
}
