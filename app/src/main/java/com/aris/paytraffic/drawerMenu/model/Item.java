package com.aris.paytraffic.drawerMenu.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by rafael.meyer on 8/24/16.
 */
public class Item implements Parcelable {

    private String name;
    private String card;

    public Item(String name, String card) {
        this.name = name;
        this.card = card;
    }

    protected Item(Parcel in) {
        name = in.readString();
        card = in.readString();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCard() {
        return card;
    }

    public void setColor(String card) {
        this.card = card;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(card);
    }

    public static final Creator<Item> CREATOR = new Creator<Item>() {
        @Override
        public Item createFromParcel(Parcel in) {
            return new Item(in);
        }

        @Override
        public Item[] newArray(int size) {
            return new Item[size];
        }
    };
}
