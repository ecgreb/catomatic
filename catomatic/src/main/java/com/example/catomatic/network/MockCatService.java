package com.example.catomatic.network;

import com.example.catomatic.entity.AllegedUser;
import com.example.catomatic.entity.Cat;
import com.example.catomatic.entity.Profile;

import java.util.ArrayList;
import java.util.List;

import retrofit.Callback;
import retrofit.client.Header;
import retrofit.client.Response;
import retrofit.http.Body;
import retrofit.http.Path;
import retrofit.mime.TypedString;

public class MockCatService implements CatService {
    @Override
    public void login(@Body AllegedUser allegedUser, Callback<Profile> callback) {
        callback.success(new Profile(), getMockResponse());
    }

    @Override
    public void cats(Callback<List<Cat>> callback) {
        callback.success(new ArrayList<Cat>(), getMockResponse());
    }

    @Override
    public void cat(@Path("id") long id, Callback<Cat> callback) {
        callback.success(new Cat(), getMockResponse());
    }

    private Response getMockResponse() {
        return new Response("", 200, "", new ArrayList<Header>(), new TypedString(""));
    }
}
