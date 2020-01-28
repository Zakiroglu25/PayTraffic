package com.aris.paytraffic.fragments.mainMenu.model;

import java.time.LocalDateTime;

public class ShablonModel {
    private String procesName;
    private LocalDateTime date;
    private int price;

    public static ShablonModel create(){
        return new ShablonModel().setProcesName("Azercell");
    }



    public String getProcesName() {
        return procesName;
    }

    public ShablonModel setProcesName(String procesName) {
        this.procesName = procesName;
        return null;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
