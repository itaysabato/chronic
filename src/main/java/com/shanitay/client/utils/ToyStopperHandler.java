package com.shanitay.client.utils;

/**
* Created By: Itay Sabato<br/>
* Date: 17/06/12 <br/>
* Time: 03:14 <br/>
*/
public class ToyStopperHandler implements Utils.SomeHandler {
    private final Toy toy;

    public ToyStopperHandler(Toy toy) {
        this.toy = toy;
    }

    public void handle() {
        toy.stop();
    }
}
