package com.example.decorator.database.decorators.impl;

import com.example.decorator.database.Database;
import com.example.decorator.database.decorators.BaseDecorator;

public class Encrypter extends BaseDecorator {

    public Encrypter(Database database) {
        super(database);
    }

    @Override
    public void write(String input) {
        String encrypted = input + " encrypted ";
        System.out.println(encrypted);
    }

    @Override
    public String read() {
        return database.read() + " -decrypted";
    }

}
