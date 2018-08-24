package com.example.prasetyo.dictionary.model;

import android.os.Parcel;
import android.os.Parcelable;

public class Kamus implements Parcelable {
    private int id;
    private String indonesia;
    private String inggris;

    public Kamus(){

    }

    public Kamus(String indonesia, String inggris){
        this.indonesia = indonesia;
        this.inggris = inggris;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIndonesia() {
        return indonesia;
    }

    public void setIndonesia(String indonesia) {
        this.indonesia = indonesia;
    }

    public String getInggris() {
        return inggris;
    }

    public void setInggris(String inggris) {
        this.inggris = inggris;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.id);
        dest.writeString(this.indonesia);
        dest.writeString(this.inggris);
    }

    protected Kamus(Parcel in) {
        this.id = in.readInt();
        this.indonesia = in.readString();
        this.inggris = in.readString();
    }

    public static final Parcelable.Creator<Kamus> CREATOR = new Parcelable.Creator<Kamus>() {
        @Override
        public Kamus createFromParcel(Parcel source) {
            return new Kamus(source);
        }

        @Override
        public Kamus[] newArray(int size) {
            return new Kamus[size];
        }
    };
}
