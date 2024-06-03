package com.example.builder.users;

import lombok.Getter;
import lombok.Setter;

@Getter
public class User {

    private String name;

    private String email;

    private String phone;

    private String address;

    private Integer age;

    private User() {
    }

    @Getter
    @Setter
    public static class UserBuilder {
        private String name;

        private String email;

        private String phone;

        private String address;

        private Integer age;

        public User build() {
            User user = new User();
            user.email = email;
            user.address = address;
            user.age = age;
            user.name = name;
            user.phone = phone;

            if (!valid()) {
                throw new RuntimeException("illegal argurment");
            }

            return user;
        }

        public boolean valid() {
            return true;
        }

    }
}
