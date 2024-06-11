# DECORATOR

## Contents

### Introduction

It says **Attach additional responsibilities to an object dynamically. Decorators
provide a flexible alternative to subclassing for extending functionality.**

Suppose if we need multiple responsibilities at a time, depending on requirement, then we shouldn't tie behaviour to hierarchy.

### STEPS

1. create base interface
2. implement concrete classes of base interface
3. create abstract decorator class extending base class and also having base class instance
4. implement decorator classes

### CODE

```java
// step 1. create base interface

public interface Database {

    public void write(String input);

    public String read();
}

// step 2. create concrete classes of base interface

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


//step 3. create base decorator abstract class implementing base class and having instance of base class


@AllArgsConstructor
public abstract class BaseDecorator implements Database {

    protected Database database;
}


// step 4. create concrete decorator classes.


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

```
