package com.shanitay.client.utils;

/**
 * Created By: Itay Sabato<br/>
 * Date: 02/06/12 <br/>
 * Time: 16:59 <br/>
 */
public class ToyEvent {
    private final long timestampMillis;
    private final Toy target;

    public ToyEvent(long timestampMillis, Toy target) {
        this.timestampMillis = timestampMillis;
        this.target = target;
    }

    public long getTimestampMillis() {
        return timestampMillis;
    }

    public Toy getTarget() {
        return target;
    }
}
