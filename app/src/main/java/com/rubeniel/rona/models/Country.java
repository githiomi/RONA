package com.rubeniel.rona.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Country {

    @SerializedName("Country")
    @Expose
    private String country;
    @SerializedName("CountryCode")
    @Expose
    private String countryCode;
    @SerializedName("Slug")
    @Expose
    private String slug;
    @SerializedName("NewConfirmed")
    @Expose
    private Integer newConfirmed;
    @SerializedName("TotalConfirmed")
    @Expose
    private Integer totalConfirmed;
    @SerializedName("NewDeaths")
    @Expose
    private Integer newDeaths;
    @SerializedName("TotalDeaths")
    @Expose
    private Integer totalDeaths;
    @SerializedName("NewRecovered")
    @Expose
    private Integer newRecovered;
    @SerializedName("TotalRecovered")
    @Expose
    private Integer totalRecovered;
    @SerializedName("Date")
    @Expose
    private String date;

    /**
     * No args constructor for use in serialization
     *
     */
    public Country() {
    }

    /**
     *
     * @param date
     * @param country
     * @param newDeaths
     * @param newRecovered
     * @param countryCode
     * @param totalDeaths
     * @param newConfirmed
     * @param totalRecovered
     * @param slug
     * @param totalConfirmed
     */
    public Country(String country, String countryCode, String slug, Integer newConfirmed, Integer totalConfirmed, Integer newDeaths, Integer totalDeaths, Integer newRecovered, Integer totalRecovered, String date) {
        super();
        this.country = country;
        this.countryCode = countryCode;
        this.slug = slug;
        this.newConfirmed = newConfirmed;
        this.totalConfirmed = totalConfirmed;
        this.newDeaths = newDeaths;
        this.totalDeaths = totalDeaths;
        this.newRecovered = newRecovered;
        this.totalRecovered = totalRecovered;
        this.date = date;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public Integer getNewConfirmed() {
        return newConfirmed;
    }

    public void setNewConfirmed(Integer newConfirmed) {
        this.newConfirmed = newConfirmed;
    }

    public Integer getTotalConfirmed() {
        return totalConfirmed;
    }

    public void setTotalConfirmed(Integer totalConfirmed) {
        this.totalConfirmed = totalConfirmed;
    }

    public Integer getNewDeaths() {
        return newDeaths;
    }

    public void setNewDeaths(Integer newDeaths) {
        this.newDeaths = newDeaths;
    }

    public Integer getTotalDeaths() {
        return totalDeaths;
    }

    public void setTotalDeaths(Integer totalDeaths) {
        this.totalDeaths = totalDeaths;
    }

    public Integer getNewRecovered() {
        return newRecovered;
    }

    public void setNewRecovered(Integer newRecovered) {
        this.newRecovered = newRecovered;
    }

    public Integer getTotalRecovered() {
        return totalRecovered;
    }

    public void setTotalRecovered(Integer totalRecovered) {
        this.totalRecovered = totalRecovered;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

}
