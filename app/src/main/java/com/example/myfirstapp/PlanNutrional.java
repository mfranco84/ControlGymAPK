package com.example.myfirstapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.myfirstapp.activity.ProgramaActivity;

import java.util.ArrayList;

public class PlanNutrional extends AppCompatActivity {

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
        opcionList.add("Rutinas");
        opcionList.add("Horarios");
        opcionList.add("Notificaciones");




        ArrayAdapter adapter= new ArrayAdapter(getApplicationContext(),android.R.layout.simple_expandable_list_item_1,opcionList);
        drawer.setAdapter(adapter);

        drawer.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                String opc=opcionList.get(position);
                Toast.makeText(PlanNutrional.this,opc,Toast.LENGTH_SHORT).show();

                if (opc=="Programas"){

                        Intent Loginn=new Intent(PlanNutrional.this, ProgramaActivity.class);
                        startActivity(Loginn);
                } if(opc=="Plan Nutrional"){
                    Intent Loginn=new Intent(PlanNutrional.this, PlanNutrional.class);
                    startActivity(Loginn);
                }if (opc=="Rutinas"){
                    Intent Loginn=new Intent(PlanNutrional.this, Rutinas.class);
                    startActivity(Loginn);

                } if (opc=="Horarios"){
                    Intent Loginn=new Intent(PlanNutrional.this, Horarios.class);
                    startActivity(Loginn);
                } if (opc=="Notificaciones"){
                    Intent Loginn=new Intent(PlanNutrional.this, Notificaciones.class);
                    startActivity(Loginn);
                }
            }
        });

    }

    public boolean onCreateOptionsMenu(Menu menu){


        getMenuInflater().inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }
}


