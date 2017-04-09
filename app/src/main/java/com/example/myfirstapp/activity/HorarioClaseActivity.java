package com.example.myfirstapp.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
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
import com.example.myfirstapp.Notificaciones;
import com.example.myfirstapp.R;
import com.example.myfirstapp.adapter.HorarioClaseAdapter;
import com.example.myfirstapp.adapter.RutinasAdapter;
import com.example.myfirstapp.helper.SystemPreferencesHelper;
import com.example.myfirstapp.model.HorarioClase;
import com.example.myfirstapp.model.Rutina;
import com.example.myfirstapp.rest.ApiClient;
import com.example.myfirstapp.rest.ApiInterface;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Erick on 30/3/2017.
 */

public class HorarioClaseActivity extends ControlGymBaseActivity {

    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mDrawerToggle;

    private static final String TAG = HorarioClaseActivity.class.getSimpleName();
    ArrayList<String> opcionList;

    ListView drawer;
    @Override

    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_horario_clases);

        drawer=(ListView)findViewById(R.id.drawer);
        opcionList=new ArrayList<String> ();

        opcionList.add("Plan Nutrional");
        opcionList.add("Programas");
        // opcionList.add("RutinasActivity");
        opcionList.add("Clases");





        ArrayAdapter adapter= new ArrayAdapter(getApplicationContext(),android.R.layout.simple_expandable_list_item_1,opcionList);
        drawer.setAdapter(adapter);

        drawer.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                String opc=opcionList.get(position);
                Toast.makeText(HorarioClaseActivity.this,opc,Toast.LENGTH_SHORT).show();

                if (opc=="Programas"){

                    Intent Loginn=new Intent(HorarioClaseActivity.this, ProgramaActivity.class);
                    startActivity(Loginn);
                } if(opc=="Plan Nutrional"){
                    Intent Loginn=new Intent(HorarioClaseActivity.this, PlanNutrionalActivity.class);
                    startActivity(Loginn);
                /*}if (opc=="RutinasActivity"){
                    Intent Loginn=new Intent(RutinasActivity.this, RutinasActivity.class);
                    startActivity(Loginn);*/

                } if (opc=="Clases"){
                    Intent Loginn=new Intent(HorarioClaseActivity.this, ClaseActivity.class);
                    startActivity(Loginn);
                }
            }
        });

        Bundle extras =getIntent().getExtras();

        String value =extras.getString("id_clase");
        Integer myNum = Integer.parseInt(value);

        /**/
        final LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        final RecyclerView recyclerView = (RecyclerView) findViewById(R.id.horario_clase_recycler_view);
        recyclerView.setLayoutManager(layoutManager);

        ApiInterface apiService =
                ApiClient.getClient().create(ApiInterface.class);

        //int idprograma =Integer.parseInt(value.getText().toString());

        Call<List<HorarioClase>> call = apiService.getHorarioClase(myNum);
        call.enqueue(new Callback<List<HorarioClase>>() {
            @Override
            public void onResponse(Call<List<HorarioClase>>call, Response<List<HorarioClase>> response) {
                if (response.code() == 200) {

                    List<HorarioClase> HorarioClase = response.body();

                    Log.d(TAG, "Number of Horario de clases received: " + HorarioClase.size());
                    recyclerView.setAdapter(new HorarioClaseAdapter(HorarioClase, R.layout.list_horario_clases, getApplicationContext()));
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
            public void onFailure(Call<List<HorarioClase>> call, Throwable t) {

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
