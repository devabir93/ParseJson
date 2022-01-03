package com.ucas.android.parsejson.model;

import com.google.gson.annotations.SerializedName;

class Rating {
    @SerializedName("rate")
    double rate;

    @SerializedName("count")
    int count;

    public Rating() {
    }

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
