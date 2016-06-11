/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

public class Cuenta {

    private int id_cuenta;
    private String nombre;
    private float SaldoInicial;

    public Cuenta() {
    }

    public Cuenta(int id_cuenta, String nombre) {
        this.id_cuenta = id_cuenta;
        this.nombre = nombre;
    }

    public int getId_cuenta() {
        return id_cuenta;
    }

    public void setId_cuenta(int id_cuenta) {
        this.id_cuenta = id_cuenta;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public float getSaldoInicial() {
        return SaldoInicial;
    }

    public void setSaldoInicial(float SaldoInicial) {
        this.SaldoInicial = SaldoInicial;
    }

    @Override
    public String toString() {
        return this.nombre;
    }

}
