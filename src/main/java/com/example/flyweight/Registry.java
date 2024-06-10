package com.example.flyweight;

import java.util.HashMap;
import java.util.Map;

public class Registry<TYPE, OBJ> {
    Map<TYPE, OBJ> instances = new HashMap<>();

    private void add(TYPE type, OBJ obj) {
        instances.put(type, obj);
    }

    public OBJ get(TYPE type) {
        return instances.get(type);
    }

    public void addIfNotPresent(TYPE type, OBJ obj) {
        if (instances.containsKey(type)) {
            return;
        }
        add(type, obj);
    }

}
