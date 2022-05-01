package com.andresoft.inmobiliariamicalizzi.ui.contratos.pagos;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.andresoft.inmobiliariamicalizzi.R;
import com.andresoft.inmobiliariamicalizzi.modelo.Inmueble;
import com.andresoft.inmobiliariamicalizzi.modelo.Pago;

import java.util.List;

public class PagosAdapter extends RecyclerView.Adapter<PagosAdapter.ViewHolder> {
    private Context context;
    private List<Pago> pagos;
    private LayoutInflater inflater;

    public PagosAdapter(Context context, List<Pago> pagos, LayoutInflater inflater) {
        this.context = context;
        this.pagos = pagos;
        this.inflater = inflater;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.item_pago, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.tvImporte.setText("$"+pagos.get(position).getImporte());
        holder.tvNumeroPago.setText(pagos.get(position).getNumero()+"");
        holder.tvCodigoPago.setText(pagos.get(position).getIdPago()+"");
        holder.tvFechaPago.setText(pagos.get(position).getFechaPago()+"");
        holder.tvCodigoContrato.setText(pagos.get(position).getContrato().getIdContrato()+"");

    }

    @Override
    public int getItemCount() { return pagos.size();  }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvCodigoPago;
        TextView tvNumeroPago;
        TextView tvCodigoContrato;
        TextView tvImporte;
        TextView tvFechaPago;
        public ViewHolder(@NonNull View itemView){
            super(itemView);
            tvCodigoContrato = itemView.findViewById(R.id.tvCodigoContrato);
            tvCodigoPago = itemView.findViewById(R.id.tvCodigoPago);
            tvFechaPago = itemView.findViewById(R.id.tvFechaPago);
            tvNumeroPago = itemView.findViewById(R.id.tvNumeroPago);
            tvImporte = itemView.findViewById(R.id.tvImporte);
        }
    }
}
