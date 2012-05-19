package com.shanitay.client.robot;

import com.shanitay.client.utils.PeekabooToyAnimation;
import com.shanitay.client.utils.SequenceToyAnimation;

/**
 * Created By: Itay Sabato<br/>
 * Date: 17/05/12 <br/>
 * Time: 20:05 <br/>
 */
class AnimationLoader {

    public static final int TOOTH_DURATION = 500;
    private static final int ELECTRIC_DURATION = 500;

    final PeekabooToyAnimation tooth1;
    final PeekabooToyAnimation tooth2;
    final PeekabooToyAnimation tooth3;
    final PeekabooToyAnimation tooth4;
    final PeekabooToyAnimation tooth5;
    final PeekabooToyAnimation tooth6;
    final SequenceToyAnimation electric;

    public AnimationLoader(ElementLoader elementLoader) {
        tooth1 = new PeekabooToyAnimation(PeekabooToyAnimation.Kind.DISAPPEAR, TOOTH_DURATION, elementLoader.tooth1);
        tooth2 = new PeekabooToyAnimation(PeekabooToyAnimation.Kind.DISAPPEAR, TOOTH_DURATION, elementLoader.tooth2);
        tooth3 = new PeekabooToyAnimation(PeekabooToyAnimation.Kind.DISAPPEAR, TOOTH_DURATION, elementLoader.tooth3);
        tooth4 = new PeekabooToyAnimation(PeekabooToyAnimation.Kind.DISAPPEAR, TOOTH_DURATION, elementLoader.tooth4);
        tooth5 = new PeekabooToyAnimation(PeekabooToyAnimation.Kind.DISAPPEAR, TOOTH_DURATION, elementLoader.tooth5);
        tooth6 = new PeekabooToyAnimation(PeekabooToyAnimation.Kind.DISAPPEAR, TOOTH_DURATION, elementLoader.tooth6);

        final SequenceToyAnimation.ScheduledAnimation scheduledWhite1 = getScheduledWhite(elementLoader, 0);

        final PeekabooToyAnimation electricBlackAnimation = new PeekabooToyAnimation(PeekabooToyAnimation.Kind.APPEAR, ELECTRIC_DURATION, elementLoader.electricBlack);
        final SequenceToyAnimation.ScheduledAnimation scheduledBlack1 = getScheduledBlack(ELECTRIC_DURATION, electricBlackAnimation);
        final SequenceToyAnimation.ScheduledAnimation scheduledBlack2 = getScheduledBlack((3 * ELECTRIC_DURATION), electricBlackAnimation);
        final SequenceToyAnimation.ScheduledAnimation scheduledBlack3 = getScheduledBlack((5 * ELECTRIC_DURATION), electricBlackAnimation);

        electric = new SequenceToyAnimation(scheduledWhite1, scheduledBlack1, scheduledBlack2, scheduledBlack3);
    }

    private SequenceToyAnimation.ScheduledAnimation getScheduledWhite(ElementLoader elementLoader, int startTimeMillis) {
        final PeekabooToyAnimation electricWhite = new PeekabooToyAnimation(PeekabooToyAnimation.Kind.APPEAR, 7 * ELECTRIC_DURATION, elementLoader.electricWhite);
        return new SequenceToyAnimation.ScheduledAnimation(electricWhite, startTimeMillis);
    }

    private SequenceToyAnimation.ScheduledAnimation getScheduledBlack(int startTimeMillis, PeekabooToyAnimation peekabooToyAnimation) {
        return new SequenceToyAnimation.ScheduledAnimation(peekabooToyAnimation, startTimeMillis);
    }
}
