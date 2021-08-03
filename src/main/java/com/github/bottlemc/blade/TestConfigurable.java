package com.github.bottlemc.blade;

import com.github.bottlemc.blade.configurable.Configurable;
import com.github.bottlemc.blade.configurable.Toggle;

public class TestConfigurable extends Configurable<TestConfiguration> {

    public TestConfigurable() {
        super("Test Settings", "test",
                new Toggle("Test Setting", "value"));
    }

}
