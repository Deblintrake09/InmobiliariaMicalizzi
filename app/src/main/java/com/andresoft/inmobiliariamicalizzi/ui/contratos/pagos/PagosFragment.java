package com.andresoft.inmobiliariamicalizzi.ui.contratos.pagos;

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
import com.andresoft.inmobiliariamicalizzi.modelo.Pago;

import java.util.ArrayList;

public class PagosFragment extends Fragment {

    private PagosViewModel pagosViewModel;
    private RecyclerView rvPagos;
    private PagosAdapter adapter;
    private Context context;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View root =  inflater.inflate(R.layout.pagos_fragment, container, false);
        context = root.getContext();
        inicializar(root);
        return root;
    }

    private void inicializar(View view){
        rvPagos = view.findViewById(R.id.rvPagos);
        pagosViewModel = ViewModelProvider.AndroidViewModelFactory.getInstance(getActivity().getApplication()).create(PagosViewModel.class);
        pagosViewModel.getPagos().observe(getViewLifecycleOwner(), new Observer<ArrayList<Pago>>() {
            @Override
            public void onChanged(ArrayList<Pago> pagos) {
                GridLayoutManager gridLayoutManager = new GridLayoutManager(context, 1, GridLayoutManager.VERTICAL,false);
                rvPagos.setLayoutManager(gridLayoutManager);
                adapter = new PagosAdapter(context, pagos,getLayoutInflater());
                rvPagos.setAdapter(adapter);
            }
        });
        pagosViewModel.cargarPagos(getArguments());
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }
}