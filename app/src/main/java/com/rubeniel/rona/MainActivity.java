package com.rubeniel.rona;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.rubeniel.rona.models.Country;
import com.rubeniel.rona.network.RonaApi;
import com.rubeniel.rona.network.RonaClient;

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

        Call< List<Country> > call = ronaApi.getCountryData();

        call.enqueue(new Callback<List<Country>>() {
            @Override
            public void onResponse(Call<List<Country>> call, Response<List<Country>> response) {

                if (response.isSuccessful()) {
                    Log.d(TAG, "onResponse: is successful");

                    mCountries = response.body();

                    for (int i = 0; i < mCountries.size(); i += 1) {

                        Country country = mCountries.get(i);

                        String countryName = country.getCountry();
                        Log.d(TAG, "onResponse; Name of the country is " + countryName);
                        mCountryNames.add(countryName);

                    }
                } else {
                    Log.d(TAG, "onResponse: not successful");

                    mOnlyTextView.setText("Not successful!");

                }

            }

            @Override
            public void onFailure(Call<List<Country>> call, Throwable t) {
                Log.d(TAG, "onFailure: " + t);
            }
        });
    }


}