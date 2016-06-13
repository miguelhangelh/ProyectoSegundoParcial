package dao;

import dal.Conexion;
import dto.Categoria;
import dto.Cuenta;
import java.util.ArrayList;
import java.sql.ResultSet;

public class CategoriaDaoSQLServer extends CategoriaDao {

    @Override
    public boolean insert(Categoria obj) throws Exception {
        Conexion objConexion = Conexion.getOrCreate();

        boolean id;

        StringBuilder query = new StringBuilder("{call sp_CategoriaInsert(");
        query.append("'" + obj.getNombreCategoria() + "',");
        query.append("'" + obj.getTipoCategoria() + "')");
        query.append("}");
        id = objConexion.ejecutarInsert(query.toString());
        if (id == false) {
            throw new Exception("El registro no pudo ser insertado");
        }
        objConexion.desconectar();
        return true;
    }

    @Override
    public int update(Categoria obj) throws Exception {
        Conexion objConexion = Conexion.getOrCreate();
        int upd = 0;
        StringBuilder query = new StringBuilder("{call sp_cuentaUpdate(");
        query.append("" + obj.getIdCategoria() + ",");
        query.append("'" + obj.getNombreCategoria() + "',");
        query.append("'" + obj.getTipoCategoria() + "')");
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
        StringBuffer query = new StringBuffer("{call sp_CategoriaDelete(");
        query.append(id + ")");
        query.append("}");
        objConexion.ejecutarSimple(query.toString());
        objConexion.desconectar();
    }

    @Override
    public Categoria get(int id) {
        try {
            Conexion objConexion = Conexion.getOrCreate();
            String query = "{call sp_cuentaSelect(" + id + ")}";
            ResultSet objResultSet = objConexion.ejecutarSelect(query);
            if (objResultSet.next()) {
                Categoria obj = new Categoria();
                int _id_cuenta = objResultSet.getInt("id_cuenta");
                obj.setIdCategoria(_id_cuenta);

                String _nombre_cuenta = objResultSet.getString("nombre_cuenta");
                obj.setNombreCategoria(_nombre_cuenta);

                String _saldoInicial = objResultSet.getString("saldo_inicial");
                obj.setTipoCategoria(_saldoInicial);

                return obj;
            }
        } catch (Exception ex) {

        }
        return null;
    }

    @Override
    public ArrayList<Categoria> getList() {
        ArrayList<Categoria> registros = new ArrayList<>();
        try {
            Conexion objConexion = Conexion.getOrCreate();
            String query = "{call sp_CategoriaSelectAll()}";

            ResultSet objResultSet = objConexion.ejecutarSelect(query);
            while (objResultSet.next()) {
                Categoria obj = new Categoria();

                int id_Categoria = objResultSet.getInt("id_categoria");
                obj.setIdCategoria(id_Categoria);

                String _nombre_Cuenta = objResultSet.getString("nombre_categoria");
                obj.setNombreCategoria(_nombre_Cuenta);

                String _nombre = objResultSet.getString("tipo_categoria");
                obj.setTipoCategoria(_nombre);

                registros.add(obj);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return registros;
    }

}
