package com.shanitay.client.utils;

import com.google.gwt.core.client.Scheduler;
import org.vectomatic.dom.svg.OMSVGElement;

/**
 * Created By: Itay Sabato<br/>
 * Date: 17/05/12 <br/>
 * Time: 21:35 <br/>
 */
public class PeekabooToyAnimation implements Toy.Animation {
    private final StateChangeAnimator kind;
    private final int durationMillis;
    private final OMSVGElement target;

    private boolean looping = false;
    private boolean stopping = false;

    public PeekabooToyAnimation(StateChangeAnimator kind, int durationMillis, OMSVGElement target) {
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

}
