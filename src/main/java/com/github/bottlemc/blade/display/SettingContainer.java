package com.github.bottlemc.blade.display;

import com.github.bottlemc.blade.configurable.Configurable;
import com.github.bottlemc.flame.Flame;
import com.github.glassmc.loader.GlassLoader;
import com.github.glassmc.sculpt.framework.element.Container;

public class SettingContainer extends Container {

    protected final Flame flame = GlassLoader.getInstance().getAPI(Flame.class);

    private final Configurable<?> configurable;

    public SettingContainer(Configurable<?> configurable) {
        this.configurable = configurable;
    }

    public Configurable<?> getConfigurable() {
        return configurable;
    }

    public void setValue(Configurable<?> configurable, String id, Object value) {
        setValueInternal(configurable.getConfiguration(), id, value);
    }

    private void setValueInternal(Object configuration, String id, Object value) {
        if (id.contains("/")) {

        } else {
            try {
                configuration.getClass().getField(id).set(configuration, value);
            } catch (IllegalAccessException | NoSuchFieldException e) {
                e.printStackTrace();
            }
        }
    }

    public Object getValue(Configurable<?> configurable, String id) {
        return getValueInternal(configurable.getConfiguration(), id);
    }

    private Object getValueInternal(Object configuration, String id) {
        if (id.contains("/")) {

        } else {
            try {
                return configuration.getClass().getField(id).get(configuration);
            } catch (IllegalAccessException | NoSuchFieldException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

}
