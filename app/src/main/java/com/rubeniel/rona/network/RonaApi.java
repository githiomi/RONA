package com.rubeniel.rona.network;

import com.rubeniel.rona.models.Country;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface RonaApi {

//    Get method
    @GET("summary")
    Call<List<Country>> getCountryData();
}
