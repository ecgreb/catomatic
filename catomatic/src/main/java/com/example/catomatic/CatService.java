package com.example.catomatic;

import retrofit.Callback;
import retrofit.client.Response;
import retrofit.http.GET;

public interface CatService {
    @GET("/")
    void test(Callback<Response> callback);
}
