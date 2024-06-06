package com.example.factory.factorymethod.buttons.buttonfactory;

import com.example.factory.factorymethod.buttons.PrimaryButton;

public class PrimaryButtonFactory implements ButtonFactory {

    @Override
    public PrimaryButton createButton() {
        return new PrimaryButton();
    }

}
