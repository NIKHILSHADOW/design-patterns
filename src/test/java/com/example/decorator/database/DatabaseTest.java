package com.example.decorator.database;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.example.decorator.database.decorators.BaseDecorator;
import com.example.decorator.database.decorators.impl.Compressor;
import com.example.decorator.database.decorators.impl.Encrypter;
import com.example.decorator.database.impl.FileDb;
import com.example.decorator.database.impl.Mysql;

public class DatabaseTest {

    Database mySqlDb, fileDb;
    BaseDecorator compressor, encrypter;

    @Before
    public void setUp() {
        mySqlDb = new Mysql();
        fileDb = new FileDb();
    }

    @Test
    public void testDatabase() {

        Assert.assertNotNull("instance shouldn't be null if object is created", mySqlDb);

        Assert.assertEquals("Value should be as expected", "Mysql value ", mySqlDb.read());

    }

    @Test
    public void testCompressor() {
        compressor = new Compressor(mySqlDb);
        Assert.assertNotNull("instance shouldn't be null after object creation", compressor);

        Assert.assertEquals("value should be as expected", "Mysql value  -decompress", compressor.read());
    }

    @Test
    public void testEncrypted() {
        encrypter = new Encrypter(mySqlDb);
        Assert.assertNotNull("instance shouldn't be null after object creation", encrypter);

        Assert.assertEquals("value should be as expected", "Mysql value  -decrypted", encrypter.read());
    }

    @Test
    public void testCompressedEncrypted() {
        compressor = new Compressor(mySqlDb);
        Assert.assertNotNull("instance shouldn't be null after object creation", compressor);

        encrypter = new Encrypter(compressor);
        Assert.assertNotNull("instance shouldn't be null after object creation", encrypter);

        Assert.assertEquals("value should be as expected", "Mysql value  -decompress -decrypted", encrypter.read());

    }
}
