package com.andresoft.inmobiliariamicalizzi.modelo;

import java.io.Serializable;
import java.util.Objects;

public class Pago implements Serializable {

    private int idPago;
    private int numero;
    private Contrato contrato;
    private double importe;
    private String fechaPago;

    public Pago() {
    }

    public Pago(int idPago, int numero, Contrato contrato, double importe, String fechaPago) {
        this.idPago = idPago;
        this.numero = numero;
        this.contrato = contrato;
        this.importe = importe;
        this.fechaPago = fechaPago;
    }

    public int getIdPago() {
        return idPago;
    }

    public void setIdPago(int idPago) {
        this.idPago = idPago;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public Contrato getContrato() {
        return contrato;
    }

    public void setContrato(Contrato contrato) {
        this.contrato = contrato;
    }

    public double getImporte() {
        return importe;
    }

    public void setImporte(double importe) {
        this.importe = importe;
    }

    public String getFechaPago() {
        return fechaPago;
    }

    public void setFechaPago(String fechaPago) {
        this.fechaPago = fechaPago;
    }

    @Override
    public boolean equals(Object o){
        if (this==o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pago that = (Pago) o;
        return idPago == that.idPago;
    }

    @Override
    public int hashCode(){
        return Objects.hash(idPago);
    }

}
