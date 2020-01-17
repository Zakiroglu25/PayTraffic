package com.aris.paytraffic.model;

public class UserModel {
    private long id;
    private String fullname;
    private String email;
    private String phone;
    private String idCardNumber;

    public UserModel(long id, String fullname, String email, String phone, String idCardNumber) {
        this.id = id;
        this.fullname = fullname;
        this.email = email;
        this.phone = phone;
        this.idCardNumber = idCardNumber;
    }

    public UserModel() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
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

    public String getIdCardNumber() {
        return idCardNumber;
    }

    public void setIdCardNumber(String idCardNumber) {
        this.idCardNumber = idCardNumber;
    }
}
