## BUILDER

Why Buidler pattern.

1. Immutable class
2. Field validation before instance creation.
3. Easy Object creation

For field validation before instance creation, we need to hide constructor, and create constructor with fields. And also we need to make class immutable by making the private and also not having setter methods.

```java

import lombok.Getter;

@Getter
public class User {

    private String name;
    private String email;

    private String phone;

    private Integer age;

    private String address;

    public User(String name, String email, String phone, Integer age, String address) {
        this.address = address;
        this.age = age;
        this.name = name;
        this.email = email;
        this.phone = phone;

        if(!validate())
        {
            throw new RuntimeException("field is wrong!!");
        }
    }

}
```

- This is one of the solutions for making class immutable and validate fields.
- But what if we are not interested to create instance with all fields, then we need to pass null, which results in too many null fields.
- Also it is prone to error (suppose we pass User("93929929", "eiiw@jjs.okd") to User(email, phone)), this never shows wrong as both fields are of same type.

So we create multiple constructors

```java

import lombok.Getter;

@Getter
public class User {

    private String name;
    private String email;

    private String phone;

    private Integer age;

    private String address;

    public User(String name, String email, String phone, Integer age, String address) {
        this.address = address;
        this.age = age;
        this.name = name;
        this.email = email;
        this.phone = phone;
    }

    public User(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public User(String name, String email, String phone) {
        this.name = name;
        this.email = email;
        this.phone = phone;
    }

}

```

But how many constructors do we need to create? possible many permutations.

This is also known as telescopic constructor anti pattern, which grows big.

So let's try with map

```java
import java.util.Map;

import lombok.Getter;

@Getter
public class User {

    private String name;

    private String email;

    private String phone;

    private String address;

    private Integer age;

    public User(Map<String, Object> hm) {
        this.age = (Integer) hm.get("name");
        this.address = (String) hm.get("address");
        this.email = (String) hm.get("email");
        this.phone = (String) hm.get("phone");
        this.name = (String) hm.get("name");
    }
}

```

This is good

- But what about type conversions what if we pass hm.set("name", 23) or hm.set("age", "djj")
- what about wrong key name like hm.set("nme", "skisl"), as there is no "nme" field.

So, we comeup with similar one to hashmap is class

```java
// User.java
import lombok.Getter;

@Getter
public class User {

    private String name;

    private String email;

    private String phone;

    private String address;

    private Integer age;

    private User(String name, String phone, String email, String address, Integer age) {

    }
}


// USerDto.java
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

    public User build(){
        User user = new User(null, null, null, null, null);
        return user;
    }

}
```

Here again we are dependent on constructor.

- Here it is clearly violating the Open/Close Design principle.
  `what if we want to chanage field name, we need to open other class as well.`

So here comes builder pattern

1. create static inner class (for USerDTo).
2. hide Outer class constructor (User class).
3. implement build method inside inner class which return outer class object.

```java

//User.java

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

// Usertest.java
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

```

#### Improvements

We can use method chaining and create static intialiser for builder instance

```java
// User.java

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


// UserTest.java

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

```
