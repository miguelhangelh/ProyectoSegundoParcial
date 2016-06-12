package dao;

import dal.Conexion;
import dto.Cuenta;

import java.awt.List;
import java.util.ArrayList;
import java.sql.ResultSet;
import java.util.Vector;

public class CuentaDaoSQLServer extends CuentaDao {

    @Override
    public boolean insert(Cuenta obj) throws Exception {
        Conexion objConexion = Conexion.getOrCreate();

        boolean id;

        StringBuilder query = new StringBuilder("{call sp_cuentaInsert(");
        query.append("'" + obj.getNombre() + "',");
        query.append("'" + obj.getSaldoInicial() + "')");
        query.append("}");
        id = objConexion.ejecutarInsert(query.toString());
        if (id == false) {
            throw new Exception("El registro no pudo ser insertado");
        }
        objConexion.desconectar();
        return true;
    }

    @Override
    public int update(Cuenta obj) throws Exception {
        Conexion objConexion = Conexion.getOrCreate();
        int upd = 0;
        StringBuilder query = new StringBuilder("{call sp_cuentaUpdate(");
        query.append("" + obj.getId_cuenta() + ",");
        query.append("'" + obj.getNombre() + "',");
        query.append(obj.getSaldoInicial() + ")");
        query.append("}");
        upd = objConexion.ejecutarSimple(query.toString());
        if (upd == 0) {

            throw new Exception("El registro no pudo ser actualizado");
        }

        objConexion.desconectar();
        return upd;
    }

    @Override
    public void delete(int id) {
        Conexion objConexion = Conexion.getOrCreate();
        StringBuffer query = new StringBuffer("{call sp_cuentaDelete(");
        query.append(id + ")");
        query.append("}");
        objConexion.ejecutarSimple(query.toString());
        objConexion.desconectar();
    }

    @Override
    public Cuenta get(int id) {
        try {
            Conexion objConexion = Conexion.getOrCreate();
            String query = "{call sp_cuentaSelect(" + id + ")}";
            ResultSet objResultSet = objConexion.ejecutarSelect(query);
            if (objResultSet.next()) {
                Cuenta obj = new Cuenta();
                int _id_cuenta = objResultSet.getInt("id_cuenta");
                obj.setId_cuenta(_id_cuenta);

                String _nombre_cuenta = objResultSet.getString("nombre_cuenta");
                obj.setNombre(_nombre_cuenta);

                float _saldoInicial = objResultSet.getFloat("saldo_inicial");
                obj.setSaldoInicial(_saldoInicial);

                return obj;
            }
        } catch (Exception ex) {

        }
        return null;
    }

    @Override
    public ArrayList<Cuenta> getList() {
        ArrayList<Cuenta> registros = new ArrayList<>();
        try {
            Conexion objConexion = Conexion.getOrCreate();
            String query = "{call sp_cuentaSelectAll()}";

            ResultSet objResultSet = objConexion.ejecutarSelect(query);
            while (objResultSet.next()) {
                Cuenta obj = new Cuenta();

                int idCuenta = objResultSet.getInt("id_cuenta");
                obj.setId_cuenta(idCuenta);

                String _contactoId = objResultSet.getString("nombre_cuenta");
                obj.setNombre(_contactoId);

                float _nombre = objResultSet.getFloat("saldo_inicial");
                obj.setSaldoInicial(_nombre);

                registros.add(obj);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return registros;
    }

  
}
