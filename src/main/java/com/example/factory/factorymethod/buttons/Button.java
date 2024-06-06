package com.example.factory.factorymethod.buttons;

public abstract class Button {

    private ButtonType buttonType;

    public Button(ButtonType buttonType) {
        this.buttonType = buttonType;
    }

}