package com.shanitay.client.utils;

import org.vectomatic.dom.svg.OMSVGAnimationElement;

/**
 * Created By: Itay Sabato<br/>
 * Date: 13/05/12 <br/>
 * Time: 02:16 <br/>
 */
public class SvgToyAnimation implements Toy.Animation {
    private final OMSVGAnimationElement svgAnimationElement;

    public SvgToyAnimation(OMSVGAnimationElement svgAnimationElement) {
        this.svgAnimationElement = svgAnimationElement;
    }

    public void setLooping(boolean looping) {
        final String repeatCount = looping ? "indefinite" : "1";
        svgAnimationElement.setAttribute("repeatCount", repeatCount);
    }

    public void play() {
        svgAnimationElement.beginElement();
    }

    public void stop() {
        svgAnimationElement.beginElement();
        svgAnimationElement.endElementAt(0.01f);
    }

    public OMSVGAnimationElement getSvgAnimationElement() {
        return svgAnimationElement;
    }
}
