package com.example.strategy.navigation;

public class BikeNavigationStrategy implements NavigationStrategy {

    @Override
    public void navigate(String from, String to) {

        System.out.println("travelling by bike from " + from + " to " + to);
    }

}
