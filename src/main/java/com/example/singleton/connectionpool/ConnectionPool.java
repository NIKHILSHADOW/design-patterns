package com.example.singleton.connectionpool;

public class ConnectionPool {

    private static ConnectionPool connectionPool = null;

    private ConnectionPool() {

    }

    public static ConnectionPool getInstance() {
        if (connectionPool == null) {
            synchronized (ConnectionPool.class) {
                if (connectionPool == null) {
                    connectionPool = new ConnectionPool();
                }
            }
        }
        return connectionPool;
    }
}
