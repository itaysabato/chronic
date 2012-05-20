package com.shanitay.client.robot;

import com.shanitay.client.utils.AnimatorImpls;
import com.shanitay.client.utils.FillColorAnimator;
import com.shanitay.client.utils.PeekabooToyAnimation;
import com.shanitay.client.utils.SequenceToyAnimation;

/**
 * Created By: Itay Sabato<br/>
 * Date: 17/05/12 <br/>
 * Time: 20:05 <br/>
 */
class AnimationLoader {

    private static final int TOOTH_DURATION = 500;
    private static final int EARS_DURATION = 500;
    private static final int ELECTRIC_DURATION = 125;

    private final ElementLoader elementLoader;
    final PeekabooToyAnimation tooth1;
    final PeekabooToyAnimation tooth2;
    final PeekabooToyAnimation tooth3;
    final PeekabooToyAnimation tooth4;
    final PeekabooToyAnimation tooth5;
    final PeekabooToyAnimation tooth6;
    final SequenceToyAnimation electric;
    final PeekabooToyAnimation earLeft;
    final PeekabooToyAnimation earRight;

    public AnimationLoader(ElementLoader elementLoader) {
        this.elementLoader = elementLoader;

        tooth1 = new PeekabooToyAnimation(AnimatorImpls.DISAPPEAR, TOOTH_DURATION, elementLoader.tooth1);
        tooth2 = new PeekabooToyAnimation(AnimatorImpls.DISAPPEAR, TOOTH_DURATION, elementLoader.tooth2);
        tooth3 = new PeekabooToyAnimation(AnimatorImpls.DISAPPEAR, TOOTH_DURATION, elementLoader.tooth3);
        tooth4 = new PeekabooToyAnimation(AnimatorImpls.DISAPPEAR, TOOTH_DURATION, elementLoader.tooth4);
        tooth5 = new PeekabooToyAnimation(AnimatorImpls.DISAPPEAR, TOOTH_DURATION, elementLoader.tooth5);
        tooth6 = new PeekabooToyAnimation(AnimatorImpls.DISAPPEAR, TOOTH_DURATION, elementLoader.tooth6);

        electric = createElectric();

        final FillColorAnimator earsAnimator = new FillColorAnimator("#1F9C8D", "#EAE984");
        earLeft = new PeekabooToyAnimation(earsAnimator, EARS_DURATION, elementLoader.earLeft);
        earRight = new PeekabooToyAnimation(earsAnimator, EARS_DURATION, elementLoader.earRight);
    }

    private SequenceToyAnimation createElectric() {
        final SequenceToyAnimation.ScheduledAnimation scheduledWhite1 = getScheduledWhite(elementLoader, 0);

        final PeekabooToyAnimation electricBlackAnimation = new PeekabooToyAnimation(AnimatorImpls.APPEAR, ELECTRIC_DURATION, elementLoader.electricBlack);
        final SequenceToyAnimation.ScheduledAnimation scheduledBlack1 = getScheduledBlack(ELECTRIC_DURATION, electricBlackAnimation);
        final SequenceToyAnimation.ScheduledAnimation scheduledBlack2 = getScheduledBlack((3 * ELECTRIC_DURATION), electricBlackAnimation);
        final SequenceToyAnimation.ScheduledAnimation scheduledBlack3 = getScheduledBlack((5 * ELECTRIC_DURATION), electricBlackAnimation);

        return new SequenceToyAnimation(scheduledWhite1, scheduledBlack1, scheduledBlack2, scheduledBlack3);
    }

    private SequenceToyAnimation.ScheduledAnimation getScheduledWhite(ElementLoader elementLoader, int startTimeMillis) {
        final PeekabooToyAnimation electricWhite = new PeekabooToyAnimation(AnimatorImpls.APPEAR, 7 * ELECTRIC_DURATION, elementLoader.electricWhite);
        return new SequenceToyAnimation.ScheduledAnimation(electricWhite, startTimeMillis);
    }

    private SequenceToyAnimation.ScheduledAnimation getScheduledBlack(int startTimeMillis, PeekabooToyAnimation peekabooToyAnimation) {
        return new SequenceToyAnimation.ScheduledAnimation(peekabooToyAnimation, startTimeMillis);
    }
}
