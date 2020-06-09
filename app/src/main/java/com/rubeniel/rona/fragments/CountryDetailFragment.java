package com.rubeniel.rona.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.rubeniel.rona.R;

public class CountryDetailFragment extends Fragment {

    private static final int MAX_WIDTH = 200;
    private static final int MAX_HEIGHT = 200;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public CountryDetailFragment() {
        // Required empty public constructor
    }

    public static CountryDetailFragment newInstance(String param1, String param2) {
        CountryDetailFragment fragment = new CountryDetailFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_country_detail, container, false);
    }
}