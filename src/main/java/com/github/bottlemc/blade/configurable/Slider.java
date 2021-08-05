package com.github.bottlemc.blade.configurable;

public class Slider extends SettingElement {

    private final String name;
    private final String id;

    public Slider(String name, String id) {
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

}
