package com.example.myfirstapp.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myfirstapp.R;
import com.example.myfirstapp.model.Programa;
import com.example.myfirstapp.model.Rutina;

import java.util.List;

/**
 * Created by Erick on 18/3/2017.
 */

public class RutinasAdapter extends RecyclerView.Adapter<RutinasAdapter.RutinaViewHolder> {

    private List<Rutina> rutinas;
    private int rowLayout;
    private Context context;

    public static class RutinaViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        LinearLayout rutinaLayout;
        TextView idProgramaEjercicio;
        TextView nombreRutina;
        TextView detalleRutina;

        public RutinaViewHolder (View v){
            super(v);
            //v.setOnClickListener(this);
            rutinaLayout = (LinearLayout) v.findViewById(R.id.list_rutina_layout);
            idProgramaEjercicio = (TextView) v.findViewById(R.id.id_programa_ejercicio);
            nombreRutina = (TextView) v.findViewById(R.id.nombre_rutina);
            detalleRutina = (TextView) v.findViewById(R.id.detalle_rutina);
        }
        /*metodo para hacer click*/
        @Override
        public void onClick(View v) {
            Toast.makeText(v.getContext(),"Tuanis",Toast.LENGTH_SHORT).show();
        }
    }

    public RutinasAdapter(List<Rutina> rutinas, int rowLayout, Context context){
        this.rutinas = rutinas;
        this.rowLayout = rowLayout;
        this.context = context;
    }

    @Override
    public RutinasAdapter.RutinaViewHolder onCreateViewHolder (ViewGroup parent,
                                                                   int viewType){
        View view = LayoutInflater.from(parent.getContext()).
                inflate(rowLayout, parent, false);
        return new RutinaViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RutinaViewHolder holder, final int position) {
        holder.idProgramaEjercicio.setText(rutinas.get(position).getIdProgramaEjercicio().toString());
        holder.nombreRutina.setText(rutinas.get(position).getNombreRutina().toString());
        holder.detalleRutina.setText(rutinas.get(position).getDetalleRutina().toString());
    }

    @Override
    public int getItemCount() {
        return rutinas.size();
    }
}
