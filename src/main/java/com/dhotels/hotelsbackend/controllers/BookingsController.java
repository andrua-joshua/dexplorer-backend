package com.dhotels.hotelsbackend.controllers;

import com.dhotels.hotelsbackend.helpers.BookingByDateRangeRequest;
import com.dhotels.hotelsbackend.helpers.BookingByDateRequest;
import com.dhotels.hotelsbackend.helpers.BookingRequest;
import com.dhotels.hotelsbackend.helpers.ExtendBookingRequest;
import com.dhotels.hotelsbackend.modules.Booking;
import com.dhotels.hotelsbackend.services.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/bookings")
public class BookingsController {

    @Autowired
    BookingService bookingService;


    @ResponseBody
    @PostMapping("/makeBooking/{id}")
    public ResponseEntity<Booking> createBooking(
            @PathVariable("id") Integer userId,
            @RequestBody BookingRequest bookingRequest
            ){

        Booking booking = bookingService.makeBooking(
                userId,
                bookingRequest
        );

        return  new ResponseEntity<Booking>(
                booking, HttpStatus.CREATED
        );
    }


    @ResponseBody
    @PostMapping("/extendBooking/{id}")
    public ResponseEntity<Booking> extendBooking(
            @PathVariable("id") Integer bookingId,
            @RequestBody ExtendBookingRequest extendBookingRequest
            ){

        Booking booking = bookingService.extendBooking(
                bookingId,
                extendBookingRequest
        );

        return  new ResponseEntity<Booking>(
                booking, HttpStatus.OK
        );
    }


    @ResponseBody
    @GetMapping("/getBookingByUser/{id}")
    public ResponseEntity<List<Booking>> getBookingsByUser(
            @PathVariable("id") Integer userId
    ){

        List<Booking> bookings = bookingService.getBookingsByUser(userId);

        return new ResponseEntity<List<Booking>>(
                bookings, HttpStatus.OK
        );
    }


    @ResponseBody
    @GetMapping("/getBookingByRoom/{id}")
    public ResponseEntity<List<Booking>> getBookingsByRoom(
            @PathVariable("id") Integer roomId
    ){

        List<Booking> bookings = bookingService.getBookingsByRoom(roomId);

        return new ResponseEntity<List<Booking>>(
                bookings, HttpStatus.OK
        );
    }


    @ResponseBody
    @GetMapping("/getBookingByDate")
    public ResponseEntity<List<Booking>> getBookingsByDate(
            @RequestBody BookingByDateRequest bookingByDateRequest
            ){

        List<Booking> bookings = bookingService.getBookingsByBookingDate(bookingByDateRequest);

        return new ResponseEntity<List<Booking>>(
                bookings, HttpStatus.OK
        );
    }


    @ResponseBody
    @GetMapping("/getBookingByDateRange")
    public ResponseEntity<List<Booking>> getBookingsByDateRange(
            @RequestBody BookingByDateRangeRequest bookingByDateRangeRequest
            ){

        List<Booking> bookings = bookingService.getBookingsCreatedBetweenDate(
                bookingByDateRangeRequest
        );

        return new ResponseEntity<List<Booking>>(
                bookings, HttpStatus.OK
        );
    }


}
