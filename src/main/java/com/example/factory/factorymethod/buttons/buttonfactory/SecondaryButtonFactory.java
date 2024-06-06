package com.example.factory.factorymethod.buttons.buttonfactory;

import com.example.factory.factorymethod.buttons.Button;
import com.example.factory.factorymethod.buttons.SecondaryButton;

public class SecondaryButtonFactory implements ButtonFactory {

    @Override
    public Button createButton() {
        return new SecondaryButton();
    }

}
