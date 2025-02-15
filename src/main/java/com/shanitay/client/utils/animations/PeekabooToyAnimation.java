package com.shanitay.client.utils.animations;

import com.google.gwt.core.client.Scheduler;
import com.shanitay.client.utils.Toy;
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
    private boolean on = false;

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
        on = true;
        kind.inAnimation(target);

        final Scheduler.RepeatingCommand cmd = new Scheduler.RepeatingCommand() {
            public boolean execute() {
                if (!looping || stopping) {
                    kind.offAnimation(target);
                    return false;
                }
                else {
                    if(on){
                        kind.offAnimation(target);
                    }
                    else {
                        kind.inAnimation(target);
                    }
                    on = !on;
                    return true;
                }
            }
        };
        Scheduler.get().scheduleFixedDelay(cmd, durationMillis);
    }

    public void stop() {
        stopping = true;
        on = false;
    }

}
