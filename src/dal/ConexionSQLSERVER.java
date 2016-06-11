package dal;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

class ConexionSQLSERVER extends Conexion {

    public static Conexion getOrCreate() {
        if (objSingleton == null) {
            objSingleton = new ConexionSQLSERVER();
        }
        return objSingleton;
    }

    private ConexionSQLSERVER() {
        Configuracion objConfiguracion = Configuracion.getConfiguracion();
        this.host = objConfiguracion.getDbHost();
        this.dataBase = objConfiguracion.getDbName();
        this.instance = objConfiguracion.getDbInstace();
        this.port = objConfiguracion.getDbPort();
        this.userName = objConfiguracion.getDbUser();
        this.password = objConfiguracion.getDbPassword();
    }

    @Override
    public void conectar() {
        if (this.estaConectado()) {
            return;
        } else {
            try {
                Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();
            } catch (InstantiationException e) {
                System.out.println(e);
            } catch (IllegalAccessException | ClassNotFoundException e) {
                System.out.println(e);
            }
            try {
               
                String sUrl = "jdbc:sqlserver://" + this.host + ":" + this.port + ";" + "database=" + this.dataBase;
                System.out.println(sUrl);
                objConnection = DriverManager.getConnection(sUrl, userName, password);
                
            } catch (SQLException e) {
                e.toString();
            }
        }

    }

    @Override
    public void comenzarTransaccion() {
        if (!this.estaConectado()) {
            this.conectar();
        }

        try {
            objConnection.setAutoCommit(false);
        } catch (SQLException e) {
            e.toString();
        }
    }

    @Override
    public void terminarTransaccion() {
        try {
            objConnection.commit();
        } catch (SQLException e) {
            e.toString();
        }
    }

    @Override
    public void desconectar() {
        try {
            if (this.estaConectado()) {
                objConnection.close();
            }
        } catch (SQLException e) {
        }
    }

    @Override
    public ResultSet ejecutarSelect(String query) {
        try {
            Statement stmt = objConnection.createStatement();
            ResultSet res = stmt.executeQuery(query);
            return res;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public boolean estaConectado() {
        if (this.objConnection == null) {
            return false;
        }
        try {
            if (this.objConnection.isClosed()) {
                return false;
            }
        } catch (SQLException e) {
            this.objConnection = null;
            return false;
        }
        return true;
    }

    @Override
    public int ejecutarSimple(String query) {
        try {
            Statement stmt = objConnection.createStatement();
            int nb = stmt.executeUpdate(query);
            return nb;
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }
    }

    @Override
    public boolean ejecutarInsert(String query) {
        try {
            Statement stmt = objConnection.createStatement();
            boolean a = stmt.execute(query);
           
            return a;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
