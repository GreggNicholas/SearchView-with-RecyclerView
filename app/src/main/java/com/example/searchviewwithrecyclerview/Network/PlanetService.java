package com.example.searchviewwithrecyclerview.Network;

import com.example.searchviewwithrecyclerview.Model.PlanetOuterClass;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface PlanetService {

    String END_POINT = "/JDVila/storybook/master/planets.json";
    @GET(END_POINT)
    Observable<PlanetOuterClass> getPlanetAPIResponse();
}
