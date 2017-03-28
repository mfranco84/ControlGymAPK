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

import com.example.myfirstapp.ControlGymApplication;
import com.example.myfirstapp.Horarios;
import com.example.myfirstapp.Notificaciones;
import com.example.myfirstapp.R;
import com.example.myfirstapp.adapter.RutinasAdapter;
import com.example.myfirstapp.helper.SystemPreferencesHelper;
import com.example.myfirstapp.model.Rutina;
import com.example.myfirstapp.rest.ApiClient;
import com.example.myfirstapp.rest.ApiInterface;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v4.widget.DrawerLayout;

public class RutinasActivity extends AppCompatActivity {
    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mDrawerToggle;

    private static final String TAG = RutinasActivity.class.getSimpleName();
    ArrayList <String> opcionList;

    ListView drawer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rutinas);

        drawer=(ListView)findViewById(R.id.drawer);
        opcionList=new ArrayList<String> ();

        opcionList.add("Plan Nutrional");
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
                Toast.makeText(RutinasActivity.this,opc,Toast.LENGTH_SHORT).show();

                if (opc=="Programas"){

                    Intent Loginn=new Intent(RutinasActivity.this, ProgramaActivity.class);
                    startActivity(Loginn);
                } if(opc=="Plan Nutrional"){
                    Intent Loginn=new Intent(RutinasActivity.this, PlanNutrionalActivity.class);
                    startActivity(Loginn);
                /*}if (opc=="RutinasActivity"){
                    Intent Loginn=new Intent(RutinasActivity.this, RutinasActivity.class);
                    startActivity(Loginn);*/

                } if (opc=="Horarios"){
                    Intent Loginn=new Intent(RutinasActivity.this, Horarios.class);
                    startActivity(Loginn);
                } if (opc=="Notificaciones"){
                    Intent Loginn=new Intent(RutinasActivity.this, Notificaciones.class);
                    startActivity(Loginn);
                }
            }
        });

        Bundle extras =getIntent().getExtras();

        String value =extras.getString("idprograma_rut");
        Integer myNum = Integer.parseInt(value);

        /**/
        final LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        final RecyclerView recyclerView = (RecyclerView) findViewById(R.id.rutinas_recycler_view);
        recyclerView.setLayoutManager(layoutManager);

        ApiInterface apiService =
                ApiClient.getClient().create(ApiInterface.class);

        //int idprograma =Integer.parseInt(value.getText().toString());

        Call<List<Rutina>> call = apiService.getRutinasPorProgramaId(myNum);
        call.enqueue(new Callback<List<Rutina>>() {
            @Override
            public void onResponse(Call<List<Rutina>>call, Response<List<Rutina>> response) {
                if (response.code() == 200) {

                    List<Rutina> rutinas = response.body();

                    Log.d(TAG, "Number of Rutinas received: " + rutinas.size());
                    recyclerView.setAdapter(new RutinasAdapter(rutinas, R.layout.list_rutinas, getApplicationContext()));
                } else {
                    Toast.makeText(ControlGymApplication.getContext(), "Acceso no autorizado. Status code: "+Integer.toString(response.code()) + ".", Toast.LENGTH_SHORT).show();
                    Log.e(TAG, Integer.toString(response.code()));

                    // El usuario debe volver a ingresar credenciales
                    SystemPreferencesHelper.clearPreference(ControlGymApplication.getContext());
                    Intent Loginn=new Intent(ControlGymApplication.getContext(), LoginActivity.class);
                    startActivity(Loginn);
                }
            }

            @Override
            public void onFailure(Call<List<Rutina>> call, Throwable t) {

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
