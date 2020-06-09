package com.rubeniel.rona;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.rubeniel.rona.models.Country;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class CountriesAdapter extends RecyclerView.Adapter<CountriesAdapter.CountryViewHolder> {

//    TAG
    private static final String TAG = CountriesAdapter.class.getSimpleName();

//    Required variables
    List<Country> mCountries = new ArrayList<>();
    Context mContext;

    public CountriesAdapter(List<Country> mCountries, Context mContext) {
        this.mCountries = mCountries;
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public CountriesAdapter.CountryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.country_list_item_layout, parent, false);
        CountryViewHolder countryViewHolder = new CountryViewHolder(view);
        return countryViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull CountriesAdapter.CountryViewHolder holder, int position) {
        holder.bindCountry(mCountries.get(position));
    }

    @Override
    public int getItemCount() {
        return mCountries.size();
    }

//    Nested class view holder
    public class CountryViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

//        Binding views
        @BindView(R.id.tvCountryCode) TextView mCountryCode;
        @BindView(R.id.tvCountryName) TextView mCountryName;
        @BindView(R.id.ronaImage) ImageView mImageView;

        public CountryViewHolder(@NonNull View itemView) {
            super(itemView);

            ButterKnife.bind(this, itemView);
            mContext = itemView.getContext();
            itemView.setOnClickListener(this);

        }

        public void bindCountry(Country country){

            mCountryCode.setText(country.getCountryCode());
            mCountryName.setText(country.getCountry());

            Picasso.get().load(R.drawable.rona)
                        .into(mImageView);

        }
//Overriding the onclick method
    @Override
    public void onClick(View v) {
        Toast.makeText(mContext, "Country: " + mCountryName, Toast.LENGTH_SHORT).show();
    }
}
}


