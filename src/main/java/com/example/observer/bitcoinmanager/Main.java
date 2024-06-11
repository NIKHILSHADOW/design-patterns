package com.example.observer.bitcoinmanager;

import com.example.observer.bitcoinmanager.models.Bitcoin;

public class Main {
    public static void main(String[] args) {
        BitcoinManager bitcoinManager = new BitcoinManager(Bitcoin.getInstance());

        bitcoinManager.addObserver(new EmailNotifier());
        bitcoinManager.addObserver(new TweetNotifier());

        bitcoinManager.setPrice(23.9);

        bitcoinManager.setPrice(23.9);

    }
}
