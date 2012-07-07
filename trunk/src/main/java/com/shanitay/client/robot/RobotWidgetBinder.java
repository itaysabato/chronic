package com.shanitay.client.robot;

import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.Scheduler;
import com.google.gwt.user.client.History;
import com.shanitay.client.AbstractSvgWidgetBinder;
import com.shanitay.client.utils.*;
import com.shanitay.client.utils.animations.FillColorAnimator;
import com.shanitay.client.utils.animations.HandlerToyAnimation;
import com.shanitay.client.utils.gadgets.LoopRecorder;
import com.shanitay.client.utils.gadgets.LoopRecorderController;
import com.shanitay.client.utils.gadgets.Spinner;
import org.vectomatic.dom.svg.OMSVGAnimationElement;
import org.vectomatic.dom.svg.OMSVGGElement;
import org.vectomatic.dom.svg.OMSVGSVGElement;
import org.vectomatic.dom.svg.events.EndEvent;
import org.vectomatic.dom.svg.events.EndHandler;
import org.vectomatic.dom.svg.ui.SVGResource;

import java.util.ArrayList;
import java.util.List;

/**
 * Created By: Itay Sabato<br/>
 * Date: 19/05/12 <br/>
 * Time: 20:24 <br/>
 */
public class RobotWidgetBinder extends AbstractSvgWidgetBinder {

    private LoopRecorderController recorderController;
    private OMSVGSVGElement svgElement;
    private ElementLoader elementLoader;
    private SoundLoader soundLoader;
    private AnimationLoader animationLoader;
    private List<LoopRecorder> recordersList;

    protected OMSVGSVGElement bindWidgets() {
        RobotBundle robotBundle = GWT.create(RobotBundle.class);
        final SVGResource svgResource = robotBundle.mainSvg();
        svgElement = svgResource.getSvg();

        soundLoader = new SoundLoader();
        elementLoader = new ElementLoader(svgElement);
        animationLoader = new AnimationLoader(elementLoader);
        recorderController = new LoopRecorderController(this.svgElement);
        initRecorder();

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

        Utils.attachToy(elementLoader.earRight, soundLoader.earRight, false, animationLoader.earRight);

        Utils.attachToy(elementLoader.eyeBrawLeft, soundLoader.leftBraw, false, animationLoader.leftBraw);
        Utils.attachToy(elementLoader.eyeBrawRight, soundLoader.rightBraw, false, animationLoader.rightBraw);

        Toy.Animation surpriseAnimation = new HandlerToyAnimation(new Utils.SomeHandler() {
            public void handle() {
                String display = elementLoader.surprised.getStyle().getDisplay();
                if (display.equalsIgnoreCase("none")) {
                    soundLoader.surprise.play();
                    Utils.show(elementLoader.surprised);
                    Utils.hide(elementLoader.eyes);
                }
                else {
                    Utils.hide(elementLoader.surprised);
                    Utils.show(elementLoader.eyes);
                }
            }
        });

        Utils.attachToy(elementLoader.diskButton, Utils.getNullSound(), false, surpriseAnimation, animationLoader.diskButton);

        createGlassesButton(soundLoader, elementLoader, elementLoader.teethDownOpen);

        HandlerToyAnimation mouthOpenAnimation = new HandlerToyAnimation(new Utils.SomeHandler() {
            public void handle() {
                if (isMouthOpen(elementLoader)) {
                    animationLoader.closeMouth.play();
                }
                else {
                    animationLoader.openMouth.play();
                }
            }
        });
        Utils.attachToy(elementLoader.mot, soundLoader.mot, false, animationLoader.mot, mouthOpenAnimation);

        Spinner spinner = new Spinner(soundLoader.open, soundLoader.close);
        spinner.init(elementLoader.eyeRightSur, svgElement, 809.87f, 199.86f);

        Utils.attachToy(elementLoader.drum1, soundLoader.drum1, false, animationLoader.drum1);
        Utils.attachToy(elementLoader.drum2, soundLoader.drum2, false, animationLoader.drum2);
        Utils.attachToy(elementLoader.drum3, soundLoader.drum3, false, animationLoader.drum3);
        Utils.attachToy(elementLoader.drum4, soundLoader.drum4, false, animationLoader.drum4);

        Utils.addHandler(elementLoader.backArrow, new Utils.SomeHandler() {
            public void handle() {
                History.back();
            }
        });

        bindTv();
        bindDisk();
        bindNose();
        return svgElement;
    }

    private void bindNose() {
        Utils.attachToy(elementLoader.nose,  soundLoader.nose, false, animationLoader.nose);
    }

    private void bindDisk() {
        final Toy toy = new Toy(soundLoader.disk, animationLoader.pumpWheelRotate);
        toy.setLooping(true);

        final OMSVGAnimationElement moveIn = animationLoader.diskMoveIn.getSvgAnimationElement();
        moveIn.addEndHandler(new EndHandler() {
            public void onEnd(EndEvent event) {
                toy.stop();
            }
        });

        Utils.addHandler(elementLoader.earLeft, new Utils.SomeHandler() {
            private boolean on = false;

            public void handle() {
                animationLoader.diskButton.play();

                if(on) {
                    animationLoader.diskMoveIn.play();
                }
                else {
                    toy.play();
                    animationLoader.diskMoveOut.play();
                }

                on =!on;
            }
        });
    }

    private void bindTv() {
        final Toy toy = Utils.attachToy(elementLoader.tv1, soundLoader.tv, true, animationLoader.tv);
        final ToyStopperHandler handler = new ToyStopperHandler(toy);
        Utils.addHandler(elementLoader.tv2, handler);
        Utils.addHandler(elementLoader.tv3, handler);
    }

    private void initRecorder() {
        recordersList = new ArrayList<LoopRecorder>(4);

        final FillColorAnimator animator1 = new FillColorAnimator(ShaniColors.PINK, ShaniColors.YELLOW);
        final LoopRecorder recorder1 = new LoopRecorder(animator1, elementLoader.pinkButton1);
        bindRecorder(recorder1, elementLoader.track1);
        recordersList.add(recorder1);

        final FillColorAnimator animator2 = new FillColorAnimator(ShaniColors.GREEN, ShaniColors.YELLOW);
        final LoopRecorder recorder2 = new LoopRecorder(animator2, elementLoader.greenButton2);
        bindRecorder(recorder2, elementLoader.track2);
        recordersList.add(recorder2);

        final FillColorAnimator animator3 = new FillColorAnimator(ShaniColors.RED, ShaniColors.YELLOW);
        final LoopRecorder recorder3 = new LoopRecorder(animator3, elementLoader.redButton3);
        bindRecorder(recorder3, elementLoader.track3);
        recordersList.add(recorder3);

        final FillColorAnimator animator4 = new FillColorAnimator(ShaniColors.TURQUOISE, ShaniColors.YELLOW);
        final LoopRecorder recorder4 = new LoopRecorder(animator4, elementLoader.blueButton4);
        bindRecorder(recorder4, elementLoader.track4);
        recordersList.add(recorder4);

        recorder1.on();
        recorderController.setRecorder(recorder1);
        LoopRecorderFactory.setRecorder(recorder1);
    }

    private void bindRecorder(final LoopRecorder recorder, OMSVGGElement track) {
        Utils.addHandler(track, new Utils.SomeHandler() {
            public void handle() {
                if (LoopRecorderFactory.hasRecorder()) {
                    LoopRecorderFactory.getRecorder().off();
                }
                recorder.on();
                recorderController.setRecorder(recorder);
                LoopRecorderFactory.setRecorder(recorder);
            }
        });
    }

    private boolean isMouthOpen(ElementLoader elementLoader) {
        return elementLoader.isMouthOpen();
    }

    private void createGlassesButton(final SoundLoader soundLoader, final ElementLoader elementLoader, OMSVGGElement teethDown) {
        Utils.SomeHandler teethHandler = new Utils.SomeHandler() {
            public void handle() {
                String display = elementLoader.glasses.getStyle().getDisplay();
                if (display.equalsIgnoreCase("none")) {
                    soundLoader.toothBottom.play();
                    Utils.show(elementLoader.glasses);
                }
                else {
                    Utils.hide(elementLoader.glasses);
                }
            }
        };
        Utils.attachToy(teethDown, Utils.getNullSound(), false, new HandlerToyAnimation(teethHandler));
    }

    @Override
    protected void shutdown() {
        if(recordersList != null) {
            for (LoopRecorder loopRecorder : recordersList) {
                loopRecorder.stop();
            }
        }
    }
}
