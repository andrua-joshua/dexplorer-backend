package com.dhotels.hotelsbackend.helpers;

import org.springframework.stereotype.Component;


public class SignUpRequest {

    private String fullName;
    private String email;
    private String phone;
    private String password;

    public SignUpRequest(String fullname, String email, String phone, String password){
        this.email = email;
        this.phone = phone;
        this.fullName = fullname;
        this.password = password;
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
}
