package com.example.retrofittest.model;

import android.util.Log;

import com.example.retrofittest.Bean.Phone;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class PhoneModelImlp implements PhoneModel{


    private final String baseUrl = "http://apis.juhe.cn/";
    private final String mobile = "mobile";
    private final String key = "5778e9d9cf089fc3b093b162036fc0e1";

    @Override
    public void getPhone(String phone,final OnPhoneListener mListener) {

        //创建Retrofit对象
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        PhoneService phoneService = retrofit.create(PhoneService.class);
        Call<Phone> call = phoneService.getPathData(mobile,phone,key);
        call.enqueue(new Callback<Phone>() {
            @Override
            public void onResponse(Call<Phone> call, Response<Phone> response) {
                Phone phone = response.body();
                if(phone.getReason().equals("Return Successd!")){
                    mListener.onSuccess(phone);
                }else {
                    mListener.onError();
                }
            }

            @Override
            public void onFailure(Call<Phone> call, Throwable t) {
                Log.d("aaa", "onFailure: " + t.getMessage());
                mListener.onError();
            }
        });
    }
}
