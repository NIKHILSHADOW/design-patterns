package com.example.factory.abstractfactory.forms.factories;

import com.example.factory.abstractfactory.forms.models.Button;
import com.example.factory.abstractfactory.forms.models.Checkbox;
import com.example.factory.abstractfactory.forms.models.buttonimpl.SecondaryButton;
import com.example.factory.abstractfactory.forms.models.checkboximpl.SecondaryCheckbox;

public class MobileFormFactory implements FormFactory {

    @Override
    public Button createButton() {
        return new SecondaryButton();
    }

    @Override
    public Checkbox createCheckbox() {
        return new SecondaryCheckbox();
    }

}
