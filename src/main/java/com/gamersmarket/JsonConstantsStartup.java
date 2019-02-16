package com.gamersmarket;

import com.gamersmarket.constants.GraphicsCardJsonKeys;

import javax.annotation.PostConstruct;
import javax.ejb.DependsOn;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.inject.Inject;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

@DependsOn("ServiceStartup")
@Startup
@Singleton
public class JsonConstantsStartup {

    private Logger logger = Logger.getLogger(ServiceStartup.class.getName());

    @Inject
    GraphicsCardJsonKeys graphicsCardJsonKeys;

    @PostConstruct
    public void initialize() {
        InputStream inputStream = null;

        try {
            inputStream = readGraphicsCardJsonConstants();
        } catch (IOException e) {
            logger.severe(e.getMessage());
        } finally {
            if (inputStream != null) {
                Properties props = new Properties();
                try {
                    props.load(inputStream);
                } catch (IOException e) {
                    logger.severe(e.getMessage());
                } finally {
                    logger.info("Read json properties for graphics card successfully.");
                    graphicsCardJsonKeys.buildGraphicsCardJsonKeys(props);
                    try {
                        inputStream.close();
                    } catch (IOException e) {
                        logger.severe("Could not close input stream... Reason: " + e.getMessage());
                    }
                }
            }
        }
    }

    private InputStream readGraphicsCardJsonConstants() throws IOException {
        InputStream graphicsCardJsonConstants;
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        graphicsCardJsonConstants = classLoader.getResourceAsStream("json_keys.properties");

        if (graphicsCardJsonConstants == null) {
            logger.log(Level.SEVERE, "Could not read graphics card properties file. File not present at specified location or is empty.");
            throw new IOException("Could not read graphics card properties file. File not present at specified location or is empty.");
        }

        return graphicsCardJsonConstants;
    }
}
