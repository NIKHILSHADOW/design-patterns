package com.example.decorator.database.decorators.impl;

import com.example.decorator.database.Database;
import com.example.decorator.database.decorators.BaseDecorator;

public class Compressor extends BaseDecorator {

    public Compressor(Database database) {
        super(database);
    }

    @Override
    public void write(String input) {
        String compressed = input + " compressed";
        System.out.println(compressed);
    }

    @Override
    public String read() {
        return database.read() + " -decompress";
    }

}
