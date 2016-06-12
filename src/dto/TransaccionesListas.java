/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

import java.sql.Date;

/**
 *
 * @author usuario
 */
public class TransaccionesListas {

    private int idTransacciones;
    private String nombreCategoria;
    private float monto;
    private Date fecha;
    private int idCuenta;
    private int idCategoria;
    private String descripcion;
    private String NombreCuenta;

    public TransaccionesListas() {
    }

    public int getIdTransacciones() {
        return idTransacciones;
    }

    public void setIdTransacciones(int idTransacciones) {
        this.idTransacciones = idTransacciones;
    }

    public String getNombreCategoria() {
        return nombreCategoria;
    }

    public void setNombreCategoria(String nombreCategoria) {
        this.nombreCategoria = nombreCategoria;
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

    public String getNombreCuenta() {
        return NombreCuenta;
    }

    public void setNombreCuenta(String NombreCuenta) {
        this.NombreCuenta = NombreCuenta;
    }

}
