package com.example.builder.users;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class UserDto {

    private String name;

    private String email;

    private String phone;

    private String address;

    private Integer age;

    public User build() {
        // User user = new User(null, null, null, null, null);
        return null;
    }

}
