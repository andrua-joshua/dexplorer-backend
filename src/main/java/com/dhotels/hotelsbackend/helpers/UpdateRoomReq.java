package com.dhotels.hotelsbackend.helpers;

public class UpdateRoomReq {

    private String roomNumber;
    private Integer capacity;
    private Integer beds;
    private String description;
    private Integer roomType;
    private double price;

    public UpdateRoomReq(String roomNumber, Integer capacity,
                         Integer beds, String description,
                         Integer roomType, double price) {
        this.roomNumber = roomNumber;
        this.capacity = capacity;
        this.beds = beds;
        this.description = description;
        this.roomType = roomType;
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

    public Integer getBeds() {
        return beds;
    }

    public void setBeds(Integer beds) {
        this.beds = beds;
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

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
