package com.shanitay.client.robot;

import com.shanitay.client.utils.PeekabooToyAnimation;

/**
 * Created By: Itay Sabato<br/>
 * Date: 17/05/12 <br/>
 * Time: 20:05 <br/>
 */
class AnimationLoader {

    public static final int TOOTH_DURATION = 500;
    final PeekabooToyAnimation tooth1;
    final PeekabooToyAnimation tooth2;
    final PeekabooToyAnimation tooth3;
    final PeekabooToyAnimation tooth4;
    final PeekabooToyAnimation tooth5;
    final PeekabooToyAnimation tooth6;

    public AnimationLoader(ElementLoader elementLoader) {
        tooth1 = new PeekabooToyAnimation(PeekabooToyAnimation.Kind.DISAPPEAR, TOOTH_DURATION, elementLoader.tooth1);
        tooth2 = new PeekabooToyAnimation(PeekabooToyAnimation.Kind.DISAPPEAR, TOOTH_DURATION, elementLoader.tooth2);
        tooth3 = new PeekabooToyAnimation(PeekabooToyAnimation.Kind.DISAPPEAR, TOOTH_DURATION, elementLoader.tooth3);
        tooth4 = new PeekabooToyAnimation(PeekabooToyAnimation.Kind.DISAPPEAR, TOOTH_DURATION, elementLoader.tooth4);
        tooth5 = new PeekabooToyAnimation(PeekabooToyAnimation.Kind.DISAPPEAR, TOOTH_DURATION, elementLoader.tooth5);
        tooth6 = new PeekabooToyAnimation(PeekabooToyAnimation.Kind.DISAPPEAR, TOOTH_DURATION, elementLoader.tooth6);
    }
}
