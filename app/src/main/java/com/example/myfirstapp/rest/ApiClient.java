package com.example.myfirstapp.rest;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by M.Franco on 2/18/2017.
 */

public class ApiClient {

    public static final String BASE_URL = "http://10.0.2.2:50639/api/";
    private static Retrofit retrofit = null;


    public static Retrofit getClient() {
        OkHttpClient.Builder oK = new OkHttpClient.Builder();

        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);
        oK.addInterceptor(logging);

        if (retrofit==null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(oK.build())
                    .build();
        }
        return retrofit;
    }
}
