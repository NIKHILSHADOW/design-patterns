# FLYWEIGHT

- [Home](../../../../../../README.md)

## Contents

- [FLYWEIGHT](#flyweight)
  - [Contents](#contents)
    - [Introduction](#introduction)
    - [Steps](#steps)
    - [Code](#code)

### Introduction

This design pattern mostly concentrates on scalability.

Consider there is bullet in a game, we use bullets very frequently, which we use in multiple classes, if we try to create instances, huge memory is required, to solve this we divide class in to two parts

1. Intrinsic (doesn't change)
2. Extrinsic (changes)

### Steps

- Step 1 - create a class with states which doesn't with instances (Ex. If we consider multiple bullets of same type their weight, color, image will be same)

- Step 2 - create a class with states which changes

- Step 3 - Use reference of intrinsic class in extrinsic class.

### Code

```java
// step -1 create intrinsic class
@Getter
@AllArgsConstructor
public class Bullet {
    private BulletType bulletType;
    private Double weight;
    private String color;
    private Byte[] image;
}

// step 2 - create extrinsic class
// step 3 - use intrinsic instance reference in extrinsic class

@Getter
@Builder
public class FlyingBullet {
    private Double x;
    private Double y;
    private Double z;
    private Double velocity;

    private Bullet bullet;
}


```
