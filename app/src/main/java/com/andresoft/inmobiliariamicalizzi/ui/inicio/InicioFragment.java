package com.andresoft.inmobiliariamicalizzi.ui.inicio;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.andresoft.inmobiliariamicalizzi.R;
import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;


public class InicioFragment extends Fragment{

    private GoogleMap mapa;
    private LatLng SANLUIS = new LatLng(-33.280576, -66.332482);

    private InicioViewModel inicioViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        inicioViewModel = new ViewModelProvider(this).get(InicioViewModel.class);

        View root = inflater.inflate(R.layout.fragment_inicio, container, false);
        SupportMapFragment mapFragment = (SupportMapFragment) getChildFragmentManager().findFragmentById(R.id.frMapa);
        mapFragment.getMapAsync(new MapaActual());
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }


    public class MapaActual implements OnMapReadyCallback{
        @Override
        public void onMapReady(@NonNull GoogleMap googleMap) {
            mapa = googleMap;
            CameraPosition pos = new CameraPosition.Builder()
                    .target(SANLUIS)
                    .zoom(19)
                    .bearing(45)
                    .tilt(70).build();
            CameraUpdate camUpdate = CameraUpdateFactory.newCameraPosition(pos);
            mapa.animateCamera(camUpdate);
            mapa.addMarker(new MarkerOptions().position(SANLUIS)).setTitle("San Luis");
            mapa.setMapType(GoogleMap.MAP_TYPE_HYBRID);
            mapa.setOnMapLongClickListener(new GoogleMap.OnMapLongClickListener() {
                @Override
                public void onMapLongClick(@NonNull LatLng latLng) {
                    mapa.addMarker(new MarkerOptions().position(latLng)).setTitle("Marcador");
                }
            });
        }
    }
}