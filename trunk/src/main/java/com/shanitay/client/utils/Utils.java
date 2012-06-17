package com.shanitay.client.utils;

import com.allen_sauer.gwt.voices.client.Sound;
import com.allen_sauer.gwt.voices.client.SoundController;
import com.allen_sauer.gwt.voices.client.handler.SoundHandler;
import com.google.gwt.core.client.Scheduler;
import com.google.gwt.dom.client.Element;
import com.google.gwt.dom.client.Style;
import com.google.gwt.user.client.Event;
import com.google.gwt.user.client.EventListener;
import com.shanitay.client.utils.animations.StateChangeAnimator;
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
    public static final int TIME_UNIT = 41;
//    public static final String EVENT = "mousedown";
    public static final String EVENT = "MozTouchDown";

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

    public static void addHandler(OMSVGElement element, final SomeHandler someHandler) {
        addEventListener(element.getElement(), EVENT, new EventListener() {
            public void onBrowserEvent(Event event) {
                event.preventDefault();
                someHandler.handle();
            }
        }, false);

//        return element.addTouchStartHandler(new TouchStartHandler() {
//            public void onTouchStart(TouchStartEvent event) {
//                event.preventDefault();
//                someHandler.handle();
//            }
//        });

//        return element.addMouseDownHandler(new MouseDownHandler() {
//            public void onMouseDown(MouseDownEvent event) {
//                event.preventDefault();
//                someHandler.handle();
//            }
//        });

//        return element.addClickHandler(new ClickHandler() {
//            public void onClick(ClickEvent event) {
//                event.preventDefault();
//                someHandler.handle();
//            }
//        });

//        element.getElement().getStyle().setCursor(Style.Cursor.POINTER);
    }

    public static native void addEventListener(Element element, String event, EventListener listener, boolean capture)
        /*-{
            element.addEventListener(
                    event,
                    function (e) {
                        listener.@com.google.gwt.user.client.EventListener::onBrowserEvent(Lcom/google/gwt/user/client/Event;)(e);
                    },
                    capture);
        }-*/;

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

    public static void rotate(OMSVGGElement gElement, float angle, float cx, float cy) {
        gElement.setAttribute("transform", "rotate(" + angle + "," + cx + "," + cy + ")");
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

    public static Toy attachToy(OMSVGElement element, Sound sound, boolean looping, Toy.Animation... animations) {
        final Toy toy = new Toy(sound, animations);
        toy.setLooping(looping);

        return attachToy(element, toy);
    }

    public static Toy attachToy(OMSVGElement element, final Toy toy) {
        if(!toy.isLooping()) {
            LoopRecorderFactory.register(toy);
        }

        addHandler(element, new SomeHandler() {
            public void handle() {
                toy.toggle();
                if(LoopRecorderFactory.hasRecorder()) {
                    LoopRecorderFactory.getRecorder().record(toy);
                }
            }
        });

        return toy;
    }

    public static double getAngle(OMSVGPoint p1, OMSVGPoint p2) {
        double v1 = Math.atan2(p1.getY(), p1.getX());
        double v2 = Math.atan2(p2.getY(), p2.getX());
        double v = v1 - v2;
        return Math.toDegrees(v);
    }

    public static void createToggleButton(OMSVGElement element, final SomeHandler offHandler, final SomeHandler onHandler) {
        addHandler(element, new SomeHandler() {
            private boolean on = false;

            public void handle() {
                if(on){
                    onHandler.handle();
                }
                else {
                    offHandler.handle();
                }
                on = !on;
            }
        });
    }

    public static Sound getNullSound() {
        return new Sound() {

            public int getBalance() {
                return 0;  //To change body of implemented methods use File | Settings | File Templates.
            }

            public LoadState getLoadState() {
                return null;  //To change body of implemented methods use File | Settings | File Templates.
            }

            public boolean getLooping() {
                return false;  //To change body of implemented methods use File | Settings | File Templates.
            }

            public String getMimeType() {
                return null;  //To change body of implemented methods use File | Settings | File Templates.
            }

            public String getSoundType() {
                return null;  //To change body of implemented methods use File | Settings | File Templates.
            }

            public String getUrl() {
                return null;  //To change body of implemented methods use File | Settings | File Templates.
            }

            public int getVolume() {
                return 0;  //To change body of implemented methods use File | Settings | File Templates.
            }

            public boolean play() {
                return false;  //To change body of implemented methods use File | Settings | File Templates.
            }

            public void setBalance(int balance) {
                //To change body of implemented methods use File | Settings | File Templates.
            }

            public void setLooping(boolean looping) {
                //To change body of implemented methods use File | Settings | File Templates.
            }

            public void setVolume(int volume) {
                //To change body of implemented methods use File | Settings | File Templates.
            }

            public void stop() {
                //To change body of implemented methods use File | Settings | File Templates.
            }

            public void addEventHandler(SoundHandler handler) {
                //To change body of implemented methods use File | Settings | File Templates.
            }

            public void removeEventHandler(SoundHandler handler) {
                //To change body of implemented methods use File | Settings | File Templates.
            }
        };
    }

    public static void stopAnimation(OMSVGAnimationElement svgAnimationElement) {
        svgAnimationElement.beginElement();
        svgAnimationElement.endElementAt(0.01f);
    }

    public interface SomeHandler {
        void handle();
    }
}
