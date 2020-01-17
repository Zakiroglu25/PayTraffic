package com.aris.paytraffic.model;

public class RequestUserLogin {
    private String phone;
    private String password;

    public RequestUserLogin(String phone, String password) {
        this.phone = phone;
        this.password = password;
    }

    public RequestUserLogin(String s) {
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
