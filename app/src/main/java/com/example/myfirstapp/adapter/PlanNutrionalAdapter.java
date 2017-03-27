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

import com.example.myfirstapp.R;
import com.example.myfirstapp.activity.PlanNutrionalDetalleActivity;
import com.example.myfirstapp.activity.RutinasActivity;
import com.example.myfirstapp.model.PlanNutrional;
import com.example.myfirstapp.model.Programa;

import java.util.List;

/**
 * Created by Erick on 21/3/2017.
 */

public class PlanNutrionalAdapter extends RecyclerView.Adapter<PlanNutrionalAdapter.PlanNutrionalViewHolder> {

    private List<PlanNutrional> PlanNutricional;
    private int rowLayout;
    private Context context;

    public static class PlanNutrionalViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        Context context;
        LinearLayout PlanNutrionalLayout;
        TextView idPlanNutrional;
        TextView Nombre;
        TextView FechaInicio;
        TextView FechaFinal;
        Button btn_detallePlan;
        public PlanNutrionalViewHolder (View v){
            super(v);
            //v.setOnClickListener(this);
            context= v.getContext();
            //

            v.setOnClickListener(this);
            PlanNutrionalLayout = (LinearLayout) v.findViewById(R.id.list_planNutrional_layout);

            Nombre = (TextView) v.findViewById(R.id.nombre_plan_nutrional);
            FechaInicio = (TextView) v.findViewById(R.id.fecha_inicio_plan_nutrional);
            FechaFinal = (TextView) v.findViewById(R.id.fecha_final_plan_nutrional);
            idPlanNutrional = (TextView) v.findViewById(R.id.id_plan_nutrional);
            btn_detallePlan= (Button) v.findViewById(R.id.btn_ver_planDetalle);
        }
        void setOnclickListener(){
            btn_detallePlan.setOnClickListener(this);

        }
        /*metodo para hacer click*/
        @Override
        public void onClick(View v) {
            Intent intent=new Intent(context, PlanNutrionalDetalleActivity.class);
            intent.putExtra("idplan_nutrional",idPlanNutrional.getText());
            context.startActivity(intent);
        }
    }

    public PlanNutrionalAdapter(List<PlanNutrional> plannutricional, int rowLayout, Context context){
        this.PlanNutricional = plannutricional;
        this.rowLayout = rowLayout;
        this.context = context;
    }
    @Override
    public PlanNutrionalAdapter.PlanNutrionalViewHolder onCreateViewHolder (ViewGroup parent,
                                                               int viewType){
        View view = LayoutInflater.from(parent.getContext()).
                inflate(rowLayout, parent, false);
        return new PlanNutrionalViewHolder(view);
    }
    @Override
    public void onBindViewHolder(PlanNutrionalViewHolder holder, final int position) {
        //holder.idPlanNutrional.setText(PlanNutricional.get(position).getIdPlanNutrional().toString());
        holder.Nombre.setText(PlanNutricional.get(position).getNombre().toString());
        holder.FechaInicio.setText(PlanNutricional.get(position).getFechaInicio().toString());
        holder.FechaFinal.setText(PlanNutricional.get(position).getFechaFin().toString());
        holder.idPlanNutrional.setText(PlanNutricional.get(position).getIdPlanNutrional().toString());

        holder.setOnclickListener();
    }

    public int getItemCount() {
        return PlanNutricional.size();
    }

}
