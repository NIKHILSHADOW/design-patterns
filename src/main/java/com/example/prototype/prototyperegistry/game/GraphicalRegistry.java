package com.example.prototype.prototyperegistry.game;

import java.util.HashMap;
import java.util.Map;

public class GraphicalRegistry {
    Map<GraphicalObjType, GraphicalObj> registry = new HashMap<>();

    public void addObject(GraphicalObjType graphicalObjType, GraphicalObj graphicalObj) {
        this.registry.put(graphicalObjType, graphicalObj);
    }

    public GraphicalObj getObject(GraphicalObjType graphicalObjType) {
        return this.registry.get(graphicalObjType);
    }
}
