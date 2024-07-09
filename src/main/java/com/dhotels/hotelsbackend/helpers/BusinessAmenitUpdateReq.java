package com.dhotels.hotelsbackend.helpers;

import java.util.List;

public class BusinessAmenitUpdateReq {

    private Integer businessId;
    private List<String> amenities;

    public BusinessAmenitUpdateReq(Integer userId, List<String> amenities) {
        this.businessId = userId;
        this.amenities = amenities;
    }


    public Integer getBusinessId() {
        return businessId;
    }

    public void setBusinessId(Integer businessId) {
        this.businessId = businessId;
    }

    public List<String> getAmenities() {
        return amenities;
    }

    public void setAmenities(List<String> amenities) {
        this.amenities = amenities;
    }
}
