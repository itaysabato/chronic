package com.shanitay.client.utils;

import com.google.gwt.core.client.Scheduler;
import org.vectomatic.dom.svg.OMSVGGElement;

/**
 * Created By: Itay Sabato<br/>
 * Date: 17/05/12 <br/>
 * Time: 21:35 <br/>
 */
public class PeekabooToyAnimation implements Toy.Animation {
    private final Kind kind;
    private final int durationMillis;
    private final OMSVGGElement target;

    private boolean looping = false;
    private boolean stopping = false;

    public PeekabooToyAnimation(Kind kind, int durationMillis, OMSVGGElement target) {
        this.kind = kind;
        this.durationMillis = durationMillis;
        this.target = target;

        kind.offAnimation(target);
    }

    public void setLooping(boolean looping) {
        this.looping = looping;
    }

    public void play() {
        stopping = false;
        kind.inAnimation(target);

        final Scheduler.RepeatingCommand cmd = new Scheduler.RepeatingCommand() {
            public boolean execute() {
                if (!looping || stopping) {
                    kind.offAnimation(target);
                    return false;
                }
                else {
                    return true;
                }
            }
        };
        Scheduler.get().scheduleFixedDelay(cmd, durationMillis);
    }

    public void stop() {
        stopping = true;
    }

    public static enum Kind {
       APPEAR {
           @Override
           protected void inAnimation(OMSVGGElement target) {
               Utils.show(target);
           }

           @Override
           protected void offAnimation(OMSVGGElement target) {
               Utils.hide(target);
           }
       },

       DISAPPEAR {
           @Override
           protected void inAnimation(OMSVGGElement target) {
               Utils.hide(target);
           }

           @Override
           protected void offAnimation(OMSVGGElement target) {
               Utils.show(target);
           }
       };

        protected abstract void inAnimation(OMSVGGElement target);
        protected abstract void offAnimation(OMSVGGElement target);
    }
}
