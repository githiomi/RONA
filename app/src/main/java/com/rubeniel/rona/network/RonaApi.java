package com.rubeniel.rona.network;

import com.rubeniel.rona.models.Country;
import com.rubeniel.rona.models.RonaSearchResult;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface RonaApi {

//    Get method
    @GET("summary")
    Call<RonaSearchResult> getCountryData();
}
