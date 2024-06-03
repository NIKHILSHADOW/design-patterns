package com.example.builder.database;

import org.junit.Assert;
import org.junit.Test;

import com.example.builder.database.Database.DatabaseBuilder;

public class DatabaseTest {

    @Test
    public void testBuilderInstance() {
        DatabaseBuilder databaseBuilder = Database.builder();
        Assert.assertNotNull(databaseBuilder);

    }

    @Test
    public void mySqlObjectTest() {

        Database database = Database
                .builder()
                .mySql()
                .name("users")
                .host("host")
                .password("pass")
                .port(122)
                .build();

        Assert.assertNotNull("when build called instance should not be null", database);
        Assert.assertEquals("after instance creation databasetype should be given one", DatabaseType.MYSQL,
                database.getDatabaseType());
        Assert.assertEquals("after instance creation name should be given", "users",
                database.getName());
        Assert.assertEquals("after instance creation host should be expected", "host",
                database.getHost());
        Assert.assertEquals("after instance creation port should be expected", Integer.valueOf(122),
                database.getPort());

        Assert.assertEquals("after instance creation password should be expected", "pass",
                database.getPassword());
    }

    @Test
    public void mongoObjectTest() {

        Database database = Database
                .builder()
                .mongo()
                .name("users")
                .host("host")
                .password("pass")
                .port(122)
                .build();

        Assert.assertNotNull("when build called instance should not be null", database);
        Assert.assertEquals("after instance creation databasetype should be given one", DatabaseType.MONGO,
                database.getDatabaseType());
        Assert.assertEquals("after instance creation name should be given", "users",
                database.getName());
        Assert.assertEquals("after instance creation host should be expected", "host",
                database.getHost());
        Assert.assertEquals("after instance creation port should be expected", Integer.valueOf(122),
                database.getPort());

        Assert.assertEquals("after instance creation password should be expected", "pass",
                database.getPassword());
    }
}
