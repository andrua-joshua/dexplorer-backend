package com.dhotels.hotelsbackend.services;

import com.dhotels.hotelsbackend.repositories.BookingRepository;
import com.dhotels.hotelsbackend.repositories.RoomRespository;
import com.dhotels.hotelsbackend.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookingService {

    @Autowired
    RoomRespository roomRespository;

    @Autowired
    BookingRepository bookingRepository;

    @Autowired
    UserRepository userRepository;


    ///todo {bookings}
    ///book room
    ///extend booking
    ///checkout of booking
    ///get bookings by user
    ///get bookings by room
    ///get booking by date
    ///get booking by date range
    ///get Active bookings of user
    ///get past bookings of a user




}
