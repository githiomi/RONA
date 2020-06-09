package com.rubeniel.rona.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.os.Parcel;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.rubeniel.rona.R;
import com.rubeniel.rona.models.Country;
import com.squareup.picasso.Picasso;

import org.parceler.Parcels;

import butterknife.BindView;
import butterknife.ButterKnife;

public class CountryDetailFragment extends Fragment {

//    Binding widgets
    @BindView(R.id.ivCountryFlag) ImageView mCountryFlag;
    @BindView(R.id.newConfirmed) TextView mNewConfirmed;
    @BindView(R.id.totalConfirmed) TextView mTotalConfirmed;
    @BindView(R.id.newDeaths) TextView mNewDeaths;
    @BindView(R.id.totalDeaths) TextView mTotalDeaths;
    @BindView(R.id.newRecovered) TextView mNewRecovered;
    @BindView(R.id.totalRecovered) TextView mTotalRecovered;

//    Class of the data to be recieved
    public Country mCountry;

//    Integers to style picasso
    private static final int MAX_WIDTH = 200;
    private static final int MAX_HEIGHT = 200;

    public CountryDetailFragment() {
        // Required empty public constructor
    }

    public static CountryDetailFragment newInstance(Country country) {
        CountryDetailFragment fragment = new CountryDetailFragment();
        Bundle args = new Bundle();
        args.putParcelable("country", Parcels.wrap(country));
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mCountry = Parcels.unwrap(getArguments().getParcelable("country"));
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.fragment_country_detail, container, false);
        ButterKnife.bind(this, view);

        mNewConfirmed.setText("New confirmed cases: " + mCountry.getNewConfirmed());
        mTotalConfirmed.setText("Total confirmed cases: " + mCountry.getTotalConfirmed());
        mNewDeaths.setText("New reported deaths: " + mCountry.getNewDeaths());
        mTotalDeaths.setText("Total reported deaths: " + mCountry.getTotalDeaths());
        mNewRecovered.setText("New recovered cases: " + mCountry.getNewRecovered());
        mTotalRecovered.setText("Total recovered cases: " + mCountry.getTotalRecovered());

        return view;
    }
}