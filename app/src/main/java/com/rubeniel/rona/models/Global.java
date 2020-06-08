package com.rubeniel.rona.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Global {

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

    /**
     * No args constructor for use in serialization
     *
     */
    public Global() {
    }

    /**
     *
     * @param newDeaths
     * @param newRecovered
     * @param totalDeaths
     * @param newConfirmed
     * @param totalRecovered
     * @param totalConfirmed
     */
    public Global(Integer newConfirmed, Integer totalConfirmed, Integer newDeaths, Integer totalDeaths, Integer newRecovered, Integer totalRecovered) {
        super();
        this.newConfirmed = newConfirmed;
        this.totalConfirmed = totalConfirmed;
        this.newDeaths = newDeaths;
        this.totalDeaths = totalDeaths;
        this.newRecovered = newRecovered;
        this.totalRecovered = totalRecovered;
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

}