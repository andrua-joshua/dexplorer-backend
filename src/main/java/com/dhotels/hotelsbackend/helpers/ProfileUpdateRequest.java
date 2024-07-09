package com.dhotels.hotelsbackend.helpers;

import org.springframework.stereotype.Component;


public class ProfileUpdateRequest {

    private String fullName;
    private String email;
    private String phone;


    public ProfileUpdateRequest(
            String fullName,
            String email,
            String phone
    ){
        this.fullName = fullName;
        this.email = email;
        this.phone= phone;
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
}
