package com.example.myfirstapp.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.myfirstapp.ControlGymApplication;
import com.example.myfirstapp.Horarios;
import com.example.myfirstapp.Notificaciones;
import com.example.myfirstapp.R;
import com.example.myfirstapp.adapter.ClaseAdapter;
import com.example.myfirstapp.adapter.ProgramasAdapter;
import com.example.myfirstapp.helper.SystemPreferencesHelper;
import com.example.myfirstapp.model.Clase;
import com.example.myfirstapp.model.Programa;
import com.example.myfirstapp.rest.ApiClient;
import com.example.myfirstapp.rest.ApiInterface;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Erick on 27/3/2017.
 */

public class ClaseActivity extends ControlGymBaseActivity {

    private static final String TAG = ClaseActivity.class.getSimpleName();
    ArrayList<String> opcionList;

    ListView drawer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clases);

        drawer = (ListView) findViewById(R.id.drawer);
        opcionList = new ArrayList<String>();
        opcionList.add("Plan Nutricional");
        opcionList.add("Programas");
        //opcionList.add("RutinasActivity");
        opcionList.add("Clases");



        ArrayAdapter adapter = new ArrayAdapter(getApplicationContext(), android.R.layout.simple_expandable_list_item_1, opcionList);
        drawer.setAdapter(adapter);

        drawer.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            public void onItemClick(AdapterView<?> parent, View view, int position, long id){

                String opc = opcionList.get(position);
                Toast.makeText(ClaseActivity.this, opc, Toast.LENGTH_SHORT).show();

                if (opc == "Programas") {

                    Intent Loginn = new Intent(ClaseActivity.this, ProgramaActivity.class);
                    startActivity(Loginn);
                }
                if (opc == "Plan Nutricional") {
                    Intent Loginn = new Intent(ClaseActivity.this, PlanNutrionalActivity.class);
                    startActivity(Loginn);
                /*}if (opc=="RutinasActivity"){
                    Intent Loginn=new Intent(ProgramaActivity.this, RutinasActivity.class);
                    startActivity(Loginn);*/

                }
                if (opc == "Clases") {
                    Intent Loginn = new Intent(ClaseActivity.this, ClaseActivity.class);
                    startActivity(Loginn);
                }

            }
        });

        /**/
        final LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        final RecyclerView recyclerView = (RecyclerView) findViewById(R.id.clase_recycle_view);
        recyclerView.setLayoutManager(layoutManager);

        ApiInterface apiService =
                ApiClient.getClient().create(ApiInterface.class);

        //int idMiembroActivo = SystemPreferencesHelper.getPreferenceInt(ControlGymApplication.getContext(), "IdMiembro");

        Call<List<Clase>> call = apiService.getclase();
        call.enqueue(new Callback<List<Clase>>() {
            @Override
            public void onResponse(Call<List<Clase>> call, Response<List<Clase>> response) {
                if (response.code() == 200) {

                    List<Clase> clases = response.body();

                    Log.d(TAG, "Number of Clases received: " + clases.size());
                    recyclerView.setAdapter(new ClaseAdapter(clases, R.layout.list_clase, getApplicationContext()));
                } else {
                    Toast.makeText(ControlGymApplication.getContext(), "Acceso no autorizado. Status code: " + Integer.toString(response.code()) + ".", Toast.LENGTH_SHORT).show();
                    Log.e(TAG, Integer.toString(response.code()));

                    // El usuario debe volver a ingresar credenciales
                    SystemPreferencesHelper.clearPreference(ControlGymApplication.getContext());
                    Intent Loginn = new Intent(ControlGymApplication.getContext(), LoginActivity.class);
                    startActivity(Loginn);
                }
            }

            @Override
            public void onFailure(Call<List<Clase>> call, Throwable t) {
                // Log error here since request failed
                Log.e(TAG, t.toString());
            }
        });


    }

}
