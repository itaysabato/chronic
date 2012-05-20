package com.shanitay.client.robot;

import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.Scheduler;
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

        Utils.addHandler(elementLoader.lightningButton, new Utils.SomeHandler() {
            public void handle() {
                Scheduler.get().scheduleFixedDelay(new Scheduler.RepeatingCommand() {
                    public boolean execute() {
                        Utils.hide(elementLoader.eyes);
                        Utils.show(elementLoader.surprised);
                        Utils.hide(elementLoader.glasses);
                        return false;
                    }
                }, 4*AnimationLoader.ELECTRIC_DURATION);
            }
        });
        Utils.attachToy(elementLoader.lightningButton, soundLoader.electric, false, animationLoader.electric);

        Utils.attachToy(elementLoader.earLeft, soundLoader.earLeft, false, animationLoader.earLeft);
        Utils.attachToy(elementLoader.earRight, soundLoader.earRight, false, animationLoader.earRight);

        Utils.attachToy(elementLoader.step1, soundLoader.step1, false, animationLoader.step1Explode);
        Utils.attachToy(elementLoader.step2, soundLoader.step2, false, animationLoader.step2Explode);
        Utils.attachToy(elementLoader.step3, soundLoader.step3, false, animationLoader.step3Explode);
        Utils.attachToy(elementLoader.step4, soundLoader.step4, false, animationLoader.step4Explode);
        Utils.attachToy(elementLoader.step5, soundLoader.step5, false, animationLoader.step5Explode);
        Utils.attachToy(elementLoader.step6, soundLoader.step6, false, animationLoader.step6Explode);
        Utils.attachToy(elementLoader.step7, soundLoader.step7, false, animationLoader.step7Explode);

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

        Utils.addHandler(elementLoader.nose, new Utils.SomeHandler() {
            public void handle() {
                String display = elementLoader.surprised.getStyle().getDisplay();
                if(display.equalsIgnoreCase("none")){
                    Utils.show(elementLoader.surprised);
                    Utils.hide(elementLoader.eyes);
                }
                else {
                    Utils.hide(elementLoader.surprised);
                    Utils.show(elementLoader.eyes);
                }
            }
        });

        createGlassesButton(elementLoader, elementLoader.teethDown);
        createGlassesButton(elementLoader, elementLoader.teethDownOpen);

        return svgElement;
    }

    private void createGlassesButton(final ElementLoader elementLoader, OMSVGGElement teethDown) {
        Utils.addHandler(teethDown, new Utils.SomeHandler() {
            public void handle() {
                String display = elementLoader.glasses.getStyle().getDisplay();
                if (display.equalsIgnoreCase("none")) {
                    Utils.show(elementLoader.glasses);
                }
                else {
                    Utils.hide(elementLoader.glasses);
                }
            }
        });
    }
}
