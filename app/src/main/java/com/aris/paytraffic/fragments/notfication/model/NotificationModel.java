package com.aris.paytraffic.fragments.notfication.model;

import java.time.LocalDateTime;

public class NotificationModel {

    private String name;
    private String prossesName;
    private LocalDateTime prossesDare;

    public NotificationModel(String name, String prossesName, LocalDateTime prossesDare) {
        this.name = name;
        this.prossesName = prossesName;
        this.prossesDare = prossesDare;
    }

    public NotificationModel() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProssesName() {
        return prossesName;
    }

    public void setProssesName(String prossesName) {
        this.prossesName = prossesName;
    }

    public LocalDateTime getProssesDare() {
        return prossesDare;
    }

    public void setProssesDare(LocalDateTime prossesDare) {
        this.prossesDare = prossesDare;
    }

    @Override
    public String toString() {
        return "NotificationModel{" +
                "name='" + name + '\'' +
                ", prossesName='" + prossesName + '\'' +
                ", prossesDare=" + prossesDare +
                '}';
    }
}
