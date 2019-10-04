package com.example.retrofittest.model;


import com.example.retrofittest.Bean.Phone;

import java.util.Observable;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;


public interface PhoneService {

    @GET("{mobile}/get?")
    Call<Phone> getPathData(@Path("mobile") String mobile, @Query("phone") String phone, @Query("key") String key);
}
