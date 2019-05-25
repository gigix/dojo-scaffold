package com.liucj.learn.meetup;

import java.lang.reflect.Type;

public class ParameterType {
    public String name;
    public boolean position;
    public String type;

    public ParameterType(String name, boolean position, String type) {
        this.name = name;
        this.position = position;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isPosition() {
        return position;
    }

    public void setPosition(boolean position) {
        this.position = position;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
