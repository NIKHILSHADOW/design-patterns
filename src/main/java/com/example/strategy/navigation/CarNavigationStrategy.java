package com.example.strategy.navigation;

public class CarNavigationStrategy implements NavigationStrategy {

    @Override
    public void navigate(String from, String to) {

        System.out.println("travelling by car from " + from + " to " + to);
    }

}
