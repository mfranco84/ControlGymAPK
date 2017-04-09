package com.example.myfirstapp.adapter;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

import com.example.myfirstapp.ControlGymApplication;
import com.example.myfirstapp.R;
import com.example.myfirstapp.helper.SystemPreferencesHelper;
import com.example.myfirstapp.model.Miembro;

/**
 * Created by M.Franco on 2/19/2017.
 */

public class MiembrosAdapter extends RecyclerView.Adapter<MiembrosAdapter.MiembroViewHolder> {
    private List<Miembro> miembros;
    private int rowLayout;
    private Context context;

    public static class MiembroViewHolder extends RecyclerView.ViewHolder {
        LinearLayout miembrosLayout;
        TextView miembroNombre;
        TextView miembroId;
        TextView miembroCorreo;
        TextView rating;

        public MiembroViewHolder(View v) {
            super(v);
            miembrosLayout = (LinearLayout) v.findViewById(R.id.list_miembro_layout);
            miembroNombre = (TextView) v.findViewById(R.id.nombre);
            miembroId = (TextView) v.findViewById(R.id.idMiembro);
            miembroCorreo = (TextView) v.findViewById(R.id.correo);
            rating = (TextView) v.findViewById(R.id.rating);
        }
    }

    public MiembrosAdapter(List<Miembro> miembros, int rowLayout, Context context) {
        this.miembros = miembros;
        this.rowLayout = rowLayout;
        this.context = context;
    }

    @Override
    public MiembrosAdapter.MiembroViewHolder onCreateViewHolder(ViewGroup parent,
                                                            int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(rowLayout, parent, false);
        return new MiembroViewHolder(view);
    }


    @Override
    public void onBindViewHolder(MiembroViewHolder holder, final int position) {
        holder.miembroNombre.setText(miembros.get(position).getNombre());
        holder.miembroId.setText(miembros.get(position).getIdMiembro().toString());
        holder.miembroCorreo.setText(miembros.get(position).getCorreo());
        holder.rating.setText("10");


    }

    @Override
    public int getItemCount() {
        return miembros.size();
    }
}
