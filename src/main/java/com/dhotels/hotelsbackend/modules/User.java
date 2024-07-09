package com.dhotels.hotelsbackend.modules;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.List;

@Entity
@Data
@Table(name = "USERS")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Builder
public class User {

    @Id
    @GeneratedValue
    private Integer id;
    private String fullName;
    @Column(unique = true)
    private String email;
    private String phone;
    private String password;
    @OneToMany(mappedBy = "client", cascade = CascadeType.REMOVE, fetch = FetchType.LAZY)
    private List<Booking> bookings;
    @OneToMany(mappedBy = "owner", cascade = CascadeType.REMOVE, fetch = FetchType.LAZY)
    private List<Business> businesses;
    @OneToMany(mappedBy = "client", cascade = CascadeType.REMOVE, fetch = FetchType.LAZY)
    private List<DiningCart> diningCarts;
    @OneToMany(mappedBy = "client", cascade = CascadeType.REMOVE, fetch = FetchType.LAZY)
    private List<DiningOrder> diningOrders;
    @OneToMany(mappedBy = "owner", cascade = CascadeType.REMOVE, fetch = FetchType.LAZY)
    private List<FavouriteBusiness> favouriteBusinesses;
    @OneToMany(mappedBy = "owner", cascade = CascadeType.REMOVE, fetch = FetchType.LAZY)
    private List<FavouriteDiningItem> favouriteDiningItems;
    @OneToMany(mappedBy = "owner", cascade = CascadeType.REMOVE, fetch = FetchType.LAZY)
    private List<Notification> notifications;
    @OneToMany(mappedBy = "owner", cascade = CascadeType.REMOVE, fetch = FetchType.LAZY)
    private List<Transaction> transactions;
    private Date createdAt;


    public User(String fullName, String email, String phone, String password,
                List<Booking> bookings, List<Business> businesses,
                List<DiningCart> diningCarts, List<DiningOrder> diningOrders,
                List<FavouriteBusiness> favouriteBusinesses, List<FavouriteDiningItem> favouriteDiningItems,
                List<Notification> notifications, List<Transaction> transactions, Date createdAt) {
        this.fullName = fullName;
        this.email = email;
        this.phone = phone;
        this.password = password;
        this.bookings = bookings;
        this.businesses = businesses;
        this.diningCarts = diningCarts;
        this.diningOrders = diningOrders;
        this.favouriteBusinesses = favouriteBusinesses;
        this.favouriteDiningItems = favouriteDiningItems;
        this.notifications = notifications;
        this.transactions = transactions;
        this.createdAt = createdAt;
    }


    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Booking> getBookings() {
        return bookings;
    }

    public void setBookings(List<Booking> bookings) {
        this.bookings = bookings;
    }

    public List<Business> getBusinesses() {
        return businesses;
    }

    public void setBusinesses(List<Business> businesses) {
        this.businesses = businesses;
    }

    public List<DiningCart> getDiningCarts() {
        return diningCarts;
    }

    public void setDiningCarts(List<DiningCart> diningCarts) {
        this.diningCarts = diningCarts;
    }

    public List<DiningOrder> getDiningOrders() {
        return diningOrders;
    }

    public void setDiningOrders(List<DiningOrder> diningOrders) {
        this.diningOrders = diningOrders;
    }

    public List<FavouriteBusiness> getFavouriteBusinesses() {
        return favouriteBusinesses;
    }

    public void setFavouriteBusinesses(List<FavouriteBusiness> favouriteBusinesses) {
        this.favouriteBusinesses = favouriteBusinesses;
    }

    public List<FavouriteDiningItem> getFavouriteDiningItems() {
        return favouriteDiningItems;
    }

    public void setFavouriteDiningItems(List<FavouriteDiningItem> favouriteDiningItems) {
        this.favouriteDiningItems = favouriteDiningItems;
    }

    public List<Notification> getNotifications() {
        return notifications;
    }

    public void setNotifications(List<Notification> notifications) {
        this.notifications = notifications;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<Transaction> transactions) {
        this.transactions = transactions;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }
}
