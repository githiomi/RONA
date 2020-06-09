package com.rubeniel.rona.adapters;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.rubeniel.rona.fragments.CountryDetailFragment;
import com.rubeniel.rona.models.Country;

import java.util.List;

public class CountryPagerAdapter extends FragmentPagerAdapter {

//    Local variable for the countries passes id
    private List<Country> countries;


    public CountryPagerAdapter(FragmentManager fm, List<Country> enteredCountries) {
        super(fm);
        this.countries = enteredCountries;
    }

    @Override
    public Fragment getItem(int position) {
        return CountryDetailFragment.newInstance(countries.get(position));
    }

    @Override
    public int getCount() {
        return countries.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return countries.get(position).getCountry();
    }
}
