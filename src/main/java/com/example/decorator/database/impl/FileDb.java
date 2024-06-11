package com.example.decorator.database.impl;

import com.example.decorator.database.Database;

public class FileDb implements Database {

    @Override
    public void write(String input) {
        System.out.println("write " + input);
    }

    @Override
    public String read() {
        return "file value ";
    }

}
