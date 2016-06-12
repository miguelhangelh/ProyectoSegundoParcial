/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import dao.CuentaDao;
import dto.Cuenta;
import factory.FactoryDao;
import java.util.ArrayList;


public class MainTest {

    public static void main(String[] args) {

        try {
            CuentaDao objDao = FactoryDao.getFactoryInstance().getNewCuentaDao();
            
            // Metodo para insertar
            Cuenta a = new Cuenta();
            a.setNombre("miguela");
            a.setSaldoInicial(22);   
            objDao.insert(a);
            // Metodo para actualizarç
            
//            a.setNombre("miguel");
//            a.setSaldoInicial(22);
//            a.setId_cuenta(15);
//            
//            // Metodo para eliminar
//            
//            objDao.delete(15);
//
//            // metodo para seleccionar una cuenta
//            System.out.println("devolvio " +objDao.get(13).getNombre() + " " + objDao.get(13).getSaldoInicial());
//            
//             //Metodo para cargar todos los datos de la tabla
//            ArrayList<Cuenta> id = objDao.getList();
//            for (Cuenta cuenta : id) {
//                System.out.println(cuenta.getNombre()+ " " +cuenta.getSaldoInicial());
//               
//            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

}
