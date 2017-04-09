package com.example.myfirstapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.ListAdapter;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import com.example.myfirstapp.adapter.MiembrosAdapter;
import com.example.myfirstapp.helper.SystemPreferencesHelper;
import com.example.myfirstapp.model.Miembro;
import com.example.myfirstapp.model.MiembrosResponse;
import com.example.myfirstapp.rest.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class ListaMiembroActivity extends AppCompatActivity {
    private static final String TAG = ListaMiembroActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_miembro);

        final LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        final RecyclerView recyclerView = (RecyclerView) findViewById(R.id.movies_recycler_view);
        recyclerView.setLayoutManager(layoutManager);

        ApiInterface apiService =
                ApiClient.getClient().create(ApiInterface.class);
        int idMiembroActivo = SystemPreferencesHelper.getPreferenceInt(ControlGymApplication.getContext(), "IdMiembro");


        Call<Miembro> call = apiService.getMiembroPorId(idMiembroActivo);

        call.enqueue(new Callback<Miembro>() {
            @Override
            public void onResponse(Call<Miembro>call, Response<Miembro> response) {
                Miembro miembro = response.body();
                if (response.code() == 200) {

                   miembro = response.body();
                List <Miembro> miembros=new ArrayList<Miembro>();
                miembros.add(miembro);

                    recyclerView.setAdapter(new MiembrosAdapter(miembros, R.layout.list_miembro, getApplicationContext()));
                } else {
                    Toast.makeText(ControlGymApplication.getContext(), "Acceso no autorizado. Status code: "+Integer.toString(response.code()), Toast.LENGTH_SHORT).show();
                    Log.e(TAG, Integer.toString(response.code()));
                }
            }

            @Override
            public void onFailure(Call<Miembro>call, Throwable t) {
                // Log error here since request failed
                Log.e(TAG, t.toString());
            }
        });
    }
}
