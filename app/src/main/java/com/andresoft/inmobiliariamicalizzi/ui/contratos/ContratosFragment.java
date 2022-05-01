package com.andresoft.inmobiliariamicalizzi.ui.contratos;

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

import java.util.ArrayList;

public class ContratosFragment extends Fragment {

    private ContratosViewModel contratosViewModel;
    private RecyclerView rvContratos;
    private ContratoAdapter adapter;
    private Context context;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.contratos_fragment, container, false);
        context = root.getContext();
        inicializar(root);
        return root;
    }

    private void inicializar(View view){
        rvContratos = view.findViewById(R.id.rvContratos);
        contratosViewModel = ViewModelProvider.AndroidViewModelFactory.getInstance(getActivity().getApplication()).create(ContratosViewModel.class);
        contratosViewModel.getContratos().observe(getViewLifecycleOwner(), new Observer<ArrayList<Contrato>>() {
            @Override
            public void onChanged(ArrayList<Contrato> contratos) {
                GridLayoutManager gridLayoutManager = new GridLayoutManager(context,2, GridLayoutManager.VERTICAL, false);
                rvContratos.setLayoutManager(gridLayoutManager);
                adapter = new ContratoAdapter(context, contratos, getLayoutInflater());
                rvContratos.setAdapter(adapter);
            }
        });
        contratosViewModel.cargarContratos();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }

}