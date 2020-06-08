package com.rubeniel.rona;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.rubeniel.rona.models.Country;
import com.rubeniel.rona.models.RonaSearchResult;
import com.rubeniel.rona.network.RonaApi;
import com.rubeniel.rona.network.RonaClient;

import org.json.JSONException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

//    TAG
    private static final String TAG = MainActivity.class.getSimpleName();

//    Binding widgets
    @BindView(R.id.onlyView) TextView mOnlyTextView;

//    Local variables
    List<Country> mCountries;
    List<String> mCountryNames;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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

                    for ( int i = 0; i < mCountries.size(); i += 1 ) {

                        String countryName = mCountries.get(i).getCountry();
                        mCountryNames.add(countryName);

                        Log.d(TAG, "onResponse: Country name: --------------------" + countryName);
                    }


                }else {
                    Log.d(TAG, "onResponse: not successful ------------------------");

                    mOnlyTextView.setText("Not successful!");

                }

            }

            @Override
            public void onFailure(Call<RonaSearchResult> call, Throwable t) {

            }
        });
    }


}