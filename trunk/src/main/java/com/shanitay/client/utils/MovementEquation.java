package com.shanitay.client.utils;

/**
 * Created By: Itay Sabato<br/>
 * Date: 17/05/12 <br/>
 * Time: 22:33 <br/>
 */
public class MovementEquation {
    public static final MovementEquation STILL = new MovementEquation(0, 0);

    private final float p0;
    private final float v0;
    private final float halfA;

    public MovementEquation(float p0, float v0) {
        this.p0 = p0;
        this.v0 = v0;
        this.halfA = 0;
    }

    public MovementEquation(float p0, float v0, float a) {
        this.p0 = p0;
        this.v0 = v0;
        this.halfA = a/2;
    }

    public float getTranslation(float dt) {
        return p0 + (dt*v0) + (halfA*dt*dt);
    }
}
