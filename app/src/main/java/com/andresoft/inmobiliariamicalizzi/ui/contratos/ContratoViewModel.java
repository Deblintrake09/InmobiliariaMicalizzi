package com.andresoft.inmobiliariamicalizzi.ui.contratos;

import android.os.Bundle;
import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.andresoft.inmobiliariamicalizzi.modelo.Contrato;

public class ContratoViewModel extends ViewModel {
    private MutableLiveData<Contrato> contrato;

    public ContratoViewModel(){ super();}

    public LiveData<Contrato> getContrato(){
        if ( contrato== null){
            contrato = new MutableLiveData<>();
        }
        return contrato;
    }

    public void cargarContrato(Bundle bundle){
        Contrato contrato = (Contrato) bundle.getSerializable("contrato");
        this.contrato.setValue(contrato);
    }
}