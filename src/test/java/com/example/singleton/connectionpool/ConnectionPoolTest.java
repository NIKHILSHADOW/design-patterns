package com.example.singleton.connectionpool;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

public class ConnectionPoolTest {

    protected class MyThread extends Thread {
        public ConnectionPool connectionPool;

        @Override
        public void run() {
            connectionPool = ConnectionPool.getInstance();
        }
    }

    @Test
    public void instanceCreationTest() {
        ConnectionPool connectionPool = ConnectionPool.getInstance();

        assertNotNull("instance shouldn't be null", connectionPool);

        ConnectionPool connectionPool2 = ConnectionPool.getInstance();

        assertNotNull("instance shouldn't be null", connectionPool2);

        assertEquals("As ConnectionPool is a singleton class instance should be equal", connectionPool,
                connectionPool2);
    }

    @Test
    public void instanceCreationTestMultipleThreads() {
        MyThread[] myThreads = new MyThread[20];

        for (int i = 0; i < 20; i++) {
            myThreads[i] = new MyThread();
            myThreads[i].start();
        }

        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        for (int i = 0; i < 20; i++) {
            Assert.assertEquals(myThreads[0].connectionPool, myThreads[i].connectionPool);
        }

    }
}
