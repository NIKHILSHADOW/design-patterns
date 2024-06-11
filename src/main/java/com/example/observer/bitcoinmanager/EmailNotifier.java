package com.example.observer.bitcoinmanager;

import com.example.observer.bitcoinmanager.interfaces.Observer;

public class EmailNotifier implements Observer {

    @Override
    public void notifyChange() {
        System.out.println("sending Email...!");
    }

}
