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
import com.example.myfirstapp.activity.RutinasActivity;
import com.example.myfirstapp.helper.SystemPreferencesHelper;
import com.example.myfirstapp.model.Programa;

import java.util.List;

/**
 * Created by M.Franco on 3/12/2017.
 */

public class ProgramasAdapter extends RecyclerView.Adapter<ProgramasAdapter.ProgramaViewHolder>  {
    private List<Programa> programas;
    private int rowLayout;
    private Context context;

    public static class ProgramaViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        //context
        Context context;

        LinearLayout programasLayout;
        TextView programaNombre;
        TextView programaFechaInicio;
        TextView programaFechaFin;
        TextView idEjercicio;
        Button btn_rutinas;


        public ProgramaViewHolder (View v){
             super(v);
            //nueva linea
          context= v.getContext();
            //

            v.setOnClickListener(this);
            programasLayout = (LinearLayout) v.findViewById(R.id.list_programa_layout);
            programaNombre = (TextView) v.findViewById(R.id.nombre_programa);
            programaFechaInicio = (TextView) v.findViewById(R.id.fecha_inicio_programa);
            programaFechaFin = (TextView) v.findViewById(R.id.fecha_fin_programa);
            idEjercicio= (TextView) v.findViewById(R.id.id_programa);
            btn_rutinas= (Button) v.findViewById(R.id.btn_ver_rutina);
        }

        void setOnclickListener(){
            btn_rutinas.setOnClickListener(this);

        }
/*metodo para hacer click*/
        @Override
        public void onClick(View v) {
            Intent intent=new Intent(context, RutinasActivity.class);
            intent.putExtra("idprograma_rut",idEjercicio.getText());
                context.startActivity(intent);
        }
    }

    public ProgramasAdapter(List<Programa> programas, int rowLayout, Context context){
        this.programas = programas;
        this.rowLayout = rowLayout;
        this.context = context;
    }

    @Override
    public ProgramasAdapter.ProgramaViewHolder onCreateViewHolder (ViewGroup parent,
                                                                   int viewType){
        View view = LayoutInflater.from(parent.getContext()).
                inflate(rowLayout, parent, false);
        return new ProgramaViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ProgramaViewHolder holder, final int position) {
        holder.programaNombre.setText(programas.get(position).getNombrePrograma());
        holder.programaFechaInicio.setText(programas.get(position).getFechaInicio().toString());
        holder.programaFechaFin.setText(programas.get(position).getFechaFin().toString());
        holder.idEjercicio.setText(programas.get(position).getIdProgramaEjercicio().toString());

        //nueva linea
        holder.setOnclickListener();

    }

    @Override
    public int getItemCount() {
        return programas.size();
    }
}
