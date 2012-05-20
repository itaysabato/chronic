package com.shanitay.client.robot;

import com.shanitay.client.utils.*;

/**
 * Created By: Itay Sabato<br/>
 * Date: 17/05/12 <br/>
 * Time: 20:05 <br/>
 */
class AnimationLoader {

    private static final int BG_INTERVAL = 125;
    private static final int TOOTH_DURATION = 500;
    private static final int ELECTRIC_DURATION = 125;
    private static final int LIGHTNING_DURATION = 500;
    private static final int RIGHT_EAR_DURATION = 500;
    private static final int PUMP_LIGHT_DURATION = 500;
    private static final int COOP_CENTER_DURATION = 250;
    private final ElementLoader elementLoader;

    final Toy.Animation tooth1;
    final Toy.Animation tooth2;
    final Toy.Animation tooth3;
    final Toy.Animation tooth4;
    final Toy.Animation tooth5;
    final Toy.Animation tooth6;
    final Toy.Animation electric;
    final Toy.Animation earLeft;
    final Toy.Animation earRight;
    final Toy.Animation coopCenter;
    final Toy.Animation coopBg;
    final Toy.Animation pumpLight;
    private final PeekabooToyAnimation smallLightning;

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
        earRight = new PeekabooToyAnimation(earsAnimator, RIGHT_EAR_DURATION, elementLoader.earRight);

        final MovementEquation earEquationX = new MovementEquation(0, -13);
        final MovementEquation earEquationY = new MovementEquation(0, 0);
        earLeft = new MovingToyAnimation(Utils.TIME_UNIT, 24, earEquationX, earEquationY, elementLoader.earHandle, true);

        final FillColorAnimator coopCenterAnimator = new FillColorAnimator("#173434", "#EAE984");
        coopCenter = new PeekabooToyAnimation(coopCenterAnimator, COOP_CENTER_DURATION, elementLoader.coopButtonCenter);
        coopBg = new DiscoToyAnimation(AnimatorImpls.APPEAR, BG_INTERVAL, elementLoader.bgCoop1, elementLoader.bgCoop2, elementLoader.bgCoop3);

        final FillColorAnimator pumpLightAnimator = new FillColorAnimator("#EAE984", "#F2B1B6");
        pumpLight = new PeekabooToyAnimation(pumpLightAnimator, PUMP_LIGHT_DURATION, elementLoader.pumpLight);
        pumpLight.setLooping(true);
        pumpLight.play();

        smallLightning = new PeekabooToyAnimation(AnimatorImpls.DISAPPEAR, LIGHTNING_DURATION, elementLoader.smallLightning);
        smallLightning.setLooping(true);
        smallLightning.play();
    }

    private SequenceToyAnimation createElectric() {
        final ScheduledAnimation scheduledWhite1 = getScheduledWhite(elementLoader, 0);

        final PeekabooToyAnimation electricBlackAnimation = new PeekabooToyAnimation(AnimatorImpls.APPEAR, ELECTRIC_DURATION, elementLoader.electricBlack);
        final ScheduledAnimation scheduledBlack1 = getScheduledBlack(ELECTRIC_DURATION, electricBlackAnimation);
        final ScheduledAnimation scheduledBlack2 = getScheduledBlack((3 * ELECTRIC_DURATION), electricBlackAnimation);
        final ScheduledAnimation scheduledBlack3 = getScheduledBlack((5 * ELECTRIC_DURATION), electricBlackAnimation);

        return new SequenceToyAnimation(scheduledWhite1, scheduledBlack1, scheduledBlack2, scheduledBlack3);
    }

    private ScheduledAnimation getScheduledWhite(ElementLoader elementLoader, int startTimeMillis) {
        final PeekabooToyAnimation electricWhite = new PeekabooToyAnimation(AnimatorImpls.APPEAR, 7 * ELECTRIC_DURATION, elementLoader.electricWhite);
        return new ScheduledAnimation(electricWhite, startTimeMillis);
    }

    private ScheduledAnimation getScheduledBlack(int startTimeMillis, PeekabooToyAnimation peekabooToyAnimation) {
        return new ScheduledAnimation(peekabooToyAnimation, startTimeMillis);
    }
}
