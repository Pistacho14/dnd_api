package org.iesteis.database;

import java.util.List;
import java.util.Map;

public interface DatabaseManager {
    List<Map<String, Object>> select(String query, Object... params);
    // Devuelve los nombres de las tablas disponibles en la base de datos.
    List<String> listTables();
    // Devuelve los nombres de las columnas de una tabla concreta.
    List<String> listTableColumns(String tableName);
    int insert(String query, Object... params);
    Object insertAndGetId(String query, Object... params);
    int update(String query, Object... params);
    int delete(String query, Object... params);
}