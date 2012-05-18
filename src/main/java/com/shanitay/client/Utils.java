package com.shanitay.client;

import com.allen_sauer.gwt.voices.client.Sound;
import com.allen_sauer.gwt.voices.client.SoundController;
import com.allen_sauer.gwt.voices.client.handler.SoundHandler;
import com.chj.gwt.client.soundmanager2.SoundManager;
import com.google.gwt.core.client.Scheduler;
import com.google.gwt.dom.client.Style;
import com.google.gwt.event.dom.client.MouseDownEvent;
import com.google.gwt.event.dom.client.MouseDownHandler;
import org.vectomatic.dom.svg.OMNode;
import org.vectomatic.dom.svg.OMSVGElement;
import org.vectomatic.dom.svg.OMSVGGElement;
import org.vectomatic.dom.svg.OMSVGSVGElement;
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

        element.getElement().getStyle().setCursor(Style.Cursor.POINTER);
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

    private static int counter = 0;
    public static Sound getSound(final String soundUrl, SoundController soundController) {
        final SoundManager soundManager = SoundManager.quickStart();
        final String id = "sound" + counter;
        counter++;
        soundManager.createSound(id, soundUrl);

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
                soundManager.play(id);
                return true;
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
                soundManager.stop(id);
            }

            public void addEventHandler(SoundHandler handler) {
                //To change body of implemented methods use File | Settings | File Templates.
            }

            public void removeEventHandler(SoundHandler handler) {
                //To change body of implemented methods use File | Settings | File Templates.
            }
        };
//        return soundController.createSound(Sound.MIME_TYPE_AUDIO_MPEG_MP3, soundUrl, true, false);
    }
    public interface SomeHandler {
        void handle();
    }
}
