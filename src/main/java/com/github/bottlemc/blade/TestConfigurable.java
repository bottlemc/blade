package com.github.bottlemc.blade;

import com.github.bottlemc.blade.configurable.Category;
import com.github.bottlemc.blade.configurable.Configurable;
import com.github.bottlemc.blade.configurable.Slider;
import com.github.bottlemc.blade.configurable.Toggle;

public class TestConfigurable extends Configurable<TestConfiguration> {

    public TestConfigurable() {
        super("Test Settings", "test",
                new Category("Main Settings"),
                new Toggle("Test Setting", "value"),
                new Slider("Test Slider", "doubleValue"));
    }

}
