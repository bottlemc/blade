package com.github.bottlemc.blade;

import com.github.bottlemc.sheet.Sheet;
import com.github.glassmc.loader.GlassLoader;
import com.github.glassmc.loader.Listener;

public class BladeSheetListener implements Listener {

    @Override
    public void run() {
        GlassLoader.getInstance().getAPI(Sheet.class).registerType("test", TestConfiguration.class);
    }

}
