package com.example.prototype.simpleprototype.game;

import java.util.ArrayList;
import java.util.List;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Background implements GraphicalObject {

    private Integer x;
    private Integer y;
    private Integer width;
    private Integer height;
    private GraphicalObjectType type;

    @Getter(AccessLevel.NONE)
    @Setter(AccessLevel.NONE)
    private List<Integer> pixels;

    private Background() {
    }

    public Background(Integer x, Integer y, Integer width, Integer height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.type = GraphicalObjectType.BACKGROUND;

        this.pixels = someHeavyTimeConsuming();
    }

    private List<Integer> someHeavyTimeConsuming() {
        return new ArrayList<>();
    }

    @Override
    public Background clone() {
        Background background = new Background();
        background.height = this.height;
        background.width = this.width;
        background.x = this.x;
        background.y = this.y;
        background.type = this.type;

        background.pixels = this.pixels;

        return background;

    }

}
