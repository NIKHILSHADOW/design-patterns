package com.example.strategy.navigation;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class NavigateTest {

    private Navigator navigator;

    @Before
    public void setUp() {
        navigator = new Navigator(new CarNavigationStrategy());
    }

    @Test
    public void testNavigate() {
        Assert.assertNotNull("instance shouldn't be null if obj created", navigator);

        Assert.assertTrue("It should be car navigation strategy",
                navigator.getNavigationStrategy() instanceof CarNavigationStrategy);

        navigator.navigate("bangalore", "chennai");

        navigator.setNavigationStrategy(new BikeNavigationStrategy());

        Assert.assertTrue("It should be bike navigation strategy",
                navigator.getNavigationStrategy() instanceof BikeNavigationStrategy);

        navigator.navigate("chennai", "bangalore");

    }
}
