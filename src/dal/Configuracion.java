package dal;

import java.io.*;
import org.jdom.*;
import org.jdom.input.*;


public class Configuracion {

    private String dbHost;
    private String dbInstace;
    private String dbUser;
    private String dbPassword;
    private String dbName;
    private String dbEngine;
    private String dbPort;

    private static Configuracion config;

    private Configuracion() {
        try {
            SAXBuilder builder = new SAXBuilder(false);
            InputStream in = Configuracion.class.getClassLoader().getResourceAsStream("Configuracion/config.xml");
            Document doc = builder.build(in);
            Element appConfig = doc.getRootElement();
            Element dbConfig = appConfig.getChild("db-config");
            this.dbEngine = dbConfig.getChild("db-engine").getText();
            this.dbHost = dbConfig.getChild("db-host").getText();
            this.dbPort = dbConfig.getChild("db-port").getText();
            this.dbInstace = dbConfig.getChild("db-instance").getText();
            this.dbName = dbConfig.getChild("db-name").getText();
            this.dbUser = dbConfig.getChild("db-user").getText();
            this.dbPassword = dbConfig.getChild("db-password").getText();
        } catch (JDOMException | IOException e) {
            e.printStackTrace();
        }
    }

    public static Configuracion getConfiguracion() {
        return new Configuracion();
    }

    public String getDbEngine() {
        return dbEngine;
    }

    public String getDbHost() {
        return dbHost;
    }

    public String getDbInstace() {
        return dbInstace;
    }

    public String getDbName() {
        return dbName;
    }

    public String getDbPassword() {
        return dbPassword;
    }

    public String getDbUser() {
        return dbUser;
    }

    public String getDbPort() {
        return dbPort;
    }
}
