package com.example.myfirstapp.rest;

import com.example.myfirstapp.model.Clase;
import com.example.myfirstapp.model.HorarioClase;
import com.example.myfirstapp.model.Miembro;
import com.example.myfirstapp.model.PlanNutrional;
import com.example.myfirstapp.model.PlanNutrionalDetalle;
import com.example.myfirstapp.model.Programa;
import com.example.myfirstapp.model.Rutina;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import okhttp3.ResponseBody;
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

    /******************* Device Token Notificaciones *******************/
    @POST("deviceToken")
    Call<ResponseBody> registrarDeviceToken(@Body Map<String, String> body);

    /******************* Miembro *******************/
    @GET("miembro")
    Call<List<Miembro>> obtenerMiembros(@Query("api_key") String apiKey);

    @GET("miembro/{id}")
    Call<Miembro> getMiembroPorId(@Path("id") int id);

    @POST("miembro")
    Call<Miembro> crearMiembro();

    /******************* Programa/RutinasActivity *******************/
    @GET("miembro/{miembroId}/programas")
    Call<List<Programa>> getProgramasPorMiembroId(@Path("miembroId") int miembroId);

    @GET("programa/{programaId}/rutinas")
    Call<List<Rutina>> getRutinasPorProgramaId(@Path("programaId") int programaId);

    /******************* PlanNutrional/PlanNutrionalDetalle *******************/

    @GET("miembro/{miembroId}/PlanNutricional")
    Call<List<PlanNutrional>> getPlanNutrionalPorMiembroI(@Path("miembroId") int miembroId);

    @GET("PlanNutricional/{plannutrionalId}/PlanNutricionalDetalle")
    Call<List<PlanNutrionalDetalle>> getPlanNutrionalPorPlanID(@Path("plannutrionalId") int plannutrionalId);

    /******************* Clase/HorarioClase *******************/
    @GET("clase")
    Call<List<Clase>> getclase();

    @GET("clase/{claseId}/horarios")
    Call<List<HorarioClase>> getHorarioClase(@Path("claseId") int claseId);

}
