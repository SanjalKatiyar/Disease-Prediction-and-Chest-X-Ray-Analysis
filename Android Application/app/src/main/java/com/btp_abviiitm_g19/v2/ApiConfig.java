package com.btp_abviiitm_g19.v2;

import okhttp3.MultipartBody;
import retrofit2.Call;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;

public interface ApiConfig {
    @Multipart
    @POST("/")
    Call<ServerResponse> uploadFile(@Part MultipartBody.Part file);
    
}