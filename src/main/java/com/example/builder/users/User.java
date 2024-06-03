package com.example.builder.users;

import lombok.Getter;

@Getter
public class User {

    private String name;

    private String email;

    private String phone;

    private String address;

    private Integer age;

    private User() {
    }

    public static UserBuilder builder() {
        return new UserBuilder();
    }

    @Getter
    public static class UserBuilder {
        private String name;

        private String email;

        private String phone;

        private String address;

        private Integer age;

        public UserBuilder name(String name) {
            this.name = name;
            return this;
        }

        public UserBuilder email(String email) {
            this.email = email;
            return this;
        }

        public UserBuilder phone(String phone) {
            this.phone = phone;
            return this;
        }

        public UserBuilder address(String address) {
            this.address = address;
            return this;
        }

        public UserBuilder age(Integer age) {
            this.age = age;
            return this;
        }

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
