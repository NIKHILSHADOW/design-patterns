package com.example.flyweight.game.bullets;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Bullet {
    private BulletType bulletType;
    private Double weight;
    private String color;
    private Byte[] image;
}
