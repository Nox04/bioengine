package kim.nox.bioengine.database;

import io.ebean.EbeanServer;
import io.ebean.EbeanServerFactory;
import io.ebean.config.ServerConfig;
import io.ebean.datasource.DataSourceConfig;

import java.sql.Connection;

public class Engine {

    public EbeanServer start() {

        DataSourceConfig dataSourceConfig = new DataSourceConfig();
        dataSourceConfig.setDriver("org.sqlite.JDBC");
        dataSourceConfig.setUrl("jdbc:sqlite:data.db");
        dataSourceConfig.setUsername("");
        dataSourceConfig.setPassword("");
        dataSourceConfig.setIsolationLevel(Connection.TRANSACTION_SERIALIZABLE);

        ServerConfig config = new ServerConfig();
        config.setDdlGenerate(true);
        config.setDdlRun(true);
        config.setDataSourceConfig(dataSourceConfig);

        return EbeanServerFactory.create(config);
    }
}
