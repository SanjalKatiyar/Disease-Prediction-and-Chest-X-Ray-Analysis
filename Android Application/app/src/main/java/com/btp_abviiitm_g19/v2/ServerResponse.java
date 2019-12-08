package com.btp_abviiitm_g19.v2;

import com.google.gson.annotations.SerializedName;

public class ServerResponse {
    @SerializedName("data")
    private String data;

    public String getData() {
        return data;
    }
}
