package com.example.prototype.prototyperegistry.game;

import java.util.ArrayList;
import java.util.List;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Background implements GraphicalObj {

    private Integer x;
    private Integer y;
    private Integer width;
    private Integer height;
    private GraphicalObjType graphicalObjType;

    @Getter(AccessLevel.NONE)
    @Setter(AccessLevel.NONE)
    private List<Integer> pixels;

    private Background() {
    }

    public Background(Integer x, Integer y, Integer width, Integer height, GraphicalObjType graphicalObjType) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.graphicalObjType = graphicalObjType;

        this.pixels = someHeavyComputationalMethod();
    }

    private List<Integer> someHeavyComputationalMethod() {
        return new ArrayList<>();
    }

    @Override
    public Background clone() {

        Background background = new Background();
        background.x = this.x;
        background.y = this.y;
        background.pixels = this.pixels;
        background.width = this.width;
        background.graphicalObjType = this.graphicalObjType;
        background.height = this.height;

        return background;
    }
}
