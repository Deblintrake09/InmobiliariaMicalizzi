package com.andresoft.inmobiliariamicalizzi.ui.inquilinos;

import android.os.Bundle;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.andresoft.inmobiliariamicalizzi.modelo.Inquilino;

public class InquilinoViewModel extends ViewModel {
    private MutableLiveData<Inquilino> inquilino;

    public InquilinoViewModel(){ super();}

    public LiveData<Inquilino> getInquilino(){
        if ( inquilino== null){
            inquilino = new MutableLiveData<>();
        }
        return inquilino;
    }

    public void cargarInquilino(Bundle bundle){
        Inquilino inquilino = (Inquilino) bundle.getSerializable("inquilino");
        this.inquilino.setValue(inquilino);
    }
}