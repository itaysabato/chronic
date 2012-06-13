package com.shanitay.client.utils;

/**
 * Created By: Itay Sabato<br/>
 * Date: 17/05/12 <br/>
 * Time: 22:33 <br/>
 */
public class MovementEquation {
    public static final MovementEquation STILL = new MovementEquation(0, 0);

    private final double p0;
    private final double v0;
    private final double halfA;

    public MovementEquation(double p0, double v0) {
        this.p0 = p0;
        this.v0 = v0;
        this.halfA = 0;
    }

    public MovementEquation(double p0, double v0, double a) {
        this.p0 = p0;
        this.v0 = v0;
        this.halfA = a/2;
    }

    public double getTranslation(double dt) {
        return p0 + (dt*v0) + (halfA*dt*dt);
    }
}
