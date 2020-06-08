package com.rubeniel.rona.models;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class RonaSearchResult {

    @SerializedName("Global")
    @Expose
    private Global global;
    @SerializedName("Countries")
    @Expose
    private List<Country> countries = null;

    /**
     * No args constructor for use in serialization
     *
     */
    public RonaSearchResult() {
    }

    /**
     *
     * @param global
     * @param countries
     */
    public RonaSearchResult(Global global, List<Country> countries) {
        super();
        this.global = global;
        this.countries = countries;
    }

    public Global getGlobal() {
        return global;
    }

    public void setGlobal(Global global) {
        this.global = global;
    }

    public List<Country> getCountries() {
        return countries;
    }

    public void setCountries(List<Country> countries) {
        this.countries = countries;
    }

}