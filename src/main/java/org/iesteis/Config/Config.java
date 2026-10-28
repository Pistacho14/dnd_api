package org.iesteis.Config;

import java.io.InputStream;
import java.util.Properties;

public class Config {
    private static String databaseUrl = "jdbc:mysql:dndDatabase.db";
    private static boolean databaseInitTables = true;
    private static boolean databaseInitData = true;
    private static String storageData = "data";
    private static String databaseUser = "root";
    private static String databasePassword = "root";

    static {
        System.out.println("Cargando configuración");
        try {
        Properties properties = new Properties();
        InputStream input = ClassLoader.getSystemResourceAsStream("config.properties");

        if(input != null) {
            properties.load(input);
            databaseUrl = properties.getProperty("databaseUrl", databaseUrl);
            databaseInitTables = Boolean.parseBoolean(properties.getProperty("database.init.tables", String.valueOf(databaseInitTables)));
            databaseInitData = Boolean.parseBoolean(properties.getProperty("database.init.data", String.valueOf(databaseInitData)));
            storageData = properties.getProperty("storage.data", storageData);
            databaseUser = properties.getProperty("database.user", databaseUser);
            databasePassword = properties.getProperty("database.password", databasePassword);
        }
        else {
            System.out.println("Archivo de configuración 'config.properties' no encontrado");
        }
    } catch(Exception e) {
        e.printStackTrace();
        }
    }

}
