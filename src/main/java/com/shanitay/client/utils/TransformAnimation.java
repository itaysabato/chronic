package com.shanitay.client.utils;

import org.vectomatic.dom.svg.OMSVGGElement;

/**
 * Created By: Itay Sabato<br/>
 * Date: 14/05/12 <br/>
 * Time: 00:42 <br/>
 */
public class TransformAnimation implements Toy.Animation {
    private final float initX;
    private final float initY;
    private final float finalX;
    private final float finalY;
    private final int durationMillis;
    private final OMSVGGElement gElement;

    public TransformAnimation(float initX, float initY, float finalX, float finalY, int durationMillis, OMSVGGElement gElement) {
        this.initX = initX;
        this.initY = initY;
        this.finalX = finalX;
        this.finalY = finalY;
        this.durationMillis = durationMillis;
        this.gElement = gElement;
    }

    public void setLooping(boolean looping) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    public void play() {
        Utils.translate(gElement, initX, initY);
//        Scheduler.get().scheduleFixedDelay();
    }

    public void stop() {
        //To change body of implemented methods use File | Settings | File Templates.
    }
}
