package com.example.myfirstapp.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myfirstapp.ControlGymApplication;
import com.example.myfirstapp.R;
import com.example.myfirstapp.activity.HorarioClaseActivity;
import com.example.myfirstapp.activity.RutinasActivity;
import com.example.myfirstapp.model.Programa;
import  com.example.myfirstapp.model.Clase;

import java.util.List;

/**
 * Created by Erick on 27/3/2017.
 */

public class ClaseAdapter extends RecyclerView.Adapter<ClaseAdapter.ClaseViewHolder> {

    private List<Clase> Clase;
    private int rowLayout;
    private Context context;

    public static class ClaseViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        //context
        Context context;

        LinearLayout claseLayout;
        TextView claseNombre;
        TextView claseid;
        Button btn_clases;


        public ClaseViewHolder (View v) {
            super(v);
            //nueva linea
            context = v.getContext();
            //

            v.setOnClickListener(this);
            claseLayout = (LinearLayout) v.findViewById(R.id.list_clases_layout);
            claseNombre = (TextView) v.findViewById(R.id.Nombre_Clase);
            claseid = (TextView) v.findViewById(R.id.Id_Clase);
            btn_clases= (Button) v.findViewById(R.id.btn_ver_clase);
        }
        void setOnclickListener(){
            btn_clases.setOnClickListener(this);

        }
        /*metodo para hacer click*/
        @Override
        public void onClick(View v) {
            Intent intent=new Intent(context, HorarioClaseActivity.class);
            intent.putExtra("id_clase",claseid.getText());
            context.startActivity(intent);
        }
    }

    public ClaseAdapter(List<Clase> Clase, int rowLayout, Context context){
        this.Clase = Clase;
        this.rowLayout = rowLayout;
        this.context = context;
    }

    @Override
    public ClaseAdapter.ClaseViewHolder onCreateViewHolder (ViewGroup parent,
                                                                   int viewType){
        View view = LayoutInflater.from(parent.getContext()).
                inflate(rowLayout, parent, false);
        return new ClaseViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ClaseViewHolder holder, final int position) {
        holder.claseNombre.setText(Clase.get(position).getNombre());
        holder.claseid.setText(Clase.get(position).getIdClase().toString());

        //holder.claseid.setText("fjdsfjksdnfjsdnk".toString());


        //nueva linea
        holder.setOnclickListener();

    }

    @Override
    public int getItemCount() {
        return Clase.size();
    }
}
