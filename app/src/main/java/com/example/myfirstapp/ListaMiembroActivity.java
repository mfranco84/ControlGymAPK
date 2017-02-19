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
import com.example.myfirstapp.model.Miembro;
import com.example.myfirstapp.model.MiembrosResponse;
import com.example.myfirstapp.rest.*;

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

        /*if (API_KEY.isEmpty()) {
            Toast.makeText(getApplicationContext(), "Please obtain your API KEY first from themoviedb.org", Toast.LENGTH_LONG).show();
            return;
        }*/

        final LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        final RecyclerView recyclerView = (RecyclerView) findViewById(R.id.movies_recycler_view);
        recyclerView.setLayoutManager(layoutManager);

        ApiInterface apiService =
                ApiClient.getClient().create(ApiInterface.class);

//        Call<Miembro> call = apiService.getMiembroPorId(8, "");
        Call<List<Miembro>> call = apiService.obtenerMiembros("");
        call.enqueue(new Callback<List<Miembro>>() {
            @Override
            public void onResponse(Call<List<Miembro>>call, Response<List<Miembro>> response) {
                //Log.e(TAG, "response.body().getResults(): " + response.body().getNombre());
                //Miembro[] miembros = new Miembro[]{response.body()};
                List<Miembro> miembros = response.body();

                Log.d(TAG, "Number of miembros received: " + miembros.size());
                recyclerView.setAdapter(new MiembrosAdapter(miembros, R.layout.list_miembro, getApplicationContext()));
            }

            @Override
            public void onFailure(Call<List<Miembro>>call, Throwable t) {
                // Log error here since request failed
                Log.e(TAG, t.toString());
            }
        });
    }
}
