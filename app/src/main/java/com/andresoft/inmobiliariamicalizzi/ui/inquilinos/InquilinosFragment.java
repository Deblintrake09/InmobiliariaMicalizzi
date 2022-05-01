package com.andresoft.inmobiliariamicalizzi.ui.inquilinos;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.andresoft.inmobiliariamicalizzi.R;
import com.andresoft.inmobiliariamicalizzi.modelo.Contrato;
import com.andresoft.inmobiliariamicalizzi.ui.contratos.ContratoAdapter;
import com.andresoft.inmobiliariamicalizzi.ui.contratos.ContratosViewModel;

import java.util.ArrayList;

public class InquilinosFragment extends Fragment {

    private InquilinosViewModel inquilinosViewModel;
    private RecyclerView rvInquilinos;
    private InquilinoAdapter adapter;
    private Context context;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.inquilinos_fragment, container, false);
        context = root.getContext();
        inicializar(root);
        return root;
    }

    private void inicializar(View view){
        rvInquilinos = view.findViewById(R.id.rvInquilinos);
        inquilinosViewModel = ViewModelProvider.AndroidViewModelFactory.getInstance(getActivity().getApplication()).create(InquilinosViewModel.class);
        inquilinosViewModel.getContratos().observe(getViewLifecycleOwner(), new Observer<ArrayList<Contrato>>() {
            @Override
            public void onChanged(ArrayList<Contrato> contratos) {
                GridLayoutManager gridLayoutManager = new GridLayoutManager(context,2, GridLayoutManager.VERTICAL, false);
                rvInquilinos.setLayoutManager(gridLayoutManager);
                adapter = new InquilinoAdapter(context, contratos, getLayoutInflater());
                rvInquilinos.setAdapter(adapter);
            }
        });
        inquilinosViewModel.cargarInquilinos();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }

}