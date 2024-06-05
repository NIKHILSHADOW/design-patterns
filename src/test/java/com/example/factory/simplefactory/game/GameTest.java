package com.example.factory.simplefactory.game;

import org.junit.Assert;
import org.junit.Test;

public class GameTest {

    @Test
    public void foreGroundInstanceTest() {
        GameObject gameObject = GameFactory.getInstance(GameType.FOREGROUND);

        Assert.assertNotNull("If we call gamefactory method instance should be created", gameObject);
        Assert.assertTrue("instance should be of foreground", gameObject instanceof ForeGroundObj);
    }

    @Test
    public void backGroundInstanceTest() {
        GameObject backGroundObject = GameFactory.getInstance(GameType.BACKGROUND);

        Assert.assertNotNull("instance should be created if gmfactory method is called", backGroundObject);
        Assert.assertTrue("instnace should be of background", backGroundObject instanceof BackGroundObj);
    }
}
