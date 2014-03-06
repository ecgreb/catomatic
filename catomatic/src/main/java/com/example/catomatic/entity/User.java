package com.example.catomatic.entity;

import com.google.gson.annotations.SerializedName;

public class User {
    @SerializedName("user_id") public long userId;
    public String name;
    public String email;
}
