package kim.nox.bioengine.database;

import io.ebean.EbeanServer;
import io.ebean.EbeanServerFactory;
import io.ebean.config.ServerConfig;
import io.ebean.datasource.DataSourceConfig;

import java.sql.Connection;

public class Engine {

  /**
   * Start database engine.
   * @return EbeanServer created.
   */
  public EbeanServer start() {
    DataSourceConfig dataSourceConfig = new DataSourceConfig();
    dataSourceConfig.setDriver("org.sqlite.JDBC");
    dataSourceConfig.setUrl("jdbc:sqlite:data.db");
    dataSourceConfig.setUsername("");
    dataSourceConfig.setPassword("");
    dataSourceConfig.setIsolationLevel(Connection.TRANSACTION_SERIALIZABLE);

    ServerConfig config = new ServerConfig();
    config.setDefaultServer(true);
    config.setDataSourceConfig(dataSourceConfig);
    config.addPackage("kim.nox.bioengine.models");

    return EbeanServerFactory.create(config);
  }
}
