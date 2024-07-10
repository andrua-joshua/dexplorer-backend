package com.dhotels.hotelsbackend.helpers;

import java.util.Date;

public class BookingRequest {

    private Date fromDate;
    private Date toDate;
    private Integer room;


    public BookingRequest(Date fromDate, Date toDate, Integer room) {
        this.fromDate = fromDate;
        this.toDate = toDate;
        this.room = room;
    }


    public Date getFromDate() {
        return fromDate;
    }

    public void setFromDate(Date fromDate) {
        this.fromDate = fromDate;
    }

    public Date getToDate() {
        return toDate;
    }

    public void setToDate(Date toDate) {
        this.toDate = toDate;
    }

    public Integer getRoom() {
        return room;
    }

    public void setRoom(Integer room) {
        this.room = room;
    }
}
