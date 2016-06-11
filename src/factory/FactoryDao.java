package factory;

import dal.Configuracion;
import dao.*;


public abstract class FactoryDao {

    protected static FactoryDao instancia;
    protected String dbEngine;

    public static FactoryDao getFactoryInstance() {
        Configuracion config = Configuracion.getConfiguracion();
        if (instancia == null || !instancia.getDbEngine().equals(config.getDbEngine())) {

            if (config.getDbEngine().equals("SQLServer"));
            instancia = FactoryDaoMySQL.getFactoryInstance();
        }
        return instancia;
    }

    public abstract CuentaDao getNewCuentaDao();

    private String getDbEngine() {
        return dbEngine;
    }

    private void setDbEngine(String dbEngine) {
        this.dbEngine = dbEngine;
    }

}
