package com.example.observer.bitcoinmanager;

import com.example.observer.bitcoinmanager.interfaces.Observable;
import com.example.observer.bitcoinmanager.models.Bitcoin;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class BitcoinManager extends Observable {
    private Bitcoin bitcoin;

    public void setPrice(Double price) {
        if (bitcoin.getPrice().equals(price)) {
            return;
        }
        bitcoin.setPrice(price);
        notifyObservers();
    }
}
