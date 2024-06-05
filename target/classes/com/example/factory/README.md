# FACTORY

## Contents

- [FACTORY](#factory)
  - [Contents](#contents)
    - [Simple Factory](#simple-factory)
      - [Steps](#steps)
      - [Simple Factory Code](#simple-factory-code)
    - [Factory Method](#factory-method)
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

But What if there are too many arguments?

### Factory Method

### Abstract Factory
