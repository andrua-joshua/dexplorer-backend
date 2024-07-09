package com.dhotels.hotelsbackend.helpers;

public class NewRoomRequest {

    private String roomNumber;
    private Integer capacity;
    private Integer bed;
    private String description;
    private Integer roomType;
    private Integer business;
    private double price;


    public NewRoomRequest(String roomNumber, Integer capacity,
                          Integer bed, String description,
                          Integer roomType, Integer business,
                          double price) {
        this.roomNumber = roomNumber;
        this.capacity = capacity;
        this.bed = bed;
        this.description = description;
        this.roomType = roomType;
        this.business = business;
        this.price = price;
    }


    public String getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }

    public Integer getBed() {
        return bed;
    }

    public void setBed(Integer bed) {
        this.bed = bed;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getRoomType() {
        return roomType;
    }

    public void setRoomType(Integer roomType) {
        this.roomType = roomType;
    }

    public Integer getBusiness() {
        return business;
    }

    public void setBusiness(Integer business) {
        this.business = business;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
