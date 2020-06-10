package com.rubeniel.rona.network;

import com.rubeniel.rona.models.FlagsSearchResult;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface FlagApi {

//    Custom method to get the countries data
    @GET("all")
    Call<FlagsSearchResult> getFlags();
}
