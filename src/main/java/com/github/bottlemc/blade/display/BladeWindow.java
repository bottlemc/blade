package com.github.bottlemc.blade.display;

import com.github.bottlemc.blade.configurable.*;
import com.github.bottlemc.molten.Window;
import com.github.glassmc.loader.GlassLoader;
import com.github.glassmc.sculpt.Sculpt;
import com.github.glassmc.sculpt.framework.Vector2D;
import com.github.glassmc.sculpt.framework.backend.IBackend;
import com.github.glassmc.sculpt.framework.element.Container;
import com.github.glassmc.sculpt.framework.layout.ListLayout;

public class BladeWindow extends Window {

    private boolean initialized = false;

    public BladeWindow(Configurable<?> configurable) {
        super(configurable.getName(), null, new Container()
            .layout(new ListLayout(ListLayout.Type.VERTICAL))
            .apply(container -> {
                for (SettingElement setting : configurable.getSettings()) {
                    if (setting instanceof Toggle) {
                        container.getLayout(ListLayout.class)
                            .add(new ToggleContainer(configurable, (Toggle) setting));
                    } else if (setting instanceof Slider) {
                        container.getLayout(ListLayout.class)
                            .add(new SliderContainer(configurable, (Slider) setting));
                    } else if (setting instanceof Category) {
                        container.getLayout(ListLayout.class)
                            .add(new CategoryContainer(configurable, (Category) setting));
                    }
                }
            }));
    }

    @Override
    public void update() {
        if (!initialized) {IBackend backend = GlassLoader.getInstance().getAPI(Sculpt.class).getBackend();

            Vector2D dimension = backend.getDimension();
            this.setWidth(0.5 * dimension.getSecond() / dimension.getFirst() * 0.9);
            this.setHeight(0.5);

            initialized = true;
        }
        super.update();
    }

}
