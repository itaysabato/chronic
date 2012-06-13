package com.shanitay.client.utils;

import com.google.gwt.core.client.Scheduler;
import org.vectomatic.dom.svg.OMSVGGElement;

import java.util.Arrays;
import java.util.List;

/**
 * Created By: Itay Sabato<br/>
 * Date: 13/05/12 <br/>
 * Time: 03:23 <br/>
 */
public class DiscoToyAnimation implements Toy.Animation {

    private boolean looping = false;
    private boolean stopping = false;

    private final int interval;
    private final boolean hideBase;
    private final List<OMSVGGElement> layers;
    private final StateChangeAnimator animator;

    public DiscoToyAnimation(boolean hideBase, StateChangeAnimator animator, int interval, OMSVGGElement... layers) {
        this(hideBase, animator, interval, Arrays.asList(layers));
    }

    public DiscoToyAnimation(StateChangeAnimator animator, int interval, OMSVGGElement... layers) {
        this(false, animator, interval, Arrays.asList(layers));
    }

    public DiscoToyAnimation(boolean hideBase, StateChangeAnimator animator, int interval, List<OMSVGGElement> layers) {
        this.hideBase = hideBase;
        this.animator = animator;
        this.layers = layers;
        this.interval = interval;
    }

    public void setLooping(boolean looping) {
        this.looping = looping;
    }

    public void play() {
        stopping = false;
        disco();

        Scheduler.get().scheduleFixedDelay(new Scheduler.RepeatingCommand() {
            public boolean execute() {
                if (looping && !stopping) {
                    disco();
                    return true;
                }
                return false;
            }
        }, durationMs());
    }

    private int durationMs() {
        return ((layers.size() * 2) - 1) * interval;
    }

    private void disco() {
        Utils.animateFor(animator, layers.get(0), hideBase ? durationMs() - interval : durationMs());

        for(int i = 1; i < layers.size(); i++){
            final int finalI = i;

            Scheduler.get().scheduleFixedDelay(new Scheduler.RepeatingCommand() {
                public boolean execute() {
                    Utils.animateFor(animator, layers.get(finalI), durationMs() - (2*interval* finalI));
                    return false;
                }
            }, finalI*interval);
        }
    }

    public void stop() {
        stopping = true;
    }
}
