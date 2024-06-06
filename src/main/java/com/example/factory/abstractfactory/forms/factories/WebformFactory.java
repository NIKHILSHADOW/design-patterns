package com.example.factory.abstractfactory.forms.factories;

import com.example.factory.abstractfactory.forms.models.Button;
import com.example.factory.abstractfactory.forms.models.Checkbox;
import com.example.factory.abstractfactory.forms.models.buttonimpl.PrimaryButton;
import com.example.factory.abstractfactory.forms.models.checkboximpl.PrimaryCheckbox;

public class WebformFactory implements FormFactory {

    @Override
    public Button createButton() {
        return new PrimaryButton();
    }

    @Override
    public Checkbox createCheckbox() {
        return new PrimaryCheckbox();
    }

}
