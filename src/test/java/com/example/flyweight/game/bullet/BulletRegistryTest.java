package com.example.flyweight.game.bullet;

import org.junit.Assert;
import org.junit.Test;

import com.example.flyweight.Registry;
import com.example.flyweight.game.bullets.Bullet;
import com.example.flyweight.game.bullets.BulletType;
import com.example.flyweight.game.bullets.FlyingBullet;

public class BulletRegistryTest {

    Registry<BulletType, Bullet> registry = new Registry<>();

    @Test
    public void testBullet() {
        Bullet bullet = new Bullet(BulletType.BULLET_45MM, 23.0, "red", new Byte[23]);

        Assert.assertNotNull("instance shouldn't be null if object is created", bullet);

        Assert.assertTrue("Object should be of bullet", bullet instanceof Bullet);
        Assert.assertTrue("Bullet type is 45mm", bullet.getBulletType() == BulletType.BULLET_45MM);

        registry.addIfNotPresent(bullet.getBulletType(), bullet);

        FlyingBullet flyingBullet = FlyingBullet
                .builder()
                .velocity(23.3)
                .x(23.09)
                .y(34.8)
                .z(56.4)
                .bullet(bullet)
                .build();

        Assert.assertTrue("Object should be of bullet", bullet instanceof Bullet);

        Bullet bullet2 = registry.get(BulletType.BULLET_45MM);
        Assert.assertTrue("Bullet type is 45mm", bullet2.getBulletType() == BulletType.BULLET_45MM);

        FlyingBullet flyingBullet2 = FlyingBullet
                .builder()
                .velocity(23.3)
                .x(23.32)
                .bullet(bullet2)
                .build();

        Assert.assertNotNull("instance shouldn't be null if object is created", flyingBullet2);

        Assert.assertTrue("Bullet's should be same if same type",
                flyingBullet2.getBullet() == flyingBullet.getBullet());

    }
}
