package com.example.myfirstapp.rest;

import com.example.myfirstapp.model.Miembro;
import com.example.myfirstapp.model.Programa;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.Field;

/**
 * Created by M.Franco on 2/18/2017.
 */

public interface ApiInterface {
    /******************* Login *******************/
    @POST("loginMiembro")
    Call<Miembro> autenticar(@Body Map<String, String> body);

    /******************* Miembro *******************/
    @GET("miembro")
    Call<List<Miembro>> obtenerMiembros(@Query("api_key") String apiKey);

    @GET("miembro/{id}")
    Call<Miembro> getMiembroPorId(@Path("id") int id, @Query("api_key") String apiKey);

    @POST("miembro")
    Call<Miembro> crearMiembro();

    /******************* Programa/Rutinas *******************/
    @GET("miembro/{miembroId}/programas")
    Call<List<Programa>> getProgramasPorMiembroId(@Path("miembroId") int miembroId);
}
