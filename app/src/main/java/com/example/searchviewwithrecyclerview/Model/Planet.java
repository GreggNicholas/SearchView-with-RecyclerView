package com.example.searchviewwithrecyclerview.Model;

public class Planet {
    private String name;
    private String image;

    public Planet(String name, String image) {
        this.name = name;
        this.image = image;
    }

    public String getPlanetName() {
        return name;
    }

    public String getPlanetImage() {
        return image;
    }
}
