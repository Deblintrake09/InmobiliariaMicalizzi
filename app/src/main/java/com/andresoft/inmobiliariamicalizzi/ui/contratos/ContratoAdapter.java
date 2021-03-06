package com.andresoft.inmobiliariamicalizzi.ui.contratos;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.andresoft.inmobiliariamicalizzi.R;
import com.andresoft.inmobiliariamicalizzi.modelo.Contrato;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

import java.util.List;

public class ContratoAdapter extends RecyclerView.Adapter<ContratoAdapter.ViewHolder> {
    private Context context;
    private List<Contrato> contratos;
    private LayoutInflater inflater;

    public ContratoAdapter(Context context, List<Contrato> contratos, LayoutInflater inflater) {
        this.context = context;
        this.contratos = contratos;
        this.inflater = inflater;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.item_inmueble_alquilado, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.tvDireccion.setText(contratos.get(position).getInmueble().getDireccion());
        holder.tvInquilino.setText(contratos.get(position).getInquilino().getNombre()+" "+ contratos.get(position).getInquilino().getApellido() );
        Glide.with(context).load(contratos.get(position).getInmueble().getImagen())
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(holder.ivImagen);
    }

    @Override
    public int getItemCount() { return contratos.size();  }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvInquilino;
        TextView tvDireccion;
        ImageView ivImagen;
        public ViewHolder(@NonNull View itemView){
            super(itemView);
            ivImagen = itemView.findViewById(R.id.ivImagenInmueble);
            tvInquilino = itemView.findViewById(R.id.tvInquilino);
            tvDireccion = itemView.findViewById(R.id.tvDireccion);
            itemView.setOnClickListener((view)->{
                Bundle bundle = new Bundle();
                Contrato contrato = contratos.get(getAdapterPosition());
                bundle.putSerializable("contrato", contrato);
                Navigation.findNavController((Activity) context, R.id.nav_host_fragment_content_main).navigate(R.id.contratoFragment, bundle);
            });

        }
    }
}
