package com.example.catomatic.entity;

import com.google.gson.annotations.SerializedName;

public class Cat {
    @SerializedName("cat_id") public long catId;
    public String name;
    public int age;
    @SerializedName("small_photo_url") public String smallPhotoUrl;
    @SerializedName("short_description") public String shortDescription;
}
