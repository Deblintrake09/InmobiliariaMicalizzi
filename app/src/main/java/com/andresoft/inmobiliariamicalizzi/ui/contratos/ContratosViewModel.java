package com.andresoft.inmobiliariamicalizzi.ui.contratos;

import android.app.Application;
import android.content.Context;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;


import com.andresoft.inmobiliariamicalizzi.RequestAPI.ApiClient;
import com.andresoft.inmobiliariamicalizzi.modelo.Contrato;
import com.andresoft.inmobiliariamicalizzi.modelo.Inmueble;

import java.util.ArrayList;

public class ContratosViewModel extends AndroidViewModel {
    private MutableLiveData<ArrayList<Contrato>> contratos;
    private Context context;
    public ContratosViewModel(@NonNull Application app){
        super(app);
        context = app.getApplicationContext();
    }

    public MutableLiveData<ArrayList<Contrato>> getContratos() {
        if (contratos==null){
            contratos = new MutableLiveData<>();
        }
        return contratos;
    }

    public void cargarContratos(){
        ApiClient api = ApiClient.getApi();
        ArrayList<Inmueble> propAlquiladas = api.obtenerPropiedadesAlquiladas();
        ArrayList<Contrato> contratos = new ArrayList<>();
        for (int p = 0; p< propAlquiladas.size(); p++){
            contratos.add(api.obtenerContratoVigente(propAlquiladas.get(p)));
        }
        this.contratos.setValue(contratos);
    }
}