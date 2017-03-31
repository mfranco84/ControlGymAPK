package com.example.myfirstapp.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myfirstapp.R;
import com.example.myfirstapp.model.HorarioClase;
import com.example.myfirstapp.model.Rutina;

import java.util.List;

/**
 * Created by Erick on 30/3/2017.
 */

public class HorarioClaseAdapter extends RecyclerView.Adapter<HorarioClaseAdapter.HorarioClaseViewHolder> {

    private List<HorarioClase> HorarioClase;
    private int rowLayout;
    private Context context;

    public static class HorarioClaseViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        LinearLayout horarioClaseLayout;
        TextView dia;
        TextView horaInicio;
        TextView horaFin;
        //Button btn_horarioClases;
        public HorarioClaseViewHolder (View v){
            super(v);
            //v.setOnClickListener(this);
            horarioClaseLayout = (LinearLayout) v.findViewById(R.id.list_horario_clases_layout);
            dia = (TextView) v.findViewById(R.id.Dia_Clase);
            horaInicio = (TextView) v.findViewById(R.id.Hora_Inicio);
            horaFin = (TextView) v.findViewById(R.id.Hora_Fin);
            //btn_horarioClases= (Button) v.findViewById(R.id.btn_ver_clase);
        }
        /*metodo para hacer click*/
        @Override
        public void onClick(View v) {
            Toast.makeText(v.getContext(),"Tuanis",Toast.LENGTH_SHORT).show();
        }
    }

    public HorarioClaseAdapter(List<HorarioClase> HorarioClase, int rowLayout, Context context){
        this.HorarioClase = HorarioClase;
        this.rowLayout = rowLayout;
        this.context = context;
    }

    @Override
    public HorarioClaseAdapter.HorarioClaseViewHolder onCreateViewHolder (ViewGroup parent,
                                                               int viewType){
        View view = LayoutInflater.from(parent.getContext()).
                inflate(rowLayout, parent, false);
        return new HorarioClaseAdapter.HorarioClaseViewHolder(view);
    }

    @Override
    public void onBindViewHolder(HorarioClaseAdapter.HorarioClaseViewHolder holder, final int position) {
        holder.dia.setText(HorarioClase.get(position).getDia().toString());
        holder.horaInicio.setText(HorarioClase.get(position).getHoraInicio().toString());
        holder.horaFin.setText(HorarioClase.get(position).getHoraFin().toString());
    }

    @Override
    public int getItemCount() {
        return HorarioClase.size();
    }
}
