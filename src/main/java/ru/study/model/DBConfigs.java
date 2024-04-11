package ru.study.model;

public class DBConfigs {
    public static final String DB_NAME = "Employee_db";
    public static final String DB_HOST = "localhost";
    public static final String DB_PORT = "3306";
    public static final String DB_USER = "admin";
    public static final String DB_PASS = "mysql";
    public static final String CONN_URL = String.format(
            "jdbc:mysql://%s:%s/%s?serverTimezone=UTC", DB_HOST, DB_PORT, DB_NAME);
}
