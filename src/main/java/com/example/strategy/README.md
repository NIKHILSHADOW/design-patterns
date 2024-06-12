# STRATEGY

[Home](../../../../../../README.md)

## Contents

- [STRATEGY](#strategy)
  - [Contents](#contents)
    - [Introduction](#introduction)
    - [Steps](#steps)
    - [Code](#code)

### Introduction

It says
**Define a family of algorithms, encapsulate each one, and make them interchangeable. Strategy lets the algorithm vary independently from clients that
use it**

Suppose if we want to go from A to B,
Then we can go by walk, bus, train, car bike, plane.

suppose we want to go bus station by bike, and to C by bus and take car taxi from C to D, and then take bike taxi D to E, and walk from E to A.

Here wanna change our means of travel at runtime.

Here we use strategy to solve problem.

### Steps

1. create strategy interface
2. create concrete strategy classes
3. create functional class

### Code

```java

// Step 1. create strategy interface

public interface NavigationStrategy {

    public void navigate(String from, String to);
}

// Step 2. create concrete strategies implementing strategy interface


public class BikeNavigationStrategy implements NavigationStrategy {

    @Override
    public void navigate(String from, String to) {

        System.out.println("travelling by bike from " + from + " to " + to);
    }

}


// Step 3. create functional class with strategy as dependency


@AllArgsConstructor
@Setter
@Getter
public class Navigator {
    NavigationStrategy navigationStrategy;

    public void navigate(String from, String to) {
        navigationStrategy.navigate(from, to);
    }

}


```
