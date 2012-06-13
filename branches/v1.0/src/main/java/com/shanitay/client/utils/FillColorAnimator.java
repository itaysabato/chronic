package com.shanitay.client.utils;

import org.vectomatic.dom.svg.OMSVGElement;

/**
 * Created By: Itay Sabato<br/>
 * Date: 20/05/12 <br/>
 * Time: 02:40 <br/>
 */
public class FillColorAnimator implements StateChangeAnimator {
    private final String initialColor;
    private final String animationColor;

    public FillColorAnimator(String initialColor, String animationColor) {
        this.initialColor = initialColor;
        this.animationColor = animationColor;
    }

    public void inAnimation(OMSVGElement target) {
        target.setAttribute("fill", animationColor);
    }

    public void offAnimation(OMSVGElement target) {
        target.setAttribute("fill", initialColor);
    }
}
