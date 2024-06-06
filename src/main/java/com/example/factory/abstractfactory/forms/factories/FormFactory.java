package com.example.factory.abstractfactory.forms.factories;

import com.example.factory.abstractfactory.forms.models.Button;
import com.example.factory.abstractfactory.forms.models.Checkbox;

public interface FormFactory {

    public Button createButton();

    public Checkbox createCheckbox();

}
