package com.github.bottlemc.blade.display;

import com.github.bottlemc.blade.configurable.Configurable;
import com.github.bottlemc.blade.configurable.Slider;
import com.github.glassmc.sculpt.framework.Color;
import com.github.glassmc.sculpt.framework.constraint.*;
import com.github.glassmc.sculpt.framework.element.Container;
import com.github.glassmc.sculpt.framework.element.Text;
import com.github.glassmc.sculpt.framework.layout.RegionLayout;

import java.awt.*;
import java.io.IOException;

public class SliderContainer extends SettingContainer {

    private final Color enabledColor = new Color(110, 166, 100);
    private final Color disabledColor = new Color(166, 100, 100);

    private double value;

    public SliderContainer(Configurable<?> configurable, Slider slider) {
        super(configurable);
        value = (double) this.getValue(configurable, slider.getId());
        double displayValue = 0;
        try {
            this
                .padding(Direction.TOP, new Relative(0.0125))
                .width(new Relative(1, -15))
                .height(new Absolute(8))
                .getLayout(RegionLayout.class)
                .add(new Text()
                    .text(slider.getName())
                    .color(new Absolute(flame.getConfiguration().foregroundPrimary))
                    .font(Font.createFont(Font.TRUETYPE_FONT, BladeWindow.class.getClassLoader().getResourceAsStream("Roboto-Light.ttf")))
                    .size(new Relative(0.65, 0, true)),
                    RegionLayout.Region.LEFT)
                .add(new Container()
                    .width(new Relative(4.8, 0, true))
                    .height(new Relative(0.8))
                    .cornerRadius(new Relative(0.4, 0, true))
                    .backgroundColor(new Absolute(flame.getConfiguration().elementBackground))
                    .getLayout(RegionLayout.class)
                    .add(new Container()
                        .padding(new Absolute(1))
                        .onClick(interact -> {
                            double width = interact.getElement().getConstructor().getWidth();
                            double height = interact.getElement().getConstructor().getHeight();
                            value = Math.max(height / width, Math.min(1, interact.getX() + height / 2 / width));
                            this.setValue(configurable, slider.getId(), value);
                        })
                        .onDrag(interact -> {
                            double width = interact.getElement().getConstructor().getWidth();
                            double height = interact.getElement().getConstructor().getHeight();
                            value = Math.max(0, Math.min(1, (interact.getX() * (width / (width - height))) - height / 2 / width));
                            this.setValue(configurable, slider.getId(), value);
                        })
                        .getLayout(RegionLayout.class)
                        .add(new Container()
                            .backgroundColor(new Absolute(flame.getConfiguration().foregroundPrimary))
                            .width(new Relative(element -> {
                                double width = ((Container) element).getParent().getConstructor().getWidth();
                                double height = ((Container) element).getParent().getConstructor().getHeight();

                                double min = height / width;
                                double max = 1;
                                return (max - min) * value + min;
                            }))
                            .cornerRadius(new Relative(0.5, 0, true)),
                            RegionLayout.Region.LEFT)
                        .getContainer(),
                        RegionLayout.Region.CENTER)
                    /*.add(new Container()
                        .backgroundColor(new CustomTruth(100, () -> toggled, disabledColor, enabledColor))
                        .x(new CustomTruth(150, () -> toggled, new Side(Side.Direction.NEGATIVE), new Side(Side.Direction.POSITIVE)))
                        .width(new Copy())
                        .height(new Relative(1, -2))
                        .padding(new Absolute(1))
                        .cornerRadius(new Relative(0.5, -1, true)),
                        RegionLayout.Region.CENTER)*/
                    .getContainer()
                    /*.onClick(container1 -> {
                        toggled = !toggled;
                        this.setValue(configurable, toggle.getId(), toggled);

                        Container container2 = (Container) container1.getChildren().get(0);
                        container2.backgroundColor(new Absolute(toggled ? enabledColor : disabledColor));
                    })*/,
                    RegionLayout.Region.RIGHT);
        } catch (FontFormatException | IOException e) {
            e.printStackTrace();
        }
    }

}
