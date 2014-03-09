package com.example.catomatic.network;

import com.example.catomatic.entity.AllegedUser;
import com.example.catomatic.entity.Cat;
import com.example.catomatic.entity.Profile;

import java.util.ArrayList;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Header;
import retrofit.client.Response;
import retrofit.http.Body;
import retrofit.http.Path;
import retrofit.mime.TypedString;

public class MockCatService implements CatService {
    @Override
    public void login(@Body AllegedUser allegedUser, Callback<Profile> callback) {
        ArrayList<Cat> cats = new ArrayList<Cat>();
        cats.add(new Cat(1, "Cat 1", 1, "This is cat 1.", "http://placekitten.com/64/64"));
        cats.add(new Cat(2, "Cat 2", 2, "This is cat 2.", "http://placekitten.com/64/64"));
        cats.add(new Cat(3, "Cat 3", 3, "This is cat 3.", "http://placekitten.com/64/64"));
        callback.success(new Profile("fake_access_token", cats), getMockResponse());
    }

    @Override
    public void cat(@Path("id") long id, Callback<Cat> callback) {
        callback.success(new Cat(1,
                "Cat " + id,
                (int) id,
                "This is cat " + id,
                "http://placekitten.com/64/64",
                "This is a really long description of cat " + id,
                "http://placekitten.com/128/128"),
                getMockResponse());
    }

    @Override
    public void secureCat(@retrofit.http.Header("access_token") String accessToken,
            @Path("id") long id,
            Callback<Cat> callback) {

        if (accessToken == "fake_access_token") {
            callback.success(new Cat(1,
                    "Cat " + id,
                    (int) id,
                    "This is cat " + id,
                    "http://placekitten.com/64/64",
                    "This is a really long description of secure cat " + id,
                    "http://placekitten.com/128/128"),
                    getMockResponse());
        } else {
            callback.failure(getMockError());
        }
    }

    private Response getMockResponse() {
        return new Response("", 200, "", new ArrayList<Header>(), new TypedString(""));
    }

    private Response getMockErrorResponse() {
        return new Response("", 401, "", new ArrayList<Header>(), new TypedString(""));
    }

    private RetrofitError getMockError() {
        return RetrofitError.httpError("", getMockErrorResponse(), null, null);
    }
}
