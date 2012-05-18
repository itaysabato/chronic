package com.shanitay.client;

/**
 * Created By: Itay Sabato<br/>
 * Date: 17/05/12 <br/>
 * Time: 20:05 <br/>
 */
public class AnimationLoader {
    private static final int BG_INTERVAL = 125;
    public static final int TIME_UNIT = 41;

    private final Toy.Animation bg;
    private final Toy.Animation nose;
    private final Toy.Animation balls;
    private final Toy.Animation mouth;
    private final Toy.Animation tongue;
    private final Toy.Animation leftEye;
    private final Toy.Animation rightEye;

    public AnimationLoader(ElementLoader elementLoader) {
        bg = new DiscoToyAnimation(
                BG_INTERVAL,
                elementLoader.getBg(),
                elementLoader.getBg4(),
                elementLoader.getBg3(),
                elementLoader.getBg2());

        nose = new DiscoToyAnimation(
                BG_INTERVAL,
                elementLoader.getNose(),
                elementLoader.getNose5(),
                elementLoader.getNose4(),
                elementLoader.getNose3(),
                elementLoader.getNose2());

        mouth = new PeekabooToyAnimation(PeekabooToyAnimation.Kind.APPEAR, 800, elementLoader.getMouthWide());
        leftEye = new PeekabooToyAnimation(PeekabooToyAnimation.Kind.DISAPPEAR, 500, elementLoader.getLeftOpen());
        rightEye = new PeekabooToyAnimation(PeekabooToyAnimation.Kind.DISAPPEAR, 500, elementLoader.getRightOpen());

        final MovementEquation tongueEquationX = new MovementEquation(0, 0);
        final MovementEquation tongueEquationY = new MovementEquation(0, 3.75f);
        tongue = new MovingToyAnimation(TIME_UNIT, 48, tongueEquationX, tongueEquationY, elementLoader.getTongue(), true);

        final MovementEquation ballsEquationX = new MovementEquation(0, 10);
        final MovementEquation ballsEquationY = new MovementEquation(0, 0, 1);
        balls = new MovingToyAnimation(TIME_UNIT, 48, ballsEquationX, ballsEquationY, elementLoader.getBall1(), false);
    }

    public Toy.Animation getRightEye() {
        return rightEye;
    }

    public Toy.Animation getLeftEye() {
        return leftEye;
    }

    public Toy.Animation getTongue() {
        return tongue;
    }

    public Toy.Animation getMouth() {
        return mouth;
    }

    public Toy.Animation getNose() {
        return nose;
    }

    public Toy.Animation getBg() {
        return bg;
    }

    public Toy.Animation getBalls() {
        return balls;
    }
}
