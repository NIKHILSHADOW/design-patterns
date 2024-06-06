# FACTORY

## Contents

- [FACTORY](#factory)
  - [Contents](#contents)
    - [Simple Factory](#simple-factory)
      - [Steps](#steps)
      - [Simple Factory Code](#simple-factory-code)
    - [Factory Method](#factory-method)
      - [ Steps ](#-steps-)
      - [Code](#code)
    - [Abstract Factory](#abstract-factory)

**Factory Intro**

Why and when we need to use factory design pattern.

When we need to eliminate using subclasses in client code.

### Simple Factory

- It tries to eliminate usage of subclass.

#### Steps

1. First create interface
2. Create respective subclasses
3. Create factory class
4. create static method for object creation.

#### Simple Factory Code

**Interface**

```java
public interface GameObject {

}

```

**Subclasses**

```java

public class BackGroundObj implements GameObject {

}

```

**Test**

```java

public class GameTest {

    @Test
    public void backGroundInstanceTest() {
        GameObject backGroundObject = GameFactory.getInstance(GameType.BACKGROUND);

        Assert.assertNotNull("instance should be created if gmfactory method is called", backGroundObject);
        Assert.assertTrue("instnace should be of background", backGroundObject instanceof BackGroundObj);
    }
}
```

If we there are few arguments, we can pass in constructor,
But What if there are too many arguments?

1. Code will not be maintable.

what are problems with Simple factory

1. Not complied with SRP
2. Not complied with OCP
3. Not maintainable (if we there are many types)

How to solve this problem?

Here comes the factory method

### Factory Method

It says **Define an interface for creating an object, but let subclasses decide which class to instantiate. Factory Method lets a class defer instantiation to
subclasses**

#### <u> Steps </u>

1. Create Product interface
2. Create product subclasses for each type
3. Create Factory interface
   3.5. create unimplemented method in factory interface
4. create Factory subclasses for each type of product.

#### Code

```java
// Step 1. Create Product interface

public abstract class Button {

    private ButtonType buttonType;

    public Button(ButtonType buttonType) {
        this.buttonType = buttonType;
    }

}

// Step 2. Create Respective types

public class PrimaryButton extends Button {

    public PrimaryButton() {
        super(ButtonType.PRIMARY);
    }

}

// Step 3. Create Factory interface
//   step 3.5. create unimplemented method for creating product in factory interface

// ButtonFactory

public interface ButtonFactory {

    public Button createButton();
}

// Step 4. create factory subclasses for creating each type of product

public class PrimaryButtonFactory implements ButtonFactory {

    @Override
    public PrimaryButton createButton() {
        return new PrimaryButton();
    }

}

```

### Abstract Factory
