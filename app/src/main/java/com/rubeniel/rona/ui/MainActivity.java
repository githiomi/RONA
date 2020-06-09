package com.rubeniel.rona.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.rubeniel.rona.CountriesAdapter;
import com.rubeniel.rona.R;
import com.rubeniel.rona.models.Country;
import com.rubeniel.rona.models.RonaSearchResult;
import com.rubeniel.rona.network.RonaApi;
import com.rubeniel.rona.network.RonaClient;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

//    TAG
    private static final String TAG = MainActivity.class.getSimpleName();

//    Binding widgets
    @BindView(R.id.rvCountires) RecyclerView mCountriesRecyclerView;

//    Local variables
    List<Country> mCountries;
    List<String> mCountryNames;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        Butter knife binding
        ButterKnife.bind(this);

        getCoronaData();
    }

//    Custom method to get data from the API
    private void getCoronaData() {
        Log.d(TAG, "getCoronaData: init corona call");

        RonaApi ronaApi = RonaClient.getClient();

        Call<RonaSearchResult> ronaSearchResultCall = ronaApi.getCountryData();

        ronaSearchResultCall.enqueue(new Callback<RonaSearchResult>() {
            @Override
            public void onResponse(Call<RonaSearchResult> call, Response<RonaSearchResult> response) {

                if ( response.isSuccessful() ) {
                    Log.d(TAG, "onResponse: is successful ------------------------");

                    mCountryNames = new ArrayList<>();

                    mCountries = response.body().getCountries();

                    CountriesAdapter mCountriesAdapter = new CountriesAdapter(mCountries, getApplicationContext());
                    RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(MainActivity.this);

                    mCountriesRecyclerView.setLayoutManager(layoutManager);
                    mCountriesRecyclerView.setAdapter(mCountriesAdapter);
                    mCountriesRecyclerView.setHasFixedSize(true);

//                    for ( int i = 0; i < mCountries.size(); i += 1 ) {
//
//                        String countryName = mCountries.get(i).getCountry();
//                        mCountryNames.add(countryName);
//
//                        Log.d(TAG, "onResponse: Country name: --------------------" + countryName);
//                    }


                }else {
                    Log.d(TAG, "onResponse: not successful ------------------------");
                }

            }

            @Override
            public void onFailure(Call<RonaSearchResult> call, Throwable t) {
                Log.d(TAG, "onFailure: Error -----------------" + t );
            }
        });
    }


}