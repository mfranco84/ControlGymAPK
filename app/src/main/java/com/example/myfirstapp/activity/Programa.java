package com.example.myfirstapp.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import com.example.myfirstapp.Horarios;
import com.example.myfirstapp.Notificaciones;
import com.example.myfirstapp.PlanNutrional;
import com.example.myfirstapp.R;
import com.example.myfirstapp.Rutinas;

import java.util.ArrayList;

public class Programa extends ControlGymBaseActivity {
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
                Toast.makeText(Programa.this,opc,Toast.LENGTH_SHORT).show();

                if (opc=="Programas"){

                    Intent Loginn=new Intent(Programa.this, Programa.class);
                    startActivity(Loginn);
                } if(opc=="Plan Nutrional"){
                    Intent Loginn=new Intent(Programa.this, PlanNutrional.class);
                    startActivity(Loginn);
                }if (opc=="Rutinas"){
                    Intent Loginn=new Intent(Programa.this, Rutinas.class);
                    startActivity(Loginn);

                } if (opc=="Horarios"){
                    Intent Loginn=new Intent(Programa.this, Horarios.class);
                    startActivity(Loginn);
                } if (opc=="Notificaciones"){
                    Intent Loginn=new Intent(Programa.this, Notificaciones.class);
                    startActivity(Loginn);
                }
            }
        });
    }
}
