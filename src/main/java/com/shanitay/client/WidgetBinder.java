package com.shanitay.client;

import com.allen_sauer.gwt.voices.client.Sound;
import com.allen_sauer.gwt.voices.client.SoundController;
import com.google.gwt.dom.client.Style;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import org.vectomatic.dom.svg.OMSVGAnimationElement;
import org.vectomatic.dom.svg.OMSVGGElement;
import org.vectomatic.dom.svg.OMSVGSVGElement;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * Created By: Itay Sabato<br/>
 * Date: 12/05/12 <br/>
 * Time: 15:57 <br/>
 */
public class WidgetBinder {
    private final OMSVGSVGElement svgElement;
    private final SoundController soundController;

    public WidgetBinder(OMSVGSVGElement svgElement, SoundController soundController) {
        this.svgElement = svgElement;
        this.soundController = soundController;
    }

    public OMSVGGElement bindWidget(String elementId, String soundUrl, Set<String> animationIds, TriggerHandler triggerHandler, float duration){
        final Sound sound = Utils.getSound(soundUrl, soundController);
        final OMSVGGElement gElement = Utils.getGElement(elementId, svgElement);
        final MyHandler handler = new MyHandler(sound, triggerHandler, gElement);

        for (String animationId : animationIds) {
            final OMSVGAnimationElement animationElement = (OMSVGAnimationElement) Utils.getElement(animationId,  svgElement);
            animationElement.setAttribute("dur", String.valueOf(duration));
            handler.getAnimations().add(animationElement);
        }

        Utils.addHandler(gElement, new Utils.SomeHandler() {
            public void handle() {
                handler.onClick(null);
            }
        });
        gElement.getElement().getStyle().setCursor(Style.Cursor.POINTER);
        return gElement;
    }

    public OMSVGGElement bindWidget(String elementId, String soundUrl, TriggerHandler triggerHandler) {
       return bindWidget(elementId, soundUrl, Collections.<String>emptySet(), triggerHandler, 0);
    }

    private static class MyHandler implements ClickHandler {
        private final Sound sound;
        private final TriggerHandler triggerHandler;
        private final OMSVGGElement gElement;
        private final List<OMSVGAnimationElement> animations;

        public MyHandler(Sound sound, TriggerHandler triggerHandler, OMSVGGElement gElement) {
            this.sound = sound;
            this.triggerHandler = triggerHandler;
            this.gElement = gElement;
            animations = new LinkedList<OMSVGAnimationElement>();
        }

        public List<OMSVGAnimationElement> getAnimations() {
            return animations;
        }

        public void onClick(ClickEvent event) {
            boolean played;
            do {
                played = sound.play();
            }
            while (!played);

            if (triggerHandler != null) {
                triggerHandler.triggerAnimation(gElement);
            }

            for (OMSVGAnimationElement animation : animations) {
                animation.beginElement();
            }
        }
    }

    public interface TriggerHandler {
        void triggerAnimation(OMSVGGElement target);
    }

}
