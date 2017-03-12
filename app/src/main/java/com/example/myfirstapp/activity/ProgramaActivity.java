package com.example.myfirstapp.activity;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.ListView;
import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import com.example.myfirstapp.ControlGymApplication;
import com.example.myfirstapp.Horarios;
import com.example.myfirstapp.Notificaciones;
import com.example.myfirstapp.PlanNutrional;
import com.example.myfirstapp.R;
import com.example.myfirstapp.Rutinas;
import com.example.myfirstapp.adapter.MiembrosAdapter;
import com.example.myfirstapp.model.Miembro;
import com.example.myfirstapp.rest.ApiClient;
import com.example.myfirstapp.rest.ApiInterface;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProgramaActivity extends ControlGymBaseActivity {
    private static final String TAG = ProgramaActivity.class.getSimpleName();
    ArrayList<String> opcionList;

    ListView drawer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_programa);

        drawer=(ListView)findViewById(R.id.drawer);
        opcionList=new ArrayList<String> ();
        opcionList.add("Plan Nutrional");
        opcionList.add("Programas");
        opcionList.add("Rutinas");
        opcionList.add("Horarios");
        opcionList.add("Notificaciones");


        ArrayAdapter adapter= new ArrayAdapter(getApplicationContext(),android.R.layout.simple_expandable_list_item_1,opcionList);
        drawer.setAdapter(adapter);

        drawer.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                String opc=opcionList.get(position);
                Toast.makeText(ProgramaActivity.this,opc,Toast.LENGTH_SHORT).show();

                if (opc=="Programas"){

                    Intent Loginn=new Intent(ProgramaActivity.this, ProgramaActivity.class);
                    startActivity(Loginn);
                } if(opc=="Plan Nutrional"){
                    Intent Loginn=new Intent(ProgramaActivity.this, PlanNutrional.class);
                    startActivity(Loginn);
                }if (opc=="Rutinas"){
                    Intent Loginn=new Intent(ProgramaActivity.this, Rutinas.class);
                    startActivity(Loginn);

                } if (opc=="Horarios"){
                    Intent Loginn=new Intent(ProgramaActivity.this, Horarios.class);
                    startActivity(Loginn);
                } if (opc=="Notificaciones"){
                    Intent Loginn=new Intent(ProgramaActivity.this, Notificaciones.class);
                    startActivity(Loginn);
                }
            }
        });

        /**/
        final LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        final RecyclerView recyclerView = (RecyclerView) findViewById(R.id.movies_recycler_view);
        recyclerView.setLayoutManager(layoutManager);

        ApiInterface apiService =
                ApiClient.getClient().create(ApiInterface.class);

        Call<List<Miembro>> call = apiService.obtenerMiembros("");
        call.enqueue(new Callback<List<Miembro>>() {
            @Override
            public void onResponse(Call<List<Miembro>>call, Response<List<Miembro>> response) {
                if (response.code() == 200) {

                    List<Miembro> miembros = response.body();

                    Log.d(TAG, "Number of miembros received: " + miembros.size());
                    recyclerView.setAdapter(new MiembrosAdapter(miembros, R.layout.list_miembro, getApplicationContext()));
                } else {
                    Toast.makeText(ControlGymApplication.getContext(), "Acceso no autorizado. Status code: "+Integer.toString(response.code()), Toast.LENGTH_SHORT).show();
                    Log.e(TAG, Integer.toString(response.code()));
                }
            }

            @Override
            public void onFailure(Call<List<Miembro>>call, Throwable t) {
                // Log error here since request failed
                Log.e(TAG, t.toString());
            }
        });

    }
}