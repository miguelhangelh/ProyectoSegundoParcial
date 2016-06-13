/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dal.Conexion;
import dto.TransferenciaListas;
import dto.Transferencias;
import java.sql.Date;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author home
 * 
 */
public class TransferenciasDaoSQLServer  extends TransferenciasDao{

    @Override
    public boolean insert(Transferencias obj) throws Exception {
                Conexion objConexion = Conexion.getOrCreate();
        
        boolean id;
        
        StringBuilder query = new StringBuilder("{call sp_transferenciasInsert(");
        query.append(obj.getIdTransferencias() + ",");
        query.append(obj.getMonto() + ",");
        query.append("'" + obj.getFecha() + "',");
        query.append("'" + obj.getDescripcion() + "',");
        query.append(obj.getCuentaOrigen() + ",");
        query.append("'" + obj.getCuentaDestino() + "')");
        query.append("}");
        id = objConexion.ejecutarInsert(query.toString());
        if (id == false) {
            throw new Exception("El registro no pudo ser insertado");
        }
        objConexion.desconectar();
        return true;
    }

    @Override
    public int update(Transferencias obj) throws Exception {
       return 0;
    }

    @Override
    public void delete(int id_transferencia) {
        Conexion objConexion = Conexion.getOrCreate(); 
        StringBuilder query = new StringBuilder("{call sp_transferenciasDelete("); 
        query.append(id_transferencia + ")");
        query.append("}");
        objConexion.ejecutarSimple(query.toString());
        objConexion.desconectar();
    }
    
    @Override
    public Transferencias get(int id) {
        return null;
    }

    @Override
    public ArrayList<TransferenciaListas> getList() {
        
    ArrayList<TransferenciaListas> registros = new ArrayList<>();
        try {
            Conexion objConexion = Conexion.getOrCreate(); 
            String query = "{call sp_transferenciasSelectAll()}"; 
            
            ResultSet objResultSet = objConexion.ejecutarSelect(query);
            
            
             while (objResultSet.next()) {
                TransferenciaListas obj = new TransferenciaListas();
                int id_Transferencia = objResultSet.getInt("id_transferencia");
                obj.setIdTransferencias(id_Transferencia);
                
                float monto = objResultSet.getFloat("monto");
                obj.setMonto(monto);
                
                Date date = objResultSet.getDate("fecha");
                obj.setFecha(date);
                
                String descripcion = objResultSet.getString("descripcion");
                obj.setDescripcion(descripcion);
                
                int cuentaOrigen = objResultSet.getInt("cuentaOrigen");
                obj.setCuentaOrigen(cuentaOrigen);
                
                int cuentaDestino = objResultSet.getInt("cuentaDestino");
                obj.setCuentaDestino(cuentaDestino);
                
              registros.add(obj);
            }
            
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return registros;
    }
    



    
}
