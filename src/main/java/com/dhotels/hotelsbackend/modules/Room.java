package com.dhotels.hotelsbackend.modules;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Table(name = "ROOMS")
@NoArgsConstructor
@Setter
@Getter
public class Room {

    @Id
    @GeneratedValue
    private Integer id;
    private String roomNumber;
    private Integer capacity;
    private Integer beds;
    private List<String> amenities;
    private String description;
    @ManyToOne
    @JoinColumn(name = "room_type_id", referencedColumnName = "id")
    private RoomType roomType;
    @ManyToOne
    @JoinColumn(name = "business-id", referencedColumnName = "id")
    @JsonIgnore
    private Business business;
    private double price;
    @OneToMany(mappedBy = "room", cascade = CascadeType.REMOVE, fetch = FetchType.LAZY)
    private List<Booking> bookings;
    private List<String> images;
    @OneToMany(mappedBy = "room", cascade = CascadeType.REMOVE, fetch = FetchType.LAZY)
    private List<Package> packages;


    public Room(
            String roomNumber, Integer capacity, Integer beds,
            List<String> amenities, String description,
            RoomType roomType, Business business, double price,
            List<Booking> bookings, List<String> images,
            List<Package> packages) {
        this.roomNumber = roomNumber;
        this.capacity = capacity;
        this.beds = beds;
        this.amenities = amenities;
        this.description = description;
        this.roomType = roomType;
        this.business = business;
        this.price = price;
        this.bookings = bookings;
        this.images = images;
        this.packages = packages;
    }


    public Integer getId() {
        return id;
    }

    public String getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public int getBeds() {
        return beds;
    }

    public void setBeds(int beds) {
        this.beds = beds;
    }

    public List<String> getAmenities() {
        return amenities;
    }

    public void setAmenities(ArrayList<String> amenities) {
        this.amenities = amenities;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public RoomType getRoomType() {
        return roomType;
    }

    public void setRoomType(RoomType roomType) {
        this.roomType = roomType;
    }

    public Business getBusiness() {
        return business;
    }

    public void setBusiness(Business business) {
        this.business = business;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public List<Booking> getBookings() {
        return bookings;
    }

    public void setBookings(List<Booking> bookings) {
        this.bookings = bookings;
    }

    public List<String> getImages() {
        return images;
    }

    public void setImages(List<String> images) {
        this.images = images;
    }

    public List<Package> getPackages() {
        return packages;
    }

    public void setPackages(List<Package> packages) {
        this.packages = packages;
    }
}
