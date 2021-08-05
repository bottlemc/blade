package com.github.bottlemc.blade.display;

import com.github.bottlemc.blade.configurable.Category;
import com.github.bottlemc.blade.configurable.Configurable;
import com.github.bottlemc.blade.configurable.Toggle;
import com.github.glassmc.sculpt.framework.Color;
import com.github.glassmc.sculpt.framework.constraint.*;
import com.github.glassmc.sculpt.framework.element.Container;
import com.github.glassmc.sculpt.framework.element.Text;
import com.github.glassmc.sculpt.framework.layout.RegionLayout;

import java.awt.*;
import java.io.IOException;

public class CategoryContainer extends SettingContainer {

    public CategoryContainer(Configurable<?> configurable, Category category) {
        super(configurable);
        try {
            this
                .padding(Direction.TOP, new Relative(0.0125))
                .width(new Relative(1, -7.5, false))
                .height(new Absolute(8))
                .getLayout(RegionLayout.class)
                .add(new Text()
                    .text(category.getName())
                    .color(new Absolute(flame.getConfiguration().foregroundPrimary))
                    .font(Font.createFont(Font.TRUETYPE_FONT, BladeWindow.class.getClassLoader().getResourceAsStream("Roboto-Medium.ttf")))
                    .size(new Relative(0.65, 0, true)),
                    RegionLayout.Region.LEFT);
        } catch (FontFormatException | IOException e) {
            e.printStackTrace();
        }
    }

}
