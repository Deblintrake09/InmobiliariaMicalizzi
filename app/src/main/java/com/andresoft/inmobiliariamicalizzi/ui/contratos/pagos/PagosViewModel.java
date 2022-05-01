package com.andresoft.inmobiliariamicalizzi.ui.contratos.pagos;

import android.app.Application;
import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.andresoft.inmobiliariamicalizzi.RequestAPI.ApiClient;
import com.andresoft.inmobiliariamicalizzi.modelo.Contrato;
import com.andresoft.inmobiliariamicalizzi.modelo.Pago;

import java.util.ArrayList;

public class PagosViewModel extends AndroidViewModel {
    private MutableLiveData<ArrayList<Pago>> pagos;
    private Context context;
    public PagosViewModel(@NonNull Application app){
        super(app);
        context = app.getApplicationContext();
    }

    public MutableLiveData<ArrayList<Pago>> getPagos() {
        if (pagos==null){
            pagos = new MutableLiveData<>();
        }
        return pagos;
    }

    public void cargarPagos(Bundle bundle){
        ApiClient api = ApiClient.getApi();
        Contrato con = (Contrato) bundle.getSerializable("contrato");
        ArrayList<Pago> pagos = api.obtenerPagos(con);
        this.pagos.setValue(pagos);
    }
}