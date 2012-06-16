package com.shanitay.client.main;

import com.shanitay.client.utils.Toy;
import org.vectomatic.dom.svg.OMSVGAnimationElement;
import org.vectomatic.dom.svg.events.EndEvent;
import org.vectomatic.dom.svg.events.EndHandler;

/**
* Created By: Itay Sabato<br/>
* Date: 16/06/12 <br/>
* Time: 21:55 <br/>
*/
class ChainedSvgAnimation implements Toy.Animation {
    private final OMSVGAnimationElement firstAnimation;

    private boolean looping;
    private boolean playing;
    private boolean stopping;

    public ChainedSvgAnimation(OMSVGAnimationElement firstAnimation, OMSVGAnimationElement lastAnimation) {
        this.firstAnimation = firstAnimation;

        lastAnimation.addEndHandler(new EndHandler() {
            public void onEnd(EndEvent event) {
                if(looping && !stopping){
                    ChainedSvgAnimation.this.firstAnimation.beginElement();
                }
                else {
                    playing = false;
                    stopping = false;
                }
            }
        });

        looping = false;
        playing = false;
        stopping = false;
    }

    public void setLooping(boolean looping) {
        this.looping = looping;
    }

    public void play() {
        if(!playing) {
            playing = true;
            stopping = false;
            firstAnimation.beginElement();
        }
        else {
            stopping = false;
        }
    }

    public void stop() {
        stopping = true;
    }
}
