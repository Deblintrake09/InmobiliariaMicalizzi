package com.andresoft.inmobiliariamicalizzi.ui.inquilinos;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.andresoft.inmobiliariamicalizzi.R;
import com.andresoft.inmobiliariamicalizzi.modelo.Inquilino;

public class InquilinoFragment extends Fragment {

    private InquilinoViewModel inquilinoViewModel;
    private TextView tvCodigoInquilino;
    private TextView tvNombre;
    private TextView tvApellido;
    private TextView tvDNI;
    private TextView tvEmail;
    private TextView tvTelInquilino;
    private TextView tvGarante;
    private TextView tvTelGarante;

        @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.inquilino_fragment, container, false);
        inquilinoViewModel = new ViewModelProvider(this).get(InquilinoViewModel.class);
        inicializar(root);
        return root;
    }

    public void inicializar(View view){
            tvCodigoInquilino =view.findViewById(R.id.tvCodigoInquilino);
            tvNombre = view.findViewById(R.id.tvNombre);
            tvApellido = view.findViewById(R.id.tvApellido);
            tvDNI = view.findViewById(R.id.tvDNI);
            tvEmail = view.findViewById(R.id.tvEmail);
            tvTelInquilino = view.findViewById(R.id.tvTelInquilino);
            tvTelGarante= view.findViewById(R.id.tvTelGarante);
            tvGarante = view.findViewById(R.id.tvGarante);
            inquilinoViewModel = ViewModelProvider.AndroidViewModelFactory.getInstance(getActivity().getApplication()).create(InquilinoViewModel.class);
            inquilinoViewModel.getInquilino().observe(getActivity(), new Observer<Inquilino>() {
                @Override
                public void onChanged(Inquilino inquilino) {
                    tvCodigoInquilino.setText(""+inquilino.getIdInquilino());
                    tvNombre.setText(inquilino.getNombre());
                    tvApellido.setText(inquilino.getApellido());
                    tvDNI.setText(""+inquilino.getDNI());
                    tvEmail.setText(""+inquilino.getEmail());
                    tvTelInquilino.setText(""+inquilino.getTelefono());
                    tvGarante.setText(inquilino.getNombreGarante()+" ");
                    tvTelGarante.setText(""+inquilino.getTelefonoGarante());
                }
            });
            inquilinoViewModel.cargarInquilino(getArguments());
    }

}