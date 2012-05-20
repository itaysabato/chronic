package com.shanitay.client.robot;

import com.google.gwt.core.client.GWT;
import com.shanitay.client.WidgetBinder;
import com.shanitay.client.utils.Utils;
import org.vectomatic.dom.svg.OMSVGGElement;
import org.vectomatic.dom.svg.OMSVGSVGElement;
import org.vectomatic.dom.svg.ui.SVGResource;

/**
 * Created By: Itay Sabato<br/>
 * Date: 19/05/12 <br/>
 * Time: 20:24 <br/>
 */
public class RobotWidgetBinder implements WidgetBinder {

    public OMSVGSVGElement bindWidgets() {
        RobotBundle robotBundle = GWT.create(RobotBundle.class);
        final SVGResource svgResource = robotBundle.mainSvg();
        final OMSVGSVGElement svgElement = svgResource.getSvg();

        final SoundLoader soundLoader = new SoundLoader();
        final ElementLoader elementLoader = new ElementLoader(svgElement);
        final AnimationLoader animationLoader = new AnimationLoader(elementLoader);

        Utils.attachToy(elementLoader.tooth1, soundLoader.tooth1, false, animationLoader.tooth1);
        Utils.attachToy(elementLoader.tooth2, soundLoader.tooth2, false, animationLoader.tooth2);
        Utils.attachToy(elementLoader.tooth3, soundLoader.tooth3, false, animationLoader.tooth3);
        Utils.attachToy(elementLoader.tooth4, soundLoader.tooth4, false, animationLoader.tooth4);
        Utils.attachToy(elementLoader.tooth5, soundLoader.tooth5, false, animationLoader.tooth5);
        Utils.attachToy(elementLoader.tooth6, soundLoader.tooth6, false, animationLoader.tooth6);
        Utils.attachToy(elementLoader.lightningButton, soundLoader.electric, false, animationLoader.electric);
        Utils.attachToy(elementLoader.earLeft, soundLoader.earLeft, false, animationLoader.earLeft);
        Utils.attachToy(elementLoader.earRight, soundLoader.earRight, false, animationLoader.earRight);

        Utils.attachToy(elementLoader.coopButton, soundLoader.coop, true, animationLoader.coopBg);
        Utils.addHandler(elementLoader.coopButton, new Utils.SomeHandler() {
            public void handle() {
                animationLoader.coopCenter.play();
            }
        });

        Utils.attachToy(
                elementLoader.pumpHouse,
                soundLoader.pumpHouse,
                true,
                animationLoader.pumpColors,
                animationLoader.bgPump,
                animationLoader.pumpHouse);

        Utils.createToggleButton(elementLoader.nose,
                new Utils.SomeHandler() {
                    public void handle() {
                        Utils.show(elementLoader.surprised);
                        Utils.hide(elementLoader.eyes);
                    }
                },

                new Utils.SomeHandler() {
                    public void handle() {
                        Utils.hide(elementLoader.surprised);
                        Utils.show(elementLoader.eyes);
                    }
                });

        createGlassesButton(elementLoader, elementLoader.teethDown);
        createGlassesButton(elementLoader, elementLoader.teethDownOpen);

        return svgElement;
    }

    private void createGlassesButton(final ElementLoader elementLoader, OMSVGGElement teethDown) {
        Utils.createToggleButton(teethDown,
                new Utils.SomeHandler() {
                    public void handle() {
                        Utils.show(elementLoader.glasses);
                    }
                },

                new Utils.SomeHandler() {
                    public void handle() {
                        Utils.hide(elementLoader.glasses);
                    }
                }
        );
    }
}
