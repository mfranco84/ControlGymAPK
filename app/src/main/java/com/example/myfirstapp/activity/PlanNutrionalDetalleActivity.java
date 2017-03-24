package com.example.myfirstapp.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v4.widget.DrawerLayout;

import com.example.myfirstapp.ControlGymApplication;
import com.example.myfirstapp.Horarios;
import com.example.myfirstapp.Notificaciones;
import com.example.myfirstapp.R;
import com.example.myfirstapp.adapter.RutinasAdapter;

import com.example.myfirstapp.model.PlanNutrionalDetalle;
import com.example.myfirstapp.model.Rutina;
import com.example.myfirstapp.rest.ApiClient;
import com.example.myfirstapp.rest.ApiInterface;
import com.example.myfirstapp.model.PlanNutrionalDetalle;
import java.util.ArrayList;
import java.util.List;
import com.example.myfirstapp.adapter.PlanNutricionalDetalleAdapter;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Erick on 23/3/2017.
 */

public class PlanNutrionalDetalleActivity extends AppCompatActivity {
    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mDrawerToggle;

    private static final String TAG = PlanNutrionalDetalleActivity.class.getSimpleName();
    ArrayList<String> opcionList;

    ListView drawer;

    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plan_nutrional_detalle);

        drawer=(ListView)findViewById(R.id.drawer);
        opcionList=new ArrayList<String> ();

        opcionList.add("Plan Nutricional");
        opcionList.add("Programas");
        // opcionList.add("RutinasActivity");
        opcionList.add("Horarios");
        opcionList.add("Notificaciones");




        ArrayAdapter adapter= new ArrayAdapter(getApplicationContext(),android.R.layout.simple_expandable_list_item_1,opcionList);
        drawer.setAdapter(adapter);

        drawer.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                String opc=opcionList.get(position);
                Toast.makeText(PlanNutrionalDetalleActivity.this,opc,Toast.LENGTH_SHORT).show();

                if (opc=="Programas"){

                    Intent Loginn=new Intent(PlanNutrionalDetalleActivity.this, ProgramaActivity.class);
                    startActivity(Loginn);
                } if(opc=="Plan Nutricional"){
                    Intent Loginn=new Intent(PlanNutrionalDetalleActivity.this, PlanNutrionalActivity.class);
                    startActivity(Loginn);
                /*}if (opc=="RutinasActivity"){
                    Intent Loginn=new Intent(RutinasActivity.this, RutinasActivity.class);
                    startActivity(Loginn);*/

                } if (opc=="Horarios"){
                    Intent Loginn=new Intent(PlanNutrionalDetalleActivity.this, Horarios.class);
                    startActivity(Loginn);
                } if (opc=="Notificaciones"){
                    Intent Loginn=new Intent(PlanNutrionalDetalleActivity.this, Notificaciones.class);
                    startActivity(Loginn);
                }
            }
        });

        Bundle extras =getIntent().getExtras();

        String value =extras.getString("idplan_nutrional");
        Integer myNum = Integer.parseInt(value);

        /**/
        final LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        final RecyclerView recyclerView = (RecyclerView) findViewById(R.id.plan_nutrional_Detalle_recycler_view);
        recyclerView.setLayoutManager(layoutManager);

        ApiInterface apiService =
                ApiClient.getClient().create(ApiInterface.class);

        //int idprograma =Integer.parseInt(value.getText().toString());

        Call<List<PlanNutrionalDetalle>> call = apiService.getPlanNutrionalPorPlanID(myNum);
        call.enqueue(new Callback<List<PlanNutrionalDetalle>>() {
            @Override
            public void onResponse(Call<List<PlanNutrionalDetalle>>call, Response<List<PlanNutrionalDetalle>> response) {
                if (response.code() == 200) {

                    List<PlanNutrionalDetalle> PlanNutrionalDetalle = response.body();

                    Log.d(TAG, "Number of Rutinas received: " + PlanNutrionalDetalle.size());
                    recyclerView.setAdapter(new PlanNutricionalDetalleAdapter(PlanNutrionalDetalle, R.layout.list_plan_nutrional_detalle, getApplicationContext()));
                } else {
                    Toast.makeText(ControlGymApplication.getContext(), "Acceso no autorizado. Status code: "+Integer.toString(response.code()), Toast.LENGTH_SHORT).show();
                    Log.e(TAG, Integer.toString(response.code()));
                }
            }

            @Override
            public void onFailure(Call<List<PlanNutrionalDetalle>> call, Throwable t) {

                Log.e(TAG, t.toString());
            }


        });

       /*TextView tvidprograma= (TextView) findViewById(R.id.prueba);

        tvidprograma.setText(myNum.toString());*/
    }
    public boolean onCreateOptionsMenu(Menu menu){


        getMenuInflater().inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);


    }


}
