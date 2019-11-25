package com.lijunyan.mvpframe.http;

import android.util.Log;


import com.lijunyan.mvpframe.app.Constants;

import java.util.concurrent.TimeUnit;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;


/**
 * Created by jingpeng on 2017/5/14.
 */

public enum Api {
    INSTANCE;

    private static final String TAG = Api.class.getSimpleName();

    private Retrofit retrofit;
    private ApiService service;

    public ApiService getApiService() {
        return INSTANCE.service;
    }

    Api() {
        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor(new HttpLoggingInterceptor.Logger() {
            @Override
            public void log(String message) {
                Log.d(TAG, message);
            }
        });
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient client = new OkHttpClient.Builder()
                .addInterceptor(loggingInterceptor)
                .addInterceptor(loggingInterceptor)
                .connectTimeout(Constants.TIME_OUT, TimeUnit.SECONDS)
                .readTimeout(Constants.TIME_OUT, TimeUnit.SECONDS)
                .writeTimeout(Constants.TIME_OUT, TimeUnit.SECONDS)
                .build();
        retrofit = new Retrofit.Builder()
                .baseUrl(Constants.BASE_URL)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        service = retrofit.create(ApiService.class);
    }



}