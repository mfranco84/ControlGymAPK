package com.example.myfirstapp.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.myfirstapp.ControlGymApplication;
import com.example.myfirstapp.Horarios;
import com.example.myfirstapp.Notificaciones;
import com.example.myfirstapp.R;
import com.example.myfirstapp.activity.ProgramaActivity;
import com.example.myfirstapp.activity.RutinasActivity;
import com.example.myfirstapp.adapter.PlanNutrionalAdapter;
import com.example.myfirstapp.adapter.ProgramasAdapter;
import com.example.myfirstapp.helper.SystemPreferencesHelper;
import com.example.myfirstapp.model.PlanNutrional;
import com.example.myfirstapp.model.Programa;
import com.example.myfirstapp.rest.ApiClient;
import com.example.myfirstapp.rest.ApiInterface;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PlanNutrionalActivity extends AppCompatActivity {

    private static final String TAG = PlanNutrionalActivity.class.getSimpleName();


    int[] imagenes = {
        R.drawable.horario
    };
 ArrayList <String> opcionList;

   ListView drawer;
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plan_nutrional);

        drawer=(ListView)findViewById(R.id.drawer);
        opcionList=new ArrayList<String> ();

        opcionList.add("Plan Nutrional");
        opcionList.add("Programas");
        //opcionList.add("RutinasActivity");
        opcionList.add("Horarios");
        opcionList.add("Notificaciones");




        ArrayAdapter adapter= new ArrayAdapter(getApplicationContext(),android.R.layout.simple_expandable_list_item_1,opcionList);
        drawer.setAdapter(adapter);

        drawer.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                String opc=opcionList.get(position);
                Toast.makeText(PlanNutrionalActivity.this,opc,Toast.LENGTH_SHORT).show();

                if (opc=="Programas"){

                        Intent Loginn=new Intent(PlanNutrionalActivity.this, ProgramaActivity.class);
                        startActivity(Loginn);
                } if(opc=="Plan Nutrional"){
                    Intent Loginn=new Intent(PlanNutrionalActivity.this, PlanNutrionalActivity.class);
                    startActivity(Loginn);
                /*}if (opc=="RutinasActivity"){
                    Intent Loginn=new Intent(PlanNutrionalActivity.this, RutinasActivity.class);
                    startActivity(Loginn);*/

                } if (opc=="Horarios"){
                    Intent Loginn=new Intent(PlanNutrionalActivity.this, Horarios.class);
                    startActivity(Loginn);
                } if (opc=="Notificaciones"){
                    Intent Loginn=new Intent(PlanNutrionalActivity.this, Notificaciones.class);
                    startActivity(Loginn);
                }
            }
        });

                /**/
        final LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        final RecyclerView recyclerView = (RecyclerView) findViewById(R.id.plan_nutrional_recycler_view);
        recyclerView.setLayoutManager(layoutManager);

        ApiInterface apiService =
                ApiClient.getClient().create(ApiInterface.class);

        int idMiembroActivo = SystemPreferencesHelper.getPreferenceInt(ControlGymApplication.getContext(), "IdMiembro");

        Call<List<PlanNutrional>> call = apiService.getPlanNutrionalPorMiembroI(idMiembroActivo);
        call.enqueue(new Callback<List<PlanNutrional>>() {
            @Override
            public void onResponse(Call<List<PlanNutrional>>call, Response<List<PlanNutrional>> response) {
                if (response.code() == 200) {

                    List<PlanNutrional> plannutricional = response.body();

                    Log.d(TAG, "Number of Programas received: " + plannutricional.size());
                    recyclerView.setAdapter(new PlanNutrionalAdapter(plannutricional, R.layout.list_plan_nutrional, getApplicationContext()));
                } else {
                    Toast.makeText(ControlGymApplication.getContext(), "Acceso no autorizado. Status code: "+Integer.toString(response.code()), Toast.LENGTH_SHORT).show();
                    Log.e(TAG, Integer.toString(response.code()));
                }
            }

            @Override
            public void onFailure(Call<List<PlanNutrional>>call, Throwable t) {
                // Log error here since request failed
                Log.e(TAG, t.toString());
            }
        });

    }
    /*public boolean onCreateOptionsMenu(Menu menu){


        getMenuInflater().inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }*/
}


