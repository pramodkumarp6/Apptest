package com.pramod.apptest.aap;

import com.pramod.apptest.models.DefaultResponse;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface Api {



    @FormUrlEncoded
    @POST("register")
    Call<DefaultResponse> createUser(
    );

    @FormUrlEncoded
    @POST("login")
    Call<DefaultResponse> userLogin(
    );

}
