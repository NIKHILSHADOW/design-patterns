package com.example.observer.bitcoinmanager.models;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Bitcoin {
    private Double price = 89.2;

    private static Bitcoin instance;

    private Bitcoin() {
    }

    public static Bitcoin getInstance() {
        if (instance == null) {
            synchronized (Bitcoin.class) {
                if (instance == null) {
                    instance = new Bitcoin();
                }
            }
        }

        return instance;
    }
}
