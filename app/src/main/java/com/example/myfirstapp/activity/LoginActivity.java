package com.example.myfirstapp.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.myfirstapp.ListaMiembroActivity;
import com.example.myfirstapp.PlanNutrional;
import com.example.myfirstapp.R;
import com.example.myfirstapp.adapter.MiembrosAdapter;
import com.example.myfirstapp.model.Miembro;
import com.example.myfirstapp.rest.ApiClient;
import com.example.myfirstapp.rest.ApiInterface;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {
    private static final String TAG = ListaMiembroActivity.class.getSimpleName();
    Button Loginn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Loginn=(Button) findViewById(R.id.btn_login);
        Loginn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                enviarDatosLogin("jacklin@gmail.com", "clave");
                Intent Loginn=new Intent(LoginActivity.this, PlanNutrional.class);
                startActivity(Loginn);

            }
        });
    }

    private void enviarDatosLogin(String correo, String password){

        ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);
        // Generando parametros json
        Map<String, String> params = new HashMap<>();
        params.put("Correo", correo);
        params.put("Clave", password);
        //Llamando metodo POST con el objecto correspondiente como parametro
        Call<Miembro> call = apiService.autenticar(params);
        call.enqueue(new Callback<Miembro>() {
            @Override
            public void onResponse(Call<Miembro>call, Response<Miembro> response) {
                Log.e(TAG, "response.body().getResults(): " + response.body().getToken());
                Miembro miembro = response.body();

            }

            @Override
            public void onFailure(Call<Miembro>call, Throwable t) {
                // Log error here since request failed
                Log.e(TAG, t.toString());
            }
        });
    }
}
