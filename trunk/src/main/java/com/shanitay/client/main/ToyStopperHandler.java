package com.shanitay.client.main;

import com.shanitay.client.utils.Toy;
import com.shanitay.client.utils.Utils;

/**
* Created By: Itay Sabato<br/>
* Date: 17/06/12 <br/>
* Time: 03:14 <br/>
*/
class ToyStopperHandler implements Utils.SomeHandler {
    private final Toy toy;

    public ToyStopperHandler(Toy toy) {
        this.toy = toy;
    }

    public void handle() {
        toy.stop();
    }
}
