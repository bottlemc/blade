package com.github.bottlemc.blade.configurable;

public class Toggle extends Setting {

    private final String name;
    private final String id;

    public Toggle(String name, String id) {
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
