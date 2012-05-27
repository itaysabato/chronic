package com.shanitay.client.robot;

import com.shanitay.client.utils.*;
import org.vectomatic.dom.svg.OMSVGElement;
import org.vectomatic.dom.svg.OMSVGGElement;
import org.vectomatic.dom.svg.OMSVGRectElement;

/**
 * Created By: Itay Sabato<br/>
 * Date: 17/05/12 <br/>
 * Time: 20:05 <br/>
 */
class AnimationLoader {

    private static final int EYE_STEPS = 48;
    private static final int STEP_DELAY = 2000;
    private static final int BG_INTERVAL = 125;
    private static final int EXPLODE_DUR = 250;
    private static final int TOOTH_DURATION = 250;
    private static final int LADDER_NUM_STEPS = 300;
    public static final int ELECTRIC_DURATION = 125;
    private static final int RIGHT_EAR_DURATION = 500;
    private static final int LIGHTNING_DURATION = 500;
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
//    final Toy.Animation pumpLight;
//    final Toy.Animation smallLightning;
//    final Toy.Animation eyeBallLeft;
//    final Toy.Animation eyeBallRight;
//    final Toy.Animation step1;
//    final Toy.Animation step2;
//    final Toy.Animation step3;
//    final Toy.Animation step4;
//    final Toy.Animation step5;
//    final Toy.Animation step6;
//    final Toy.Animation step7;
    final Toy.Animation step1Explode;
    final Toy.Animation step2Explode;
    final Toy.Animation step3Explode;
    final Toy.Animation step4Explode;
    final Toy.Animation step5Explode;
    final Toy.Animation step6Explode;
    final Toy.Animation step7Explode;
//    final Toy.Animation pump;
    final Toy.Animation pumpColors;
    final Toy.Animation pumpHouse;
    final Toy.Animation bgPump;
    final Toy.Animation leftBraw;
    final Toy.Animation rightBraw;
    final Toy.Animation mot;
    final Toy.Animation openMouth;
    final Toy.Animation closeMouth;


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

        earLeft = createLeftEar(elementLoader);

        final FillColorAnimator coopCenterAnimator = new FillColorAnimator("#173434", "#EAE984");
        coopCenter = new PeekabooToyAnimation(coopCenterAnimator, COOP_CENTER_DURATION, elementLoader.coopButtonCenter);
        coopBg = new DiscoToyAnimation(true, AnimatorImpls.APPEAR, BG_INTERVAL, elementLoader.bgCoop1, elementLoader.bgCoop2, elementLoader.bgCoop3);

        final FillColorAnimator pumpLightAnimator = new FillColorAnimator("#EAE984", "#F2B1B6");
//        pumpLight = new PeekabooToyAnimation(pumpLightAnimator, PUMP_LIGHT_DURATION, elementLoader.pumpLight);
//        pumpLight.setLooping(true);
//        pumpLight.play();

//        smallLightning = new PeekabooToyAnimation(AnimatorImpls.DISAPPEAR, LIGHTNING_DURATION, elementLoader.smallLightning);
//        smallLightning.setLooping(true);
//        smallLightning.play();

//        eyeBallLeft = createEyeSequence(elementLoader.eyeBallLeft);
//        eyeBallRight = createEyeSequence(elementLoader.eyeBallRight);

//        Scheduler.get().scheduleFixedDelay(new Scheduler.RepeatingCommand() {
//            public boolean execute() {
//                eyeBallLeft.play();
//                eyeBallRight.play();
//                return true;
//            }
//        }, 3*Utils.TIME_UNIT * EYE_STEPS);

//        step1 = createStep(elementLoader.step1);
//        step2 = createStep(elementLoader.step2);
//        step3 = createStep(elementLoader.step3);
//        step4 = createStep(elementLoader.step4);
//        step5 = createStep(elementLoader.step5);
//        step6 = createStep(elementLoader.step6);
//        step7 = createStep(elementLoader.step7);
//
//        step1.play();
//        scheduleStep(step2, 1);
//        scheduleStep(step3, 2);
//        scheduleStep(step4, 3);
//        scheduleStep(step5, 4);
//        scheduleStep(step6, 5);
//        scheduleStep(step7, 6);

        step1Explode = createExplodeAnimation(elementLoader.step1, elementLoader.step1Rect);
        step2Explode = createExplodeAnimation(elementLoader.step2, elementLoader.step2Rect);
        step3Explode = createExplodeAnimation(elementLoader.step3, elementLoader.step3Rect);
        step4Explode = createExplodeAnimation(elementLoader.step4, elementLoader.step4Rect);
        step5Explode = createExplodeAnimation(elementLoader.step5, elementLoader.step5Rect);
        step6Explode = createExplodeAnimation(elementLoader.step6, elementLoader.step6Rect);
        step7Explode = createExplodeAnimation(elementLoader.step7, elementLoader.step7Rect);

//        pump = createPump(elementLoader);
//        pump.play();

        pumpColors = new DiscoToyAnimation(true, AnimatorImpls.DISAPPEAR, BG_INTERVAL, elementLoader.pumpColors3, elementLoader.pumpColors2);
        pumpHouse = new MovingToyAnimation(Utils.TIME_UNIT, 6, new MovementEquation(0, 20f / 41f), MovementEquation.STILL, elementLoader.pumpHouse, true);
        bgPump = new SequenceToyAnimation(
                4*BG_INTERVAL,
                createScheduledBgPump(elementLoader.bgPump1, 0),
                createScheduledBgPump(elementLoader.bgPump2, 1),
                createScheduledBgPump(elementLoader.bgPump3, 2),
                createScheduledBgPump(elementLoader.bgPump4, 3));

        leftBraw = new SvgToyAnimation(elementLoader.leftBrawRise);
        rightBraw = new SvgToyAnimation(elementLoader.rightBrawRise);

        FillColorAnimator fillColorAnimator = new FillColorAnimator("#EE8F78", "#EAE984");
        mot = new PeekabooToyAnimation(fillColorAnimator, 250, elementLoader.mot);
        openMouth = new SvgToyAnimation(elementLoader.openMouthAnimation);
        closeMouth = new SvgToyAnimation(elementLoader.closeMouthAnimation);
    }

    private Toy.Animation createExplodeAnimation(OMSVGGElement step, OMSVGRectElement stepRect) {
        StateChangeAnimator stepExplodeAnimator = createStepExplodeAnimator(stepRect);
        return new PeekabooToyAnimation(stepExplodeAnimator, EXPLODE_DUR, step);
    }

    private ScheduledAnimation createScheduledBgPump(OMSVGGElement bgPump, int i) {
        final PeekabooToyAnimation peekabooToyAnimation = new PeekabooToyAnimation(AnimatorImpls.APPEAR, BG_INTERVAL, bgPump);
        return new ScheduledAnimation(peekabooToyAnimation, i*BG_INTERVAL);
    }

//    private MovingToyAnimation createPump(ElementLoader elementLoader) {
//        final MovementEquation pumpEquation = new MovementEquation(0, -12);
//        final MovingToyAnimation movingToyAnimation = new MovingToyAnimation(Utils.TIME_UNIT, 24, MovementEquation.STILL, pumpEquation, elementLoader.pump, true);
//        movingToyAnimation.setLooping(true);
//        return movingToyAnimation;
//    }

    private Toy.Animation createLeftEar(ElementLoader elementLoader) {
        return new SvgToyAnimation(elementLoader.handleMove1);
    }

//    private void scheduleStep(final Toy.Animation step, int i) {
//        Scheduler.get().scheduleFixedDelay(new Scheduler.RepeatingCommand() {
//            public boolean execute() {
//                step.play();
//                return false;
//            }
//        }, i *STEP_DELAY);
//    }
//
//    private MovingToyAnimation createStep(OMSVGGElement step) {
//        final MovementEquation movementEquationY = new MovementEquation(0, -2);
//        final MovingToyAnimation movingToyAnimation = new MovingToyAnimation(Utils.TIME_UNIT, LADDER_NUM_STEPS, MovementEquation.STILL, movementEquationY, step, false);
//        movingToyAnimation.setLooping(true);
//        return movingToyAnimation;
//    }

//    private SequenceToyAnimation createEyeSequence(OMSVGGElement eyeBall) {
//        final MovingToyAnimation leftAnimation = createEyeBallAnimation(eyeBall, 1.2f);
//        final ScheduledAnimation leftScheduledAnimation = new ScheduledAnimation(leftAnimation, 0);
//
//        final MovingToyAnimation rightAnimation = createEyeBallAnimation(eyeBall, -1.2f);
//        final ScheduledAnimation rightScheduledAnimation = new ScheduledAnimation(rightAnimation, Utils.TIME_UNIT * 55);
//        return new SequenceToyAnimation(leftScheduledAnimation, rightScheduledAnimation);
//    }

//    private MovingToyAnimation createEyeBallAnimation(OMSVGGElement eyeBall, float vX) {
//        final MovementEquation eyeBallsEquationX = new MovementEquation(0, vX);
//        final MovementEquation eyeBallsEquationY = new MovementEquation(0, 0);
//        return new MovingToyAnimation(Utils.TIME_UNIT, EYE_STEPS, eyeBallsEquationX, eyeBallsEquationY, eyeBall, true);
//    }

    private Toy.Animation createElectric() {

        PeekabooToyAnimation lightningAnimation = new PeekabooToyAnimation(AnimatorImpls.APPEAR, ELECTRIC_DURATION, elementLoader.lightning);
        ScheduledAnimation scheduledLightning1 = getScheduledAnimation(0, lightningAnimation);
        ScheduledAnimation scheduledLightning2 = getScheduledAnimation(2 * ELECTRIC_DURATION, lightningAnimation);

        PeekabooToyAnimation whiteAnimation = new PeekabooToyAnimation(AnimatorImpls.APPEAR, 7 * ELECTRIC_DURATION, elementLoader.electricWhite);
        final ScheduledAnimation scheduledWhite1 = getScheduledAnimation(3 * ELECTRIC_DURATION, whiteAnimation);

        final PeekabooToyAnimation electricBlackAnimation = new PeekabooToyAnimation(AnimatorImpls.APPEAR, ELECTRIC_DURATION, elementLoader.electricBlack);
        final ScheduledAnimation scheduledBlack1 = getScheduledAnimation(4 * ELECTRIC_DURATION, electricBlackAnimation);
        final ScheduledAnimation scheduledBlack2 = getScheduledAnimation((6 * ELECTRIC_DURATION), electricBlackAnimation);
        final ScheduledAnimation scheduledBlack3 = getScheduledAnimation((8 * ELECTRIC_DURATION), electricBlackAnimation);

        return new SequenceToyAnimation(scheduledLightning1, scheduledLightning2, scheduledWhite1, scheduledBlack1, scheduledBlack2, scheduledBlack3);
    }

    private ScheduledAnimation getScheduledAnimation(int startTimeMillis, PeekabooToyAnimation peekabooToyAnimation) {
        return new ScheduledAnimation(peekabooToyAnimation, startTimeMillis);
    }

    private StateChangeAnimator createStepExplodeAnimator(final OMSVGRectElement stepRect){
        return new StateChangeAnimator() {
            public void inAnimation(OMSVGElement target) {
                stepRect.getX().getBaseVal().setValue(1078.282f);
                stepRect.getY().getBaseVal().setValue(657.246f);
                stepRect.getWidth().getBaseVal().setValue(178.513f);
                stepRect.getHeight().getBaseVal().setValue(99.348f);
            }

            public void offAnimation(OMSVGElement target) {
                stepRect.getX().getBaseVal().setValue(1108.282f);
                stepRect.getY().getBaseVal().setValue(687.246f);
                stepRect.getWidth().getBaseVal().setValue(118.513f);
                stepRect.getHeight().getBaseVal().setValue(39.348f);
            }
        };
    }
}
