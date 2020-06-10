package com.rubeniel.rona.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.MenuItemCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.SearchView;
import android.widget.TextView;

import com.rubeniel.rona.adapters.CountriesAdapter;
import com.rubeniel.rona.R;
import com.rubeniel.rona.models.Country;
import com.rubeniel.rona.models.FlagsSearchResult;
import com.rubeniel.rona.models.RonaSearchResult;
import com.rubeniel.rona.network.FlagApi;
import com.rubeniel.rona.network.FlagClient;
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
    @BindView(R.id.progressBar) ProgressBar mProgressBar;
    @BindView(R.id.tvError) TextView mError;

//    Local variables
    List<Country> mCountries;
    List<String> mCountryNames;
    CountriesAdapter mCountriesAdapter;
//    String mFlags;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        Butter knife binding
        ButterKnife.bind(this);

        getCoronaData();
//        getFlagData();
    }

//        Menu inflation
    @Override
    public boolean onCreateOptionsMenu(Menu menu){

        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.search_country_menu, menu);
        ButterKnife.bind(this);

        MenuItem menuItem = menu.findItem(R.id.country_search);
        SearchView searchView = (SearchView) MenuItemCompat.getActionView(menuItem);

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
//                mCountriesAdapter.getFilter().filter(query);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                mCountriesAdapter.getFilter().filter(newText);
                return true;
            }
        });
        return true;
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

                    showRetrievedData();

                    mCountriesAdapter = new CountriesAdapter(mCountries, getApplicationContext());
                    RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(MainActivity.this);

                    mCountriesRecyclerView.setLayoutManager(layoutManager);
                    mCountriesRecyclerView.setAdapter(mCountriesAdapter);
                    mCountriesRecyclerView.setHasFixedSize(true);

                }else {
                    Log.d(TAG, "onResponse: not successful ------------------------");
                    unSuccessfulResponse();
                }
            }

            @Override
            public void onFailure(Call<RonaSearchResult> call, Throwable t) {
                Log.d(TAG, "onFailure: Error -----------------" + t );
                unSuccessfulRequest();
            }
        });
    }

//    Custom method to get the country flags
//    private void getFlagData() {
//        Log.d(TAG, "getFlagData: Get flag init");
//
//        FlagApi flagClient = FlagClient.getFlagClient();
//
//        Call<FlagsSearchResult> flagsSearchResultCall = flagClient.getFlags();
//
//        flagsSearchResultCall.enqueue(new Callback<FlagsSearchResult>() {
//            @Override
//            public void onResponse(Call<FlagsSearchResult> call, Response<FlagsSearchResult> response) {
//                Log.d(TAG, "onResponse: Can get a response");
//
//                if (response.isSuccessful()) {
//                    showRetrievedData();
//
//                    mFlags = response.body().getFlag();
//
//                    Log.d(TAG, "onResponse: ---------------------------------- Flags:" + mFlags);
//
//                } else {
//                    showRetrievedData();
//
//                    Log.d(TAG, "onResponse: Made call but got no data");
//
//                }
//
//            }
//
//            @Override
//            public void onFailure(Call<FlagsSearchResult> call, Throwable t) {
//                Log.d(TAG, "onFailure: Can't get a response");
//            }
//        });
//    }

//    Custom method to make progress bar dissapear
    public void showRetrievedData() {
        mProgressBar.setVisibility(View.GONE);
        mCountriesRecyclerView.setVisibility(View.VISIBLE);
    }

    public void unSuccessfulResponse() {
        mProgressBar.setVisibility(View.GONE);
        mError.setText("Unable to retrieve data from API");
    }

    public void unSuccessfulRequest() {
        mProgressBar.setVisibility(View.GONE);
        mError.setText("Unable to connect to API");
    }

}