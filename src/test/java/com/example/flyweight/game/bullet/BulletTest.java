package com.example.flyweight.game.bullet;

import org.junit.Assert;
import org.junit.Test;

import com.example.flyweight.game.bullets.Bullet;
import com.example.flyweight.game.bullets.BulletType;
import com.example.flyweight.game.bullets.FlyingBullet;

public class BulletTest {

    @Test
    public void testFlyweight() {
        Bullet bullet = new Bullet(BulletType.BULLET_45MM, 23.3, "red", new Byte[100]);
        Assert.assertNotNull(bullet);

        FlyingBullet flyingBullet = FlyingBullet
                .builder()
                .bullet(bullet)
                .x(23.2)
                .y(34.2)
                .z(34.2)
                .velocity(34.2)
                .build();
        Assert.assertNotNull(flyingBullet);
        FlyingBullet flyingBullet2 = FlyingBullet
                .builder()
                .bullet(bullet)
                .x(477.2)
                .y(33.2)
                .z(3.2)
                .velocity(3.2)
                .build();
        Assert.assertNotNull(flyingBullet2);

        Assert.assertEquals(flyingBullet.getBullet(), flyingBullet2.getBullet());

    }
}
