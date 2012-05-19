package com.shanitay.client.utils;

import com.google.gwt.core.client.Scheduler;
import org.vectomatic.dom.svg.OMSVGGElement;

/**
 * Created By: Itay Sabato<br/>
 * Date: 17/05/12 <br/>
 * Time: 22:21 <br/>
 */
public class MovingToyAnimation implements Toy.Animation {
    private final int timeUnit;
    private final int numSteps;
    private final boolean rewind;
    private final OMSVGGElement target;
    private final MovementEquation equationX;
    private final MovementEquation equationY;

    private int dt = 0;
    private boolean looping = false;
    private boolean stopping = false;
    private MyRepeatingCommand command = new MyRepeatingCommand();

    public MovingToyAnimation(int timeUnit, int numSteps, MovementEquation equationX, MovementEquation equationY, OMSVGGElement target, boolean rewind) {
        this.target = target;
        this.rewind = rewind;
        this.numSteps = numSteps;
        this.timeUnit = timeUnit;
        this.equationX = equationX;
        this.equationY = equationY;
    }

    public void setLooping(boolean looping) {
        this.looping = looping;
    }

    public void play() {
        reset();
        if(!command.repeat){
            Scheduler.get().scheduleFixedDelay(command, timeUnit);
        }
    }

    private void reset() {
        dt = 0;
        stopping = false;
        translate();
    }

    private void translate() {
        int dtPrime = dt;

        if(rewind){
            int middle = numSteps / 2;
            if(dt > middle){
                dtPrime = (2*middle) - dt;
            }
        }

        final float translationX = equationX.getTranslation(dtPrime);
        final float translationY = equationY.getTranslation(dtPrime);
        Utils.translate(target, translationX, translationY);
    }

    public void stop() {
        stopping = true;
    }

    private class MyRepeatingCommand implements Scheduler.RepeatingCommand {
        private boolean repeat = false;

        public boolean execute() {
            if((!looping && dt == numSteps - 1) || stopping){
                reset();
                repeat = false;
                return false;
            }

            dt = (dt + 1) % numSteps;
            translate();
            repeat = true;
            return true;
        }
    }
}
