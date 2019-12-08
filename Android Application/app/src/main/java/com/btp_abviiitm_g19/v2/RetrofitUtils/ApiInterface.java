package com.btp_abviiitm_g19.v2.RetrofitUtils;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;
 
 
public interface ApiInterface {
    @GET("/")
    Call<Model> getData(@Query("symptoms") String apiKey);

}