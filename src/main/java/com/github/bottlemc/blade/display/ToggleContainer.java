package com.github.bottlemc.blade.display;

import com.github.bottlemc.blade.configurable.Configurable;
import com.github.bottlemc.blade.configurable.Toggle;
import com.github.glassmc.sculpt.framework.Color;
import com.github.glassmc.sculpt.framework.constraint.*;
import com.github.glassmc.sculpt.framework.element.Container;
import com.github.glassmc.sculpt.framework.element.Text;
import com.github.glassmc.sculpt.framework.layout.RegionLayout;

import java.awt.*;
import java.io.IOException;

public class ToggleContainer extends SettingContainer {

    private final Color enabledColor = new Color(110, 166, 100);
    private final Color disabledColor = new Color(166, 100, 100);

    private boolean toggled;

    public ToggleContainer(Configurable<?> configurable, Toggle toggle) {
        super(configurable);
        toggled = (boolean) this.getValue(configurable, toggle.getId());
        try {
            this
                .padding(Direction.TOP, new Relative(0.0125))
                .width(new Relative(1, -15, false))
                .height(new Absolute(8))
                .getLayout(RegionLayout.class)
                .add(new Text()
                    .text(toggle.getName())
                    .color(new Absolute(flame.getConfiguration().foregroundPrimary))
                    .font(Font.createFont(Font.TRUETYPE_FONT, BladeWindow.class.getClassLoader().getResourceAsStream("Roboto-Light.ttf")))
                    .size(new Relative(0.65, 0, true)),
                    RegionLayout.Region.LEFT)
                .add(new Container()
                    .width(new Relative(1.6, 0, true))
                    .height(new Relative(0.8))
                    .cornerRadius(new Relative(0.4, 0, true))
                    .backgroundColor(new Absolute(flame.getConfiguration().elementBackground))
                    .getLayout(RegionLayout.class)
                    .add(new Container()
                        .backgroundColor(new CustomTruth(100, () -> toggled, disabledColor, enabledColor))
                        .x(new CustomTruth(150, () -> toggled, new Side(Side.Direction.NEGATIVE), new Side(Side.Direction.POSITIVE)))
                        .width(new Copy())
                        .height(new Relative(1, -2))
                        .padding(new Absolute(1))
                        .cornerRadius(new Relative(0.5, -1, true)),
                        RegionLayout.Region.CENTER)
                    .getContainer()
                    .onClick(interact -> {
                        toggled = !toggled;
                        this.setValue(configurable, toggle.getId(), toggled);

                        Container container = (Container) interact.getElement();
                        Container container2 = (Container) container.getChildren().get(0);
                        container2.backgroundColor(new Absolute(toggled ? enabledColor : disabledColor));
                    }),
                    RegionLayout.Region.RIGHT);
        } catch (FontFormatException | IOException e) {
            e.printStackTrace();
        }
    }

}
