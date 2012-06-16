package com.shanitay.client.utils.animations;

import com.shanitay.client.utils.Toy;

/**
* Created By: Itay Sabato<br/>
* Date: 20/05/12 <br/>
* Time: 04:12 <br/>
*/
public class ScheduledAnimation {
    private final Toy.Animation animation;
    private final int startTimeMillis;

    public ScheduledAnimation(Toy.Animation animation, int startTimeMillis) {
        this.animation = animation;
        this.startTimeMillis = startTimeMillis;
    }

    public Toy.Animation getAnimation() {
        return animation;
    }

    public int getStartTimeMillis() {
        return startTimeMillis;
    }
}
