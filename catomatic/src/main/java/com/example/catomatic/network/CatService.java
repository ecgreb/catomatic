package com.example.catomatic.network;

import com.example.catomatic.entity.AllegedUser;
import com.example.catomatic.entity.Cat;
import com.example.catomatic.entity.Profile;

import retrofit.Callback;
import retrofit.http.Body;
import retrofit.http.GET;
import retrofit.http.Header;
import retrofit.http.POST;
import retrofit.http.Path;

public interface CatService {
    @POST("/login")
    void login(@Body AllegedUser user, Callback<Profile> callback);

    @GET("/cats/{id}")
    void cat(@Path("id") long id, Callback<Cat> callback);

    @GET("/cats/{id}")
    void secureCat(@Header("access_token") String accessToken,
            @Path("id") long id, Callback<Cat> callback);
}
