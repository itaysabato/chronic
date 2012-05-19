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
    private final List<OMSVGGElement> layers;

    public DiscoToyAnimation(int interval, OMSVGGElement... layers) {
        this(interval, Arrays.asList(layers));
    }

    public DiscoToyAnimation(int interval, List<OMSVGGElement> layers) {
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
        Utils.hideFor(layers.get(0), durationMs());

        for(int i = 1; i < layers.size(); i++){
            final int finalI = i;

            Scheduler.get().scheduleFixedDelay(new Scheduler.RepeatingCommand() {
                public boolean execute() {
                    Utils.hideFor(layers.get(finalI), durationMs() - (2*interval* finalI));
                    return false;
                }
            }, finalI*interval);
        }
    }

    public void stop() {
        stopping = true;
    }
}
