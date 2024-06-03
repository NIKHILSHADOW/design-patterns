package com.example.prototype.simpleprototype.game;

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
