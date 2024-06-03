package com.example.builder.users;

import org.junit.Assert;
import org.junit.Test;

import com.example.builder.users.User.UserBuilder;

public class UserTest {

    @Test
    public void UserInstanceTest() {
        UserBuilder userBuilder = new UserBuilder();

        Assert.assertNotNull(userBuilder);

        userBuilder.setName("ivan");
        userBuilder.setAge(23);

        User user = userBuilder.build();
        Assert.assertNotNull(user);

        Assert.assertEquals("ivan", user.getName());

    }
}
