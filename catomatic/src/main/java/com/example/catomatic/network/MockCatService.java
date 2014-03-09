package com.example.catomatic.network;

import com.example.catomatic.entity.AllegedUser;
import com.example.catomatic.entity.Cat;
import com.example.catomatic.entity.Profile;

import java.util.ArrayList;

import retrofit.Callback;
import retrofit.client.Header;
import retrofit.client.Response;
import retrofit.http.Body;
import retrofit.mime.TypedString;

public class MockCatService implements CatService {
    @Override
    public void login(@Body AllegedUser allegedUser, Callback<Profile> callback) {
        ArrayList<Cat> cats = new ArrayList<Cat>();
        cats.add(new Cat(1, "Cat 1", 1, "This is cat 1.", "http://placekitten.com/64/64"));
        cats.add(new Cat(2, "Cat 2", 2, "This is cat 2.", "http://placekitten.com/64/64"));
        cats.add(new Cat(3, "Cat 3", 3, "This is cat 3.", "http://placekitten.com/64/64"));
        callback.success(new Profile(cats), getMockResponse());
    }

    private Response getMockResponse() {
        return new Response("", 200, "", new ArrayList<Header>(), new TypedString(""));
    }
}
