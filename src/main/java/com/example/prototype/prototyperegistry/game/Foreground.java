package com.example.prototype.prototyperegistry.game;

import java.util.ArrayList;
import java.util.List;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Foreground {

    private Integer x;
    private Integer y;
    private Integer width;
    private Integer height;
    private GraphicalObjType graphicalObjType;

    @Getter(AccessLevel.NONE)
    @Setter(AccessLevel.NONE)
    private List<Integer> pixels;

    private Foreground() {
    }

    public Foreground(Integer x, Integer y, Integer width, Integer height, GraphicalObjType graphicalObjType) {
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
    public Foreground clone() {

        Foreground foreground = new Foreground();
        foreground.x = this.x;
        foreground.y = this.y;
        foreground.pixels = this.pixels;
        foreground.width = this.width;
        foreground.graphicalObjType = this.graphicalObjType;
        foreground.height = this.height;

        return foreground;
    }
}
