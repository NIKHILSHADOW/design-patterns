package com.example.builder.users;

import org.junit.Assert;
import org.junit.Test;

public class UserTest {

    @Test
    public void UserInstanceTest() {

        User user = User
                .builder()
                .address("kkd")
                .name("ivan")
                .age(23)
                .build();

        Assert.assertNotNull(user);

        Assert.assertEquals("ivan", user.getName());

    }
}
