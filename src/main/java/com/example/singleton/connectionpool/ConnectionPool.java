package com.example.singleton.connectionpool;

public class ConnectionPool {

    private static ConnectionPool connectionPool = new ConnectionPool();

    private ConnectionPool() {

    }

    public static ConnectionPool getInstance() {
        return connectionPool;
    }
}
