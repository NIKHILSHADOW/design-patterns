package com.example.factory.abstractfactory;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.example.factory.abstractfactory.forms.factories.FormFactory;
import com.example.factory.abstractfactory.forms.factories.MobileFormFactory;
import com.example.factory.abstractfactory.forms.factories.WebformFactory;
import com.example.factory.abstractfactory.forms.models.Button;
import com.example.factory.abstractfactory.forms.models.Checkbox;
import com.example.factory.abstractfactory.forms.models.buttonimpl.PrimaryButton;
import com.example.factory.abstractfactory.forms.models.buttonimpl.SecondaryButton;
import com.example.factory.abstractfactory.forms.models.checkboximpl.PrimaryCheckbox;
import com.example.factory.abstractfactory.forms.models.checkboximpl.SecondaryCheckbox;

public class FormFactoryTest {

    private FormFactory webFormFactory;
    private FormFactory mobileFormFactory;

    @Before
    public void setUp() {
        webFormFactory = new WebformFactory();
        mobileFormFactory = new MobileFormFactory();
    }

    @Test
    public void webFormTest() {
        Assert.assertNotNull("when instance created it should n't be null", webFormFactory);

        Button button = webFormFactory.createButton();
        Assert.assertNotNull("it should n't be null if createbutton is called", button);
        Assert.assertTrue("it should be instance of primary button ", button instanceof PrimaryButton);

        Checkbox checkbox = webFormFactory.createCheckbox();
        Assert.assertNotNull("it should n't be null if createcheckbox is called", checkbox);
        Assert.assertTrue("it should be instance of primary checkbox ", checkbox instanceof PrimaryCheckbox);

    }

    @Test
    public void mobileFormTest() {
        Assert.assertNotNull("when instance created it should n't be null", mobileFormFactory);

        Button button = mobileFormFactory.createButton();
        Assert.assertNotNull("it should n't be null if createbutton is called", button);
        Assert.assertTrue("it should be instance of secondary button ", button instanceof SecondaryButton);

        Checkbox checkbox = mobileFormFactory.createCheckbox();
        Assert.assertNotNull("it should n't be null if createcheckbox is called", checkbox);
        Assert.assertTrue("it should be instance of secondary checkbox ", checkbox instanceof SecondaryCheckbox);

    }

}
