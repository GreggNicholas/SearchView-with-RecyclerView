package com.example.searchviewwithrecyclerview.View;

import android.annotation.SuppressLint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.util.Log;

import com.example.searchviewwithrecyclerview.Controller.PlanetAdapter;
import com.example.searchviewwithrecyclerview.Model.Planet;
import com.example.searchviewwithrecyclerview.Model.PlanetOuterClass;
import com.example.searchviewwithrecyclerview.Network.PlanetService;
import com.example.searchviewwithrecyclerview.Network.RetrofitSingleton;
import com.example.searchviewwithrecyclerview.R;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity implements SearchView.OnQueryTextListener {
    private static final String TAG = "MainActivity";
    private List<Planet> planetList = new ArrayList<>();
    private RecyclerView recyclerView;
    private PlanetAdapter planetAdapter;

    @SuppressLint("CheckResult")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SearchView searchView = findViewById(R.id.cardview_searchview);
        recyclerView = findViewById(R.id.main_recyclerview);

        searchView.setOnQueryTextListener(this);

        Retrofit retrofit = RetrofitSingleton.getInstance();
        retrofit.create(PlanetService.class)
                .getPlanetAPIResponse()
                .subscribeOn(Schedulers.io())
                .map(PlanetOuterClass::getPlanetList)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe((List<Planet> planets) -> {
                            planetList.addAll(planets);
                            planetAdapter = new PlanetAdapter(planetList);
                            recyclerView.setAdapter(planetAdapter);
                            recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
                        },
                        throwable -> Log.e(TAG, "onFailure: " + throwable));
    }

    @Override
    public boolean onQueryTextSubmit(String s) {
        return false;
    }

    @Override
    public boolean onQueryTextChange(String s) {
        List<Planet> planetList2 = new LinkedList<>();
        for (Planet planet : planetList) {
            if (planet.getPlanetName()
                    .toLowerCase()
                    .startsWith(s.toLowerCase())) {
                planetList2.add(planet);
            }
        }
        planetAdapter.setData(planetList2);
        return false;
    }
}
