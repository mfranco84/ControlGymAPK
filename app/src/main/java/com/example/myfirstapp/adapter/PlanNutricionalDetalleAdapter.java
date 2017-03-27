package com.example.myfirstapp.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myfirstapp.R;
import com.example.myfirstapp.activity.PlanNutrionalDetalleActivity;
import com.example.myfirstapp.model.PlanNutrional;
import com.example.myfirstapp.model.PlanNutrionalDetalle;

import java.util.List;

/**
 * Created by Erick on 23/3/2017.
 */

public class PlanNutricionalDetalleAdapter extends RecyclerView.Adapter<PlanNutricionalDetalleAdapter.PlanNutricionalDetalleViewHolder> {
    private List<PlanNutrionalDetalle> PlanNutricionalDetalle;
    private int rowLayout;
    private Context context;

    public static class PlanNutricionalDetalleViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        Context context;
        LinearLayout PlanNutrionalDetalleLayout;
        TextView Detalle;


        public PlanNutricionalDetalleViewHolder (View v){
            super(v);
            //v.setOnClickListener(this);
            context= v.getContext();
            //

            v.setOnClickListener(this);
            PlanNutrionalDetalleLayout = (LinearLayout) v.findViewById(R.id.list_planNutrional_Detalle_layout);

            Detalle = (TextView) v.findViewById(R.id.Detalle_Plan);

        }
        /*metodo para hacer click*/
        @Override
        public void onClick(View v) {
            //Intent intent=new Intent(context, PlanNutrionalDetalleActivity.class);
            Toast.makeText(v.getContext(),"Tuanis",Toast.LENGTH_SHORT).show();

        }


    }

    public PlanNutricionalDetalleAdapter(List<PlanNutrionalDetalle> PlanNutrionalDetalle, int rowLayout, Context context){
        this.PlanNutricionalDetalle = PlanNutrionalDetalle;
        this.rowLayout = rowLayout;
        this.context = context;
    }
    @Override
    public PlanNutricionalDetalleAdapter.PlanNutricionalDetalleViewHolder onCreateViewHolder (ViewGroup parent,
                                                                            int viewType){
        View view = LayoutInflater.from(parent.getContext()).
                inflate(rowLayout, parent, false);
        return new PlanNutricionalDetalleAdapter.PlanNutricionalDetalleViewHolder(view);
    }

    public void onBindViewHolder(PlanNutricionalDetalleAdapter.PlanNutricionalDetalleViewHolder holder, final int position) {
        //holder.idPlanNutrional.setText(PlanNutricional.get(position).getIdPlanNutrional().toString());
        holder.Detalle.setText(PlanNutricionalDetalle.get(position).getDetallePlanNutrional().toString());


    }
    @Override
    public int getItemCount() {
        return PlanNutricionalDetalle.size();
    }
}
