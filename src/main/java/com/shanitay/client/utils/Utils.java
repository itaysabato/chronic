package com.shanitay.client.utils;

import com.allen_sauer.gwt.voices.client.Sound;
import com.allen_sauer.gwt.voices.client.SoundController;
import com.google.gwt.core.client.Scheduler;
import com.google.gwt.dom.client.Style;
import com.google.gwt.event.dom.client.MouseDownEvent;
import com.google.gwt.event.dom.client.MouseDownHandler;
import org.vectomatic.dom.svg.*;
import org.vectomatic.dom.svg.events.HasGraphicalHandlers;
import org.vectomatic.dom.svg.utils.DOMHelper;
import org.vectomatic.dom.svg.utils.SVGPrefixResolver;

import java.util.Iterator;

/**
 * Created By: Itay Sabato<br/>
 * Date: 13/05/12 <br/>
 * Time: 03:40 <br/>
 */
public class Utils {
    public static final int TIME_UNIT = 41;

    public static void animateFor(final StateChangeAnimator animator, final OMSVGElement element, int durationMillis) {
        animator.inAnimation(element);

        Scheduler.get().scheduleFixedDelay(new Scheduler.RepeatingCommand() {
            public boolean execute() {
                animator.offAnimation(element);
                return false;
            }
        }, durationMillis);
    }

    public static void show(OMSVGElement element) {
        element.getStyle().setDisplay(Style.Display.BLOCK);
    }

    public static void hide(OMSVGElement element) {
        element.getStyle().setDisplay(Style.Display.NONE);
    }

    public static void addHandler(HasGraphicalHandlers element, final SomeHandler someHandler) {
//        element.addTouchStartHandler(new TouchStartHandler() {
//            public void onTouchStart(TouchStartEvent event) {
//                someHandler.handle();
//            }
//        });

        element.addMouseDownHandler(new MouseDownHandler() {
            public void onMouseDown(MouseDownEvent event) {
                someHandler.handle();
            }
        });

//        element.addClickHandler(new ClickHandler() {
//            public void onClick(ClickEvent event) {
//                someHandler.handle();
//            }
//        });

//        element.getElement().getStyle().setCursor(Style.Cursor.POINTER);
    }

    public static OMSVGElement getSVGElement(String elementId, OMSVGSVGElement element) {
        final OMNode node = getElement(elementId, element);
        return (OMSVGElement) node;
    }

    public static OMSVGGElement getGElement(String elementId, OMSVGSVGElement element) {
        final OMNode node = getElement(elementId, element);
        return (OMSVGGElement) node;
    }

    public static OMNode getElement(String elementId, OMSVGSVGElement element) {
        final Iterator<OMNode> omNodeIterator = DOMHelper.evaluateXPath(element, ".//*[@id=\"" + elementId + "\"]", new SVGPrefixResolver());

        if (omNodeIterator.hasNext()) {
            return omNodeIterator.next();
        }
        else {
            throw new ShanitayException("Failed to find element: " + elementId);
        }
    }

    public static void translate(OMSVGGElement gElement, float x, float y) {
        gElement.setAttribute("transform", "translate(" + x + "," + y + ")");
    }

    public static Sound getSound(final String soundUrl, SoundController soundController) {
        return soundController.createSound(Sound.MIME_TYPE_AUDIO_MPEG_MP3, soundUrl, true, false);
    }

    public static OMSVGAnimationElement getAnimationElement(String elementId, OMSVGSVGElement svgsvgElement) {
        final OMNode element = Utils.getElement(elementId, svgsvgElement);
        return (OMSVGAnimationElement) element;
    }

    public static void stopToy(OMSVGGElement element, final Toy toy) {
        Utils.addHandler(element, new Utils.SomeHandler() {
            public void handle() {
                toy.stop();
            }
        });
    }

    public static Toy attachToy(HasGraphicalHandlers element, Sound sound, boolean looping, Toy.Animation... animations) {
        final Toy toy = new Toy(sound, animations);
        toy.setLooping(looping);

        Utils.addHandler(element, new Utils.SomeHandler() {
            public void handle() {
                toy.toggle();
            }
        });

        return toy;
    }

    public interface SomeHandler {
        void handle();
    }
}
