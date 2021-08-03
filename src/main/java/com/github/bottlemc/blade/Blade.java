package com.github.bottlemc.blade;

import com.github.bottlemc.blade.configurable.Configurable;
import com.github.bottlemc.blade.display.BladeWindow;
import com.github.bottlemc.molten.Molten;
import com.github.glassmc.loader.GlassLoader;

public class Blade {

    private final Molten molten = GlassLoader.getInstance().getAPI(Molten.class);

    public void open(Configurable<?> configurable) {
        molten.open(new BladeWindow(configurable));
    }

}
