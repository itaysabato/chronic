package com.shanitay.client.utils;

/**
 * Created By: Itay Sabato<br/>
 * Date: 03/06/12 <br/>
 * Time: 00:43 <br/>
 */
public class HandlerToyAnimation implements Toy.Animation {
    private final Utils.SomeHandler handler;

    public HandlerToyAnimation(Utils.SomeHandler handler) {
        this.handler = handler;
    }

    public void setLooping(boolean looping) {
        // ignore
    }

    public void play() {
        handler.handle();
    }

    public void stop() {
        handler.handle();
    }
}
