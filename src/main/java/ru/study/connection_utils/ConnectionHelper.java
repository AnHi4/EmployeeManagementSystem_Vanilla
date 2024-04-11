package ru.study.connection_utils;

import ru.study.model.DBConfigs;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionHelper {
    private static Connection connection;

    public static Connection createConnection() throws SQLException {
        if (connection != null && !connection.isClosed()){
            return connection;
        }

        return connection = DriverManager.getConnection(DBConfigs.CONN_URL, DBConfigs.DB_USER, DBConfigs.DB_PASS);
    }
}
