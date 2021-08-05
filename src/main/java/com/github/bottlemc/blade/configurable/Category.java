package com.github.bottlemc.blade.configurable;

public class Category extends SettingElement {

    private final String name;

    public Category(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

}
