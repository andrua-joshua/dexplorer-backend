package com.dhotels.hotelsbackend.helpers;

import java.util.Date;

public class BookingByDateRequest {

    public Date BookingDate;

    public BookingByDateRequest(Date bookingDate) {
        BookingDate = bookingDate;
    }

    public Date getBookingDate() {
        return BookingDate;
    }

    public void setBookingDate(Date bookingDate) {
        BookingDate = bookingDate;
    }
}
