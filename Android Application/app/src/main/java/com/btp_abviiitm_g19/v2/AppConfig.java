package com.btp_abviiitm_g19.v2;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class AppConfig {
    public static String BASE_URL = "https://eab1c265.ngrok.io";
    public static Retrofit getRetrofit() {
        return new Retrofit.Builder().client(GetClient()).baseUrl(AppConfig.BASE_URL).addConverterFactory(GsonConverterFactory.create()).build();
    }
    public static OkHttpClient GetClient(){
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BASIC);
        
        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
        return  httpClient.addInterceptor(logging).build();
    }
}  