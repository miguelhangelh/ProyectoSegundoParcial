/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

import java.sql.Date;

/**
 *
 * @author home
 *  private int idTransferencias;
    private float monto;
    private String fecha;
    private String descripcion;
    private int cuentaOrigen;
    private int CuentaDestino;
 */
public class TransferenciaListas {
     private int idTransferencias;
     private float monto;
     private Date fecha;
     private String descripcion;
     private int cuentaOrigen;
     private int CuentaDestino;

    public int getIdTransferencias() {
        return idTransferencias;
    }

    public void setIdTransferencias(int idTransferencias) {
        this.idTransferencias = idTransferencias;
    }

    public float getMonto() {
        return monto;
    }

    public void setMonto(float monto) {
        this.monto = monto;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getCuentaOrigen() {
        return cuentaOrigen;
    }

    public void setCuentaOrigen(int cuentaOrigen) {
        this.cuentaOrigen = cuentaOrigen;
    }

    public int getCuentaDestino() {
        return CuentaDestino;
    }

    public void setCuentaDestino(int CuentaDestino) {
        this.CuentaDestino = CuentaDestino;
    }
 
      
    
}
