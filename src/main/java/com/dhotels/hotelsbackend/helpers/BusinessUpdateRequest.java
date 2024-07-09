package com.dhotels.hotelsbackend.helpers;

public class BusinessUpdateRequest {

    private String businessName;
    private String address;
    private String city;
    private Integer currency;

    public BusinessUpdateRequest(String businessName,
                                 String address, String city,
                                 Integer currency) {
        this.businessName = businessName;
        this.address = address;
        this.city = city;
        this.currency = currency;
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
}
