package com.github.bottlemc.blade.display;

import com.github.bottlemc.blade.configurable.Configurable;
import com.github.bottlemc.blade.configurable.Setting;
import com.github.bottlemc.blade.configurable.Toggle;
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
                for (Setting setting : configurable.getSettings()) {
                    if(setting instanceof Toggle) {
                        container.getLayout(ListLayout.class)
                            .add(new ToggleContainer(configurable, (Toggle) setting));
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
