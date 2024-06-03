package com.example.prototype.simpleprototype;

import org.junit.Assert;
import org.junit.Test;

import com.example.prototype.simpleprototype.game.Background;
import com.example.prototype.simpleprototype.game.ForeGround;
import com.example.prototype.simpleprototype.game.GraphicalObject;
import com.example.prototype.simpleprototype.game.GraphicalObjectType;

public class GraphicalObjTest {

    @Test
    public void backgroundTest() {

        GraphicalObject backgroundObj = new Background(23, 24, 4, 32);

        Assert.assertNotNull("if constructor called instance shouldn't be null", backgroundObj);
        Assert.assertEquals("height should be as given", Integer.valueOf(32), ((Background) backgroundObj).getHeight());

        GraphicalObject clonedObj = backgroundObj.clone();

        Assert.assertNotNull("if clone method called instance shouldn't be null", clonedObj);
        Assert.assertEquals("type should be backgroundtype", GraphicalObjectType.BACKGROUND,
                ((Background) backgroundObj).getType());

        Assert.assertEquals("height should be as given", Integer.valueOf(32), ((Background) backgroundObj).getHeight());

    }

    @Test
    public void foregroundTest() {

        GraphicalObject foreGroundObj = new ForeGround(23, 24, 4, 32);

        Assert.assertNotNull("if constructor called instance shouldn't be null", foreGroundObj);
        Assert.assertEquals("height should be as given", Integer.valueOf(32), ((ForeGround) foreGroundObj).getHeight());

        GraphicalObject clonedObj = foreGroundObj.clone();

        Assert.assertNotNull("if clone method called instance shouldn't be null", clonedObj);
        Assert.assertEquals("type should be backgroundtype", GraphicalObjectType.FOREGROUND,
                ((ForeGround) foreGroundObj).getType());

        Assert.assertEquals("height should be as given", Integer.valueOf(32), ((ForeGround) foreGroundObj).getHeight());

    }
}
