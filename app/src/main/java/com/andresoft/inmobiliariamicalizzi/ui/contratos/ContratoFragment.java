package com.andresoft.inmobiliariamicalizzi.ui.contratos;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.andresoft.inmobiliariamicalizzi.R;
import com.andresoft.inmobiliariamicalizzi.modelo.Contrato;

public class ContratoFragment extends Fragment {

    private ContratoViewModel contratoViewModel;
    private TextView tvId;
    private TextView tvDireccion;
    private TextView tvFechaInicio;
    private TextView tvFechaFin;
    private TextView tvInquilino;
    private TextView tvPrecio;
    private Button btPagos;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.contrato_fragment, container, false);
        contratoViewModel = new ViewModelProvider(this).get(ContratoViewModel.class);
        inicializar(root);
        return root;
    }

    public void inicializar(View view){
        tvId = view.findViewById(R.id.tvidContrato);
        tvDireccion = view.findViewById(R.id.tvDireccion);
        tvFechaInicio = view.findViewById(R.id.tvFechaInicio);
        tvFechaFin = view.findViewById(R.id.tvFechaFin);
        tvInquilino = view.findViewById(R.id.tvInquilino);
        tvPrecio = view.findViewById(R.id.tvPrecio);
        btPagos = view.findViewById(R.id.btPagos);
        contratoViewModel = ViewModelProvider.AndroidViewModelFactory.getInstance(getActivity().getApplication()).create(ContratoViewModel.class);
        contratoViewModel.getContrato().observe(getActivity(), new Observer<Contrato>() {
            @Override
            public void onChanged(Contrato contrato) {
                tvId.setText(contrato.getIdContrato()+"");
                tvDireccion.setText(contrato.getInmueble().getDireccion());
                tvFechaInicio.setText(contrato.getFechaInicio());
                tvFechaFin.setText(contrato.getFechaFin());
                tvInquilino.setText(contrato.getInquilino().getNombre()+""+contrato.getInquilino().getApellido());
                tvPrecio.setText("$"+contrato.getMontoAlquiler());
            }
        });
        btPagos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Contrato con = new Contrato();
                con.setIdContrato(Integer.parseInt(tvId.getText().toString()));
                Bundle bundle = new Bundle();
                bundle.putSerializable("contrato", con);
                Navigation.findNavController(getActivity(), R.id.nav_host_fragment_content_main).navigate(R.id.pagosFragment, bundle);
            }
        });
        contratoViewModel.cargarContrato(getArguments());
    }

}