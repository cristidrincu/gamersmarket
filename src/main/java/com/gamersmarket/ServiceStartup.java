package com.gamersmarket;
import com.fasterxml.jackson.databind.Module;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.flywaydb.core.Flyway;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.enterprise.inject.spi.Extension;
import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

@Startup
@Singleton
public class ServiceStartup implements Extension {

    private Logger logger = Logger.getLogger(ServiceStartup.class.getName());

    @Resource(lookup = "jdbc/gamers-market")
    private DataSource dataSource;

    @PostConstruct
    public void postConstruct() {
        InputStream inputStream = null;

        try {
            inputStream = readFlywayProperties();
        } catch (IOException ex) {
            logger.severe(ex.getMessage());
        } finally {
            if (inputStream != null) {
                Properties props = new Properties();
                try {
                    props.load(inputStream);
                } catch (IOException ex) {
                    ex.getMessage();
                } finally {
                    String user = props.getProperty("flyway.user");
                    String password = props.getProperty("flyway.password");
                    String migrationsLocation = props.getProperty("flyway.locations");
                    String flywaySchemas = props.getProperty("flyway.schema");
                    migrate(user, password, migrationsLocation, flywaySchemas);
                    getObjectMapperModules();
                    try {
                        inputStream.close();
                    } catch (IOException ex) {
                        logger.log(Level.SEVERE, "Could not close input stream... Reason: {0}", ex.getMessage());
                    }
                }
            }
        }
    }

    private void getObjectMapperModules() {
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        List<Module> modules = ObjectMapper.findModules(classLoader);
        modules.forEach((module) -> {            
            logger.log(Level.INFO, module.getModuleName());
        });
    }

    private InputStream readFlywayProperties() throws IOException {
        InputStream flywayProperties;
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();

        flywayProperties = classLoader.getResourceAsStream("db/flyway.properties");

        if (flywayProperties == null) {
            logger.log(Level.SEVERE, "Could not read flyway properties file. File not present at specified location or is empty.");
            throw new IOException("Could not read flyway properties file. File not present at specified location or is empty.");
        }

        return flywayProperties;
    }

    private void migrate(String user, String password, String migrationsLocations, String schema) {
        logger.info("Migration started");
        final Flyway flyway = createFlywayInstance();
        flyway.setDataSource(dataSource);
        flyway.setSchemas(schema);
        flyway.setLocations(migrationsLocations);
        flyway.getPlaceholders().put("connection.user", user);
        flyway.getPlaceholders().put("connection.password", password);
        flyway.setInitOnMigrate(true);
        flyway.migrate();
        logger.info("Migration finished");
    }

    private Flyway createFlywayInstance() {
        return new Flyway();
    }
}
