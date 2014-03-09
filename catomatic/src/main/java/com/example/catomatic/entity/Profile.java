package com.example.catomatic.entity;

import java.util.ArrayList;

public class Profile {
    public ArrayList<Cat> cats;

    public Profile(ArrayList<Cat> cats) {
        this.cats = cats;
    }

    @Override
    public String toString() {
        return "Profile{" +
                "cats=" + cats +
                '}';
    }
}
