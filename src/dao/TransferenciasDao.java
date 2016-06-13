/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;
import Ventanas.InternalFrameTransferencias;
import dto.Transferencias;
import dto.TransferenciaListas;
import java.util.ArrayList;


/**
 *
 * @author home
 */
public abstract class TransferenciasDao {
    
        public abstract boolean insert(Transferencias obj) throws Exception;

	public abstract int update(Transferencias obj) throws Exception;

	public abstract void delete(int id);

	public abstract ArrayList<TransferenciaListas> getList();

	public abstract Transferencias get(int id);

}
