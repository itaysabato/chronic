package com.shanitay.client.utils.animations;

import com.google.gwt.animation.client.AnimationScheduler;
import com.shanitay.client.utils.Toy;
import com.shanitay.client.utils.Utils;
import org.vectomatic.dom.svg.OMSVGGElement;

/**
 * Created By: Itay Sabato<br/>
 * Date: 17/05/12 <br/>
 * Time: 22:21 <br/>
 */
public class MovingToyAnimation implements Toy.Animation {

    private final boolean rewind;
    private double start;
    private final double duration;
    private final OMSVGGElement target;
    private final MovementEquation equationX;
    private final MovementEquation equationY;

    private double dt = 0;
    private boolean looping = false;
    private AnimationScheduler.AnimationHandle animationHandle;

    public MovingToyAnimation(int timeUnit, int numSteps, MovementEquation equationX, MovementEquation equationY, OMSVGGElement target, boolean rewind) {
        this(numSteps * timeUnit, equationX, equationY, target, rewind);
    }

    public MovingToyAnimation(double duration, MovementEquation equationX, MovementEquation equationY, OMSVGGElement target, boolean rewind) {
        this.target = target;
        this.rewind = rewind;
        this.duration = duration;
        this.equationX = equationX;
        this.equationY = equationY;
    }

    public void setLooping(boolean looping) {
        this.looping = looping;
    }

    public void play() {
        stop();
        animationHandle = AnimationScheduler.get().requestAnimationFrame(new MyAnimationCallback(), target.getElement());
    }

    private void cancel() {
        if (animationHandle != null) {
            animationHandle.cancel();
            animationHandle = null;
        }
    }

    private void reset() {
        dt = 0;
        start = System.currentTimeMillis();
        translate();
    }

    private void translate() {
        double dtPrime = dt;

        if(rewind){
            double middle = duration / 2;
            if(dt > middle){
                dtPrime = (2*middle) - dt;
            }
        }

        final double translationX = equationX.getTranslation(dtPrime);
        final double translationY = equationY.getTranslation(dtPrime);
        Utils.translate(target, (float) translationX, (float) translationY);
    }

    public void stop() {
        cancel();
        reset();
    }

    private class MyAnimationCallback implements AnimationScheduler.AnimationCallback {

        public void execute(double timestamp) {
            dt = timestamp - start;

            if (dt >= duration) {
                reset();
                if(looping){
                    animationHandle = AnimationScheduler.get().requestAnimationFrame(this, target.getElement());
                }
            }
            else {
                translate();
                animationHandle = AnimationScheduler.get().requestAnimationFrame(this, target.getElement());
            }
        }
    }
}
