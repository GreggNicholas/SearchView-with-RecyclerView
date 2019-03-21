package com.example.searchviewwithrecyclerview.Model;

import java.util.List;

public class PlanetOuterClass {
    private List<Planet> planetList;

    public PlanetOuterClass(List<Planet> planetList) {
        this.planetList = planetList;
    }

    public List<Planet> getPlanetList() {
        return planetList;
    }
}
