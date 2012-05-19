package com.shanitay.client;

import com.allen_sauer.gwt.voices.client.Sound;
import com.allen_sauer.gwt.voices.client.SoundController;
import com.google.gwt.core.client.Scheduler;
import com.google.gwt.dom.client.Style;
import com.google.gwt.event.dom.client.MouseDownEvent;
import com.google.gwt.event.dom.client.MouseDownHandler;
import org.vectomatic.dom.svg.*;
import org.vectomatic.dom.svg.utils.DOMHelper;
import org.vectomatic.dom.svg.utils.SVGPrefixResolver;

import java.util.Iterator;

/**
 * Created By: Itay Sabato<br/>
 * Date: 13/05/12 <br/>
 * Time: 03:40 <br/>
 */
public class Utils {

    public static void hideFor(final OMSVGElement element, int invisibilityDuration) {
        hide(element);

        Scheduler.get().scheduleFixedDelay(new Scheduler.RepeatingCommand() {
            public boolean execute() {
                show(element);
                return false;
            }
        }, invisibilityDuration);
    }

    public static void show(OMSVGElement element) {
        element.getStyle().setVisibility(Style.Visibility.VISIBLE);
    }

    public static void hide(OMSVGElement element) {
        element.getStyle().setVisibility(Style.Visibility.HIDDEN);
    }

    public static void addHandler(OMSVGGElement element, final SomeHandler someHandler) {
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

    public interface SomeHandler {
        void handle();
    }
}
