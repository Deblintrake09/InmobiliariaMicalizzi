package com.andresoft.inmobiliariamicalizzi;

import android.app.Application;
import android.content.Context;
import android.content.Intent;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.andresoft.inmobiliariamicalizzi.RequestAPI.ApiClient;
import com.andresoft.inmobiliariamicalizzi.modelo.Propietario;


public class LoginViewModel extends AndroidViewModel {

    private Context context;
    private MutableLiveData<String> mensaje;

    public LoginViewModel(@NonNull Application application) {
        super(application);
        this.context = application.getApplicationContext();
    }

    public LiveData<String> getMensaje() {
        if(mensaje==null){
            mensaje= new MutableLiveData<>();
        }
        return mensaje;
    }

    public void iniciarSesion(String usuario, String contraseña){
        ApiClient api = ApiClient.getApi();
        Propietario usuarioLogeado = api.login(usuario, contraseña);
        if(usuarioLogeado !=null){
            Intent intent = new Intent(context, MainActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(intent);
        }else {
            mensaje.setValue("Usuario y/o Contraseña incorrectos!!!");
        }
    }
}
