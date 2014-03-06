package com.example.catomatic.entity;

import com.google.gson.annotations.SerializedName;

import android.os.Parcel;
import android.os.Parcelable;

public class Cat implements Parcelable {
    public long id;
    public String name;
    public int ageInMonths;
    @SerializedName("short_description") public String shortDescription;
    @SerializedName("small_photo_url") public String smallPhotoUrl;

    public Cat() {
    }

    @Override
    public String toString() {
        return "Cat{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", ageInMonths=" + ageInMonths +
                ", shortDescription='" + shortDescription + '\'' +
                ", smallPhotoUrl='" + smallPhotoUrl + '\'' +
                '}';
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeLong(this.id);
        dest.writeString(this.name);
        dest.writeInt(this.ageInMonths);
        dest.writeString(this.shortDescription);
        dest.writeString(this.smallPhotoUrl);
    }

    private Cat(Parcel in) {
        this.id = in.readLong();
        this.name = in.readString();
        this.ageInMonths = in.readInt();
        this.shortDescription = in.readString();
        this.smallPhotoUrl = in.readString();
    }

    public static Parcelable.Creator<Cat> CREATOR = new Parcelable.Creator<Cat>() {
        public Cat createFromParcel(Parcel source) {
            return new Cat(source);
        }

        public Cat[] newArray(int size) {
            return new Cat[size];
        }
    };
}
