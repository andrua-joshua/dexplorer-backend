package com.dhotels.hotelsbackend.modules;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Data
@Table(name = "Businesses")
@NoArgsConstructor
@Setter
@Getter
public class Business {

    @Id
    @GeneratedValue
    private Integer id;
    private String businessName;
    private String address;
    private String city;
    private Integer rating;
    private List<String> amenities;
    @ManyToOne
    @JoinColumn(name = "currency_id", referencedColumnName = "id")
    private Currency currency;
    @ManyToOne
    @JoinColumn(name = "business_type_id", referencedColumnName = "id")
    private BusinessType businessType;
    @OneToMany(cascade = CascadeType.REMOVE, fetch = FetchType.LAZY, mappedBy = "business")
    private List<DiningItem> diningItemList;
    @OneToMany(cascade = CascadeType.REMOVE, fetch = FetchType.LAZY, mappedBy = "business")
    private List<Room> roomList;
    @ManyToOne()
    @JoinColumn(name = "owner-id", referencedColumnName = "id")
    @JsonIgnore
    private User owner;
    private List<String> images;
    @OneToMany(mappedBy = "business", cascade = CascadeType.REMOVE, fetch = FetchType.LAZY)
    private List<FavouriteBusiness> favouriteBusinesses;
    private Date createdAt;


    public Business(String businessName, String address, String city,
                    Integer rating, ArrayList<String> amenities,
                    Currency currency, BusinessType businessType,
                    List<DiningItem> diningItemList, List<Room> roomList,
                    User owner, List<String> images, List<FavouriteBusiness> favouriteBusinesses,
                    Date createdAt) {
        this.businessName = businessName;
        this.address = address;
        this.city = city;
        this.rating = rating;
        this.amenities = amenities;
        this.currency = currency;
        this.businessType = businessType;
        this.diningItemList = diningItemList;
        this.roomList = roomList;
        this.owner = owner;
        this.images = images;
        this.favouriteBusinesses = favouriteBusinesses;
        this.createdAt = createdAt;
    }

    public Integer getId() {
        return id;
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

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public List<String> getAmenities() {
        return amenities;
    }

    public void setAmenities(List<String> amenities) {
        this.amenities = amenities;
    }

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    public BusinessType getBusinessType() {
        return businessType;
    }

    public void setBusinessType(BusinessType businessType) {
        this.businessType = businessType;
    }

    public List<DiningItem> getDiningItemList() {
        return diningItemList;
    }

    public void setDiningItemList(List<DiningItem> diningItemList) {
        this.diningItemList = diningItemList;
    }

    public List<Room> getRoomList() {
        return roomList;
    }

    public void setRoomList(List<Room> roomList) {
        this.roomList = roomList;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    public List<String> getImages() {
        return images;
    }

    public void setImages(List<String> images) {
        this.images = images;
    }

    public List<FavouriteBusiness> getFavouriteBusinesses() {
        return favouriteBusinesses;
    }

    public void setFavouriteBusinesses(List<FavouriteBusiness> favouriteBusinesses) {
        this.favouriteBusinesses = favouriteBusinesses;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }
}
