package com.andresoft.inmobiliariamicalizzi;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.Manifest;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.List;

public class LoginActivity extends AppCompatActivity {
    private Button btLogin;
    private EditText etUsuario, etContraseña;
    private LoginViewModel loginViewModel;
    private SensorManager sensorManager;
    private LeeSensor leeSensor;
    private Llamada llamada;
    private int flag = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        loginViewModel = ViewModelProvider.AndroidViewModelFactory.getInstance(getApplication()).create(LoginViewModel.class);

        solicitarPermisos();
        obtenerSensores();

        inicializarVista();
        loginViewModel.getMensaje().observe(this, new Observer<String>(){
            @Override
            public void onChanged(String s) {
                Toast.makeText(LoginActivity.this, s, Toast.LENGTH_LONG).show();
            }
        });
    }


    private void inicializarVista(){
        btLogin = findViewById(R.id.btLogin);
        etUsuario = findViewById(R.id.etEmail);
        etContraseña = findViewById(R.id.etContraseña);
        btLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loginViewModel.iniciarSesion(etUsuario.getText().toString(), etContraseña.getText().toString());
            }
        });
    }

    public void obtenerSensores(){
        leeSensor = new LeeSensor();
        sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        List<Sensor> listaSensores = sensorManager.getSensorList(Sensor.TYPE_ACCELEROMETER);
        if(listaSensores.size() > 0){
            sensorManager.registerListener(leeSensor, listaSensores.get(0), SensorManager.SENSOR_DELAY_GAME);
        }
    }

    private void solicitarPermisos(){
        if(Build.VERSION.SDK_INT>= Build.VERSION_CODES.M && checkSelfPermission(Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED){
            requestPermissions(new String[]{Manifest.permission.CALL_PHONE}, 1000);
        }
        if(Build.VERSION.SDK_INT>= Build.VERSION_CODES.M && checkSelfPermission(Manifest.permission.INTERNET) != PackageManager.PERMISSION_GRANTED){
            requestPermissions(new String[]{Manifest.permission.INTERNET}, 1000);
        }
        if(Build.VERSION.SDK_INT>= Build.VERSION_CODES.M && checkSelfPermission(Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED){
            requestPermissions(new String[]{Manifest.permission.ACCESS_COARSE_LOCATION}, 1000);
        }
        if(Build.VERSION.SDK_INT>= Build.VERSION_CODES.M && checkSelfPermission(Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED){
            requestPermissions(new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, 1000);
        }
    }

    private class LeeSensor implements SensorEventListener{

        @Override
        public void onSensorChanged(SensorEvent sensorEvent) {
            if(flag == 0 && sensorEvent.values[0]>=20 || sensorEvent.values[0]<=-20){
                Uri tel = Uri.parse("tel:2664999999");
                startActivity(new Intent(Intent.ACTION_CALL, tel));
                flag=1;
            }
        }

        @Override
        public void onAccuracyChanged(Sensor sensor, int i) {

        }
    }

    public class Llamada extends BroadcastReceiver{

        @Override
        public void onReceive(Context context, Intent intent) {

        }
    }


}