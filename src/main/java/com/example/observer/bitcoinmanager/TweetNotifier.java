package com.example.observer.bitcoinmanager;

import com.example.observer.bitcoinmanager.interfaces.Observer;

public class TweetNotifier implements Observer {

    @Override
    public void notifyChange() {
        System.out.println("Sending tweet...!");
    }

}
