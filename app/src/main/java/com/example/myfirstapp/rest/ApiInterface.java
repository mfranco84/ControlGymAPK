package com.example.myfirstapp.rest;

import com.example.myfirstapp.model.Miembro;
import com.example.myfirstapp.model.MiembrosResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by M.Franco on 2/18/2017.
 */

public interface ApiInterface {
    @GET("miembro")
    Call<List<Miembro>> obtenerMiembros(@Query("api_key") String apiKey);

    @GET("miembro/{id}")
    Call<Miembro> getMiembroPorId(@Path("id") int id, @Query("api_key") String apiKey);

    @POST("miembro")
    Call<Miembro> crearMiembro();
}
