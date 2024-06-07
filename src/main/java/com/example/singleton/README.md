# SingleTon

- [Home](../../../../../../README.md)

## Contents

- [SingleTon](#singleton)
  - [Contents](#contents)
    - [Solution](#solution)
    - [Improved Solution](#improved-solution)

### Solution

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

```java


public class ConnectionPool {

    private static ConnectionPool connectionPool = null;

    private ConnectionPool() {

    }

    public synchronized static ConnectionPool getInstance() {
        if (connectionPool == null) {
            connectionPool = new ConnectionPool();
        }
        return connectionPool;
    }
}

```

this is thread-safe, but performance wise it's not best, because it never accepts multiple threads inside method even if instance already has value

```java
public class ConnectionPool {

    private static ConnectionPool connectionPool = null;

    private ConnectionPool() {

    }

    public static ConnectionPool getInstance() {
        if (connectionPool == null) {
            synchronized (ConnectionPool.class) {
                connectionPool = new ConnectionPool();
            }
        }
        return connectionPool;
    }
}
```

but this is again not thread safe because if multiple threads hit methods, it checks if they are null, if yes it will send one by one inside each will get a new instance. so we introduce double check locking.

### Improved Solution

```java
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


```

this is one of the better methods performance wise and thread safe.
