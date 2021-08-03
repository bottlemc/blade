package com.github.bottlemc.blade;

import com.github.glassmc.loader.GlassLoader;
import com.github.glassmc.loader.Listener;

public class BladeInitializeListener implements Listener {

    @Override
    public void run() {
        GlassLoader.getInstance().registerAPI(new Blade());

        Blade blade = GlassLoader.getInstance().getAPI(Blade.class);
        blade.open(new TestConfigurable());
    }

}
