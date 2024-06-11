package com.example.decorator.database.decorators;

import com.example.decorator.database.Database;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public abstract class BaseDecorator implements Database {

    protected Database database;
}
