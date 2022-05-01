package com.andresoft.inmobiliariamicalizzi.ui.inmuebles;

import android.app.Application;
import android.content.Context;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.andresoft.inmobiliariamicalizzi.RequestAPI.ApiClient;
import com.andresoft.inmobiliariamicalizzi.modelo.Inmueble;

import java.util.ArrayList;

public class InmueblesViewModel extends AndroidViewModel {

    private MutableLiveData<ArrayList<Inmueble>> inmuebles;
    private Context context;
    public InmueblesViewModel(@NonNull Application app){
        super(app);
        context = app.getApplicationContext();
    }

    public MutableLiveData<ArrayList<Inmueble>> getInmuebles() {
        if (inmuebles==null){
            inmuebles = new MutableLiveData<>();
        }
        return inmuebles;
    }

    public void cargarInmuebles(){
        ApiClient api = ApiClient.getApi();
        ArrayList<Inmueble> inmuebles = api.obtnerPropiedades();
        this.inmuebles.setValue(inmuebles);
    }

}