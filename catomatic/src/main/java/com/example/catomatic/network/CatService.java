package com.example.catomatic.network;

import com.example.catomatic.entity.AllegedUser;
import com.example.catomatic.entity.Profile;

import retrofit.Callback;
import retrofit.http.Body;
import retrofit.http.POST;

public interface CatService {
    @POST("/login")
    void login(@Body AllegedUser user, Callback<Profile> callback);
}
