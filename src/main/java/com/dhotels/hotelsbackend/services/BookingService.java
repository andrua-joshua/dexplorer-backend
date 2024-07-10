package com.dhotels.hotelsbackend.services;

import com.dhotels.hotelsbackend.exception.InvalidCredentialsException;
import com.dhotels.hotelsbackend.exception.ResourceNotFoubdException;
import com.dhotels.hotelsbackend.exception.UnAuthorizedException;
import com.dhotels.hotelsbackend.helpers.BookingByDateRangeRequest;
import com.dhotels.hotelsbackend.helpers.BookingByDateRequest;
import com.dhotels.hotelsbackend.helpers.BookingRequest;
import com.dhotels.hotelsbackend.helpers.ExtendBookingRequest;
import com.dhotels.hotelsbackend.modules.Booking;
import com.dhotels.hotelsbackend.modules.Room;
import com.dhotels.hotelsbackend.modules.User;
import com.dhotels.hotelsbackend.repositories.BookingRepository;
import com.dhotels.hotelsbackend.repositories.RoomRespository;
import com.dhotels.hotelsbackend.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Objects;

@Service
public class BookingService {

    @Autowired
    RoomRespository roomRespository;

    @Autowired
    BookingRepository bookingRepository;

    @Autowired
    UserRepository userRepository;


    ///todo {bookings}
    ///book room  ----/
    ///extend booking ----/
    ///checkout of booking
    ///get bookings by client  ----/
    ///get bookings by room  ----/
    ///get booking by date  ----/
    ///get booking by date range  ----/
    ///get Active bookings of user
    ///get past bookings of a user

    int millSecsPerDay = 86400000;

    public Booking makeBooking(Integer userId, BookingRequest bookingRequest){

        User client = userRepository.findById(
                userId
        ).orElseThrow(
                ()-> new ResourceNotFoubdException(
                        "User not found"
                )
        );

        Room room = roomRespository.findById(
                bookingRequest.getRoom()
        ).orElseThrow(
                ()-> new ResourceNotFoubdException(
                        "Room not found"
                )
        );

        long x = (bookingRequest.getToDate().getTime()
                - bookingRequest.getFromDate().getTime())
                /millSecsPerDay;

        int days = (int) x;

        Booking booking = new Booking(
                bookingRequest.getFromDate(),
                bookingRequest.getToDate(),
                room.getPrice()*days,
                client,
                room,
                new Date()
        );

        Booking savedBooking = bookingRepository.save(booking);

        client.getBookings().add(booking);
        room.getBookings().add(booking);

        userRepository.save(client);
        roomRespository.save(room);

        return savedBooking;
    }


    public Booking extendBooking(Integer bookingId, ExtendBookingRequest extendBookingRequest){
        Booking booking = bookingRepository.findById(
                bookingId
        ).orElseThrow(
                ()-> new ResourceNotFoubdException(
                        "Booking not found"
                )
        );

        User bookingClient = booking.getClient();
        User requestingUser = userRepository.findById(
                extendBookingRequest.getUserId()
        ).orElseThrow(
                ()-> new ResourceNotFoubdException(
                        "user not found"
                )
        );

        if(Objects.equals(bookingClient.getId(), requestingUser.getId())){
            if(booking.getToDate().before(extendBookingRequest.getToDate())){

                bookingClient.getBookings().remove(booking);

                booking.setToDate(extendBookingRequest.getToDate());

            }else {
                throw new InvalidCredentialsException(
                        "Wrong date was passed"
                );
            }
        }else throw new UnAuthorizedException("Unauthorized access");

        Booking savedBooking = bookingRepository.save(booking);

        bookingClient.getBookings().add(savedBooking);

        userRepository.save(bookingClient);
        return savedBooking;
    }


    public List<Booking> getBookingsByUser(Integer userId){
        User user  = userRepository.findById(
                userId
        ).orElseThrow(
                ()-> new ResourceNotFoubdException(
                        "User with Provided Id not found"
                )
        );

        return bookingRepository.findByClient(user).orElseThrow(
                ()-> new ResourceNotFoubdException(
                        "Resource Not found Exception"
                )
        );
    }


    public List<Booking> getBookingsByRoom(Integer roomId){
        Room room = roomRespository.findById(roomId)
                .orElseThrow(
                        ()-> new ResourceNotFoubdException(
                                "Room with provided id not found"
                        )
                );

        return bookingRepository.findByRoom(room).orElseThrow(
                ()-> new ResourceNotFoubdException(
                        "Resource Not found Exception"
                )
        );
    }

    //the date is the date the booking was made not booking start and end dates
    public List<Booking> getBookingsByBookingDate(BookingByDateRequest bookingByDateRequest){

        return bookingRepository.findByCreatedAt(bookingByDateRequest.getBookingDate())
                .orElseThrow(
                ()-> new ResourceNotFoubdException(
                        "Resource Not found Exception"
                )
        );
    }


    public List<Booking> getBookingsCreatedBetweenDate(
            BookingByDateRangeRequest bookingByDateRangeReq){

        return bookingRepository.findByCreatedBetween(
                bookingByDateRangeReq.getStartDate(),
                        bookingByDateRangeReq.getEndDate())
                .orElseThrow(
                        ()-> new ResourceNotFoubdException(
                                "Resource Not found Exception"
                        )
                );
    }

}
