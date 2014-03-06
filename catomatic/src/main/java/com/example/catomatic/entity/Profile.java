package com.example.catomatic.entity;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class Profile {
    @SerializedName("access_token") public String accessToken;
    public ArrayList<Cat> cats;

    @Override
    public String toString() {
        return "Profile{" +
                "accessToken='" + accessToken + '\'' +
                ", cats=" + cats +
                '}';
    }
}
