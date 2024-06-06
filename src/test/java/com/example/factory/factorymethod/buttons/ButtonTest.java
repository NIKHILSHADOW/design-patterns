package com.example.factory.factorymethod.buttons;

import org.junit.Assert;
import org.junit.Test;

import com.example.factory.factorymethod.buttons.buttonfactory.ButtonFactory;
import com.example.factory.factorymethod.buttons.buttonfactory.PrimaryButtonFactory;
import com.example.factory.factorymethod.buttons.buttonfactory.SecondaryButtonFactory;

public class ButtonTest {

    @Test
    public void primaryButtonTest() {

        ButtonFactory buttonFactory = new PrimaryButtonFactory();
        Assert.assertNotNull("Primary Button factory should be created", buttonFactory);

        Assert.assertTrue("Primary Button factory should be created if constr called",
                buttonFactory instanceof PrimaryButtonFactory);

        Button button = buttonFactory.createButton();

        Assert.assertNotNull("when called createbutton method of button, instance should be created", button);
        Assert.assertTrue("instance should be of primary button", button instanceof PrimaryButton);

    }

    @Test
    public void secondaryButtonTest() {

        ButtonFactory buttonFactory = new SecondaryButtonFactory();
        Assert.assertNotNull("Button factory should be created ", buttonFactory);
        Assert.assertTrue("Secondary Button factory should be created if constr called",
                buttonFactory instanceof SecondaryButtonFactory);

        Button button = buttonFactory.createButton();

        Assert.assertNotNull("when called createbutton method of button instance should be created", button);
        Assert.assertTrue("instance should be of secondary button", button instanceof SecondaryButton);

    }
}
