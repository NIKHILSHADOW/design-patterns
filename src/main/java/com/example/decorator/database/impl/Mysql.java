package com.example.decorator.database.impl;

import com.example.decorator.database.Database;

public class Mysql implements Database {

    @Override
    public void write(String input) {
        System.out.println("write");
    }

    @Override
    public String read() {
        return "Mysql value ";
    }

}
