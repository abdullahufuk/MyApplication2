package com.example.hp.myapplication;

import android.os.Parcel;
import android.os.Parcelable;

public class Dersler implements Parcelable {

    private String caption;
    private String description;

    public String getCaption() {
        return caption;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {

    }
}
