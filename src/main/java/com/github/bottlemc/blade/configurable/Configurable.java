package com.github.bottlemc.blade.configurable;

import com.github.bottlemc.sheet.Sheet;
import com.github.glassmc.loader.GlassLoader;

public class Configurable<T> {

    private final String name;
    private final T configuration;
    private final SettingElement[] settings;

    public Configurable(String name, String configId, SettingElement... settings) {
        this.name = name;
        this.configuration = GlassLoader.getInstance().getAPI(Sheet.class).load(configId);
        this.settings = settings;
    }

    public String getName() {
        return name;
    }

    public T getConfiguration() {
        return configuration;
    }

    public SettingElement[] getSettings() {
        return settings;
    }

}
