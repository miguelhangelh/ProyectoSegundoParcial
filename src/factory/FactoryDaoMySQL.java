package factory;

import dao.*;

class FactoryDaoMySQL extends FactoryDao {

    private FactoryDaoMySQL() {
        dbEngine = "SQLServer";
    }

    public static FactoryDao getFactoryInstance() {
        instancia = new FactoryDaoMySQL();
        return instancia;
    }

    @Override
    public CuentaDao getNewCuentaDao() {
        return new CuentaDaoSQLServer();
    }

    @Override
    public CategoriaDao getNewCategoriasDao() {
        return new CategoriaDaoSQLServer();
    }

    @Override
    public TransaccionesDao getNewTransaccionesDao() {
        return new TransaccionesDaoSQLServer();
    }

}
