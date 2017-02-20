package com.example.myfirstapp;

import com.example.myfirstapp.activity.ControlGymBaseActivity;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;



import java.util.ArrayList;

public class Notificaciones extends ControlGymBaseActivity {


    ArrayList <String> opcionList;

    ListView drawer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notificaciones);

        /** Menu Izquierdo **/
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
                Toast.makeText(Notificaciones.this,opc,Toast.LENGTH_SHORT).show();

                if (opc=="Programas"){

                    Intent Loginn=new Intent(Notificaciones.this, Programa.class);
                    startActivity(Loginn);
                } if(opc=="Plan Nutrional"){
                    Intent Loginn=new Intent(Notificaciones.this, PlanNutrional.class);
                    startActivity(Loginn);
                }if (opc=="Rutinas"){
                    Intent Loginn=new Intent(Notificaciones.this, Rutinas.class);
                    startActivity(Loginn);

                } if (opc=="Horarios"){
                    Intent Loginn=new Intent(Notificaciones.this, Horarios.class);
                    startActivity(Loginn);
                } if (opc=="Notificaciones"){
                    Intent Loginn=new Intent(Notificaciones.this, Notificaciones.class);
                    startActivity(Loginn);
                }
            }
        });
    }
}
