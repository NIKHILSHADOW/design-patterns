# PROTOTYPE

- [Home](../../../../../../README.md)

# Contents

- [PROTOTYPE](#prototype)
- [Contents](#contents)
  - [Simple Prototype](#simple-prototype)
  - [Prototype Registry](#prototype-registry)

1. Simple Prototype
2. Prototype registry

### Simple Prototype

- create clone method for object creation.

- Used when instance creation is hard.

Why we need this?

For suppose converting field values to pixels is heavy task in graphics. So we create only once and reuse it for same type of object.

Steps :

1. Create a clonable interface with clone method
2. Create sub classes implementing clone method.

Clonable Interface

```java
public interface GraphicalObject {

    public GraphicalObject clone();
}

```

Well defined class

```java

import java.util.ArrayList;
import java.util.List;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ForeGround implements GraphicalObject {

    private Integer x;
    private Integer y;
    private Integer width;
    private Integer height;
    private GraphicalObjectType type;

    @Getter(AccessLevel.NONE)
    @Setter(AccessLevel.NONE)
    private List<Integer> pixels;

    private ForeGround() {
    }

    public ForeGround(Integer x, Integer y, Integer width, Integer height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.type = GraphicalObjectType.FOREGROUND;

        this.pixels = someHeavyTimeConsuming();
    }

    private List<Integer> someHeavyTimeConsuming() {
        return new ArrayList<>();
    }

    @Override
    public ForeGround clone() {
        ForeGround foreGround = new ForeGround();
        foreGround.height = this.height;
        foreGround.width = this.width;
        foreGround.x = this.x;
        foreGround.y = this.y;
        foreGround.type = this.type;

        foreGround.pixels = this.pixels;

        return foreGround;

    }

}


```

Test class

```java
import org.junit.Assert;
import org.junit.Test;

import com.example.prototype.simpleprototype.game.Background;
import com.example.prototype.simpleprototype.game.ForeGround;
import com.example.prototype.simpleprototype.game.GraphicalObject;
import com.example.prototype.simpleprototype.game.GraphicalObjectType;

public class GraphicalObjTest {

    @Test
    public void backgroundTest() {

        GraphicalObject backgroundObj = new Background(23, 24, 4, 32);

        Assert.assertNotNull("if constructor called instance shouldn't be null", backgroundObj);
        Assert.assertEquals("height should be as given", Integer.valueOf(32), ((Background) backgroundObj).getHeight());

        GraphicalObject clonedObj = backgroundObj.clone();

        Assert.assertNotNull("if clone method called instance shouldn't be null", clonedObj);
        Assert.assertEquals("type should be backgroundtype", GraphicalObjectType.BACKGROUND,
                ((Background) backgroundObj).getType());

        Assert.assertEquals("height should be as given", Integer.valueOf(32), ((Background) backgroundObj).getHeight());

    }

    @Test
    public void foregroundTest() {

        GraphicalObject foreGroundObj = new ForeGround(23, 24, 4, 32);

        Assert.assertNotNull("if constructor called instance shouldn't be null", foreGroundObj);
        Assert.assertEquals("height should be as given", Integer.valueOf(32), ((ForeGround) foreGroundObj).getHeight());

        GraphicalObject clonedObj = foreGroundObj.clone();

        Assert.assertNotNull("if clone method called instance shouldn't be null", clonedObj);
        Assert.assertEquals("type should be backgroundtype", GraphicalObjectType.FOREGROUND,
                ((ForeGround) foreGroundObj).getType());

        Assert.assertEquals("height should be as given", Integer.valueOf(32), ((ForeGround) foreGroundObj).getHeight());

    }
}


```

### Prototype Registry

When morethan one objects are there , then we use this registry, to easy access.

1. It solves heavycomputational time.
2. It hides subclasses.

```java

public class GraphicalRegistry {
    Map<GraphicalObjType, GraphicalObj> registry = new HashMap<>();

    public void addObject(GraphicalObjType graphicalObjType, GraphicalObj graphicalObj) {
        this.registry.put(graphicalObjType, graphicalObj);
    }

    public GraphicalObj getObject(GraphicalObjType graphicalObjType) {
        return this.registry.get(graphicalObjType);
    }
}

```

```java
public class GameTest {

    private GraphicalRegistry graphicalRegistry = new GraphicalRegistry();

    @Test
    public void instanceTest() {
        Background background = new Background(23, 34, 34, 23, GraphicalObjType.BACKGROUND);

        Assert.assertNotNull(background);

        graphicalRegistry.addObject(background.getGraphicalObjType(), background);

        Background backgroundClone = (Background) graphicalRegistry.getObject(GraphicalObjType.BACKGROUND).clone();

        Assert.assertEquals(background.getHeight(), backgroundClone.getHeight());

    }
}

```

But subclasses are first created by clients to insert in registry,

So next comes Factory to solve involvement of subclasses.
