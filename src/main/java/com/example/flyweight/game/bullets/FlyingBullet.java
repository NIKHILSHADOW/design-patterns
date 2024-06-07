package com.example.flyweight.game.bullets;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class FlyingBullet {
    private Double x;
    private Double y;
    private Double z;
    private Double velocity;

    private Bullet bullet;
}
