package com.rubeniel.rona.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.rubeniel.rona.R;
import com.rubeniel.rona.adapters.CountryPagerAdapter;
import com.rubeniel.rona.models.Country;

import org.parceler.Parcels;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class CountryDetailActivity extends AppCompatActivity {

//    Local variables
    // All the list of countires
    private List<Country> mCountries;
    // Custom pager adapter
    private CountryPagerAdapter mCountryPagerAdapter;

//    Binding views
    @BindView(R.id.ViewPagerContainer) ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_country_detail);

//        Butterknife binding views
        ButterKnife.bind(this);

//        Obtaining data
        mCountries = Parcels.unwrap(getIntent().getParcelableExtra("countries"));
        int startingPoint = getIntent().getIntExtra("position", 0);


        mCountryPagerAdapter = new CountryPagerAdapter(getSupportFragmentManager(), mCountries);

        mViewPager.setAdapter(mCountryPagerAdapter);
        mViewPager.setCurrentItem(startingPoint);

    }
}