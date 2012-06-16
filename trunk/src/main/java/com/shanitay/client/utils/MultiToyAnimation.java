package com.shanitay.client.utils;

import java.util.Arrays;
import java.util.List;

/**
 * Created By: Itay Sabato<br/>
 * Date: 16/06/12 <br/>
 * Time: 07:04 <br/>
 */
public class MultiToyAnimation implements Toy.Animation {
    private final List<Toy.Animation> animations;

    public MultiToyAnimation(Toy.Animation... animations) {
        this(Arrays.asList(animations));
    }

    public MultiToyAnimation(List<Toy.Animation> animations) {
        this.animations = animations;
    }

    public void setLooping(boolean looping) {
        for (Toy.Animation animation : animations) {
            animation.setLooping(looping);
        }
    }

    public void play() {
        for (Toy.Animation animation : animations) {
            animation.play();
        }
    }

    public void stop() {
        for (Toy.Animation animation : animations) {
            animation.stop();
        }
    }
}
