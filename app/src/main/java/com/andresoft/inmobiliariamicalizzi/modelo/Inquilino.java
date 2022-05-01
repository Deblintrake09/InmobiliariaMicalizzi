package com.andresoft.inmobiliariamicalizzi.modelo;

import java.io.Serializable;
import java.util.Objects;

public class Inquilino implements Serializable {

    private int idInquilino;
    private Long DNI;
    private String nombre;
    private String apellido;
    private String lugarTrabajo;
    private String email;
    private String telefono;
    private String nombreGarante;
    private String telefonoGarante;

    public Inquilino() {
    }

    public Inquilino(int idInquilino, Long DNI, String nombre, String apellido, String lugarTrabajo, String email, String telefono, String nombreGarante, String telefonoGarante) {
        this.idInquilino = idInquilino;
        this.DNI = DNI;
        this.nombre = nombre;
        this.apellido = apellido;
        this.lugarTrabajo = lugarTrabajo;
        this.email = email;
        this.telefono = telefono;
        this.nombreGarante = nombreGarante;
        this.telefonoGarante = telefonoGarante;
    }

    public int getIdInquilino() {
        return idInquilino;
    }

    public void setIdInquilino(int idInquilino) {
        this.idInquilino = idInquilino;
    }

    public Long getDNI() {
        return DNI;
    }

    public void setDNI(Long DNI) {
        this.DNI = DNI;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getLugarTrabajo() {
        return lugarTrabajo;
    }

    public void setLugarTrabajo(String lugarTrabajo) {
        this.lugarTrabajo = lugarTrabajo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getNombreGarante() {
        return nombreGarante;
    }

    public void setNombreGarante(String nombreGarante) {
        this.nombreGarante = nombreGarante;
    }

    public String getTelefonoGarante() {
        return telefonoGarante;
    }

    public void setTelefonoGarante(String telefonoGarante) {
        this.telefonoGarante = telefonoGarante;
    }

    @Override
    public boolean equals(Object o){
        if (this==o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Inquilino that = (Inquilino) o;
        return idInquilino == that.idInquilino;
    }

    @Override
    public int hashCode(){
        return Objects.hash(idInquilino);
    }
}
