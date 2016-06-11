/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

public class Categoria {

    private int idCategoria ;
    private String NombreCategoria;
    private String TipoCategoria;

    public Categoria() {
    }
    
    public int getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(int idCategoria) {
        this.idCategoria = idCategoria;
    }

    public String getNombreCategoria() {
        return NombreCategoria;
    }

    public void setNombreCategoria(String NombreCategoria) {
        this.NombreCategoria = NombreCategoria;
    }

    public String getTipoCategoria() {
        return TipoCategoria;
    }

    public void setTipoCategoria(String TipoCategoria) {
        this.TipoCategoria = TipoCategoria;
    }

    @Override
    public String toString() {
        return "Categoria{" + "idCategoria=" + idCategoria + ", NombreCategoria=" + NombreCategoria + ", TipoCategoria=" + TipoCategoria + '}';
    }
    
    
}
