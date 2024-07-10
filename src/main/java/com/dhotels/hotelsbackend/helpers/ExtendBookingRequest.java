package com.dhotels.hotelsbackend.helpers;

import java.util.Date;

public class ExtendBookingRequest {

    private Date toDate;
    private Integer userId;


    public ExtendBookingRequest(Date toDate, Integer userId) {
        this.toDate = toDate;
        this.userId = userId;
    }

    public Date getToDate() {
        return toDate;
    }

    public void setToDate(Date toDate) {
        this.toDate = toDate;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }
}
