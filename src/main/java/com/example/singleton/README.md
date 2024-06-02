# SingleTon

- Class should have Only one instance.
- Shared resources are the ones which mostly uses singleton class.

```java

// Solution 1.
public class ConnectionPool {

    private static ConnectionPool connectionPool = new ConnectionPool();

    private ConnectionPool() {

    }

    public static ConnectionPool getInstance() {
        return connectionPool;
    }
}

```

But the above one is eager initialisation.

```java

public class ConnectionPool {

    private static ConnectionPool connectionPool = null;

    private ConnectionPool() {

    }

    public static ConnectionPool getInstance() {
        if (connectionPool == null) {
            connectionPool = new ConnectionPool();
        }
        return connectionPool;
    }
}
```

But this is not thread safe.
