package com.example.prototype.prototyperegistry.game;

import org.junit.Assert;
import org.junit.Test;

public class GameTest {

    private GraphicalRegistry graphicalRegistry = new GraphicalRegistry();

    @Test
    public void instanceTest() {
        Background background = new Background(23, 34, 34, 23, GraphicalObjType.BACKGROUND);

        Assert.assertNotNull(background);

        graphicalRegistry.addObject(background.getGraphicalObjType(), background);

        Background backgroundClone = (Background) graphicalRegistry.getObject(GraphicalObjType.BACKGROUND).clone();

        Assert.assertEquals(background.getHeight(), backgroundClone.getHeight());

    }
}
