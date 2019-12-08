package com.btp_abviiitm_g19.v2.RetrofitUtils;

import com.google.gson.annotations.SerializedName;

public class Model {
    @SerializedName("data")
    private String data;

    public String getData() {
        return data;
    }
}
