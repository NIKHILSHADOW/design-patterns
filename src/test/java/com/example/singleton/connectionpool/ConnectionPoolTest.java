package com.example.singleton.connectionpool;

import static org.junit.Assert.*;

import org.junit.Test;

public class ConnectionPoolTest {

    @Test
    public void instanceCreationTest() {
        ConnectionPool connectionPool = ConnectionPool.getInstance();

        assertNotNull("instance shouldn't be null", connectionPool);

        ConnectionPool connectionPool2 = ConnectionPool.getInstance();

        assertNotNull("instance shouldn't be null", connectionPool2);

        assertEquals("As ConnectionPool is a singleton class instance should be equal", connectionPool,
                connectionPool2);
    }
}
