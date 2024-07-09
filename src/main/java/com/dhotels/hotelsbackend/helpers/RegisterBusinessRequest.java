package com.dhotels.hotelsbackend.helpers;

public class RegisterBusinessRequest {

    private String businessName;
    private String address;
    private String city;
    private Integer currency;
    private Integer businessType;

    public RegisterBusinessRequest(String businessName, String address,
                                   String city, Integer currency,
                                   Integer businessType) {
        this.businessName = businessName;
        this.address = address;
        this.city = city;
        this.currency = currency;
        this.businessType = businessType;
    }


    public String getBusinessName() {
        return businessName;
    }

    public void setBusinessName(String businessName) {
        this.businessName = businessName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Integer getCurrency() {
        return currency;
    }

    public void setCurrency(Integer currency) {
        this.currency = currency;
    }

    public Integer getBusinessType() {
        return businessType;
    }

    public void setBusinessType(Integer businessType) {
        this.businessType = businessType;
    }
}
