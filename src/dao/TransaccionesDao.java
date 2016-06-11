/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;


import Ventanas.InternalFrameTransacciones;
import dto.Transacciones;
import dto.TransaccionesListas;
import java.util.ArrayList;

/**
 *
 * @author Jose Carlos Gutierrez
 */
public abstract class TransaccionesDao {

	public abstract boolean insert(Transacciones obj) throws Exception;

	public abstract int update(Transacciones obj) throws Exception;

	public abstract void delete(int id);

	public abstract ArrayList<TransaccionesListas> getList();

	public abstract Transacciones get(int id);

}