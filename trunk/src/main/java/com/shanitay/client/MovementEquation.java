package com.shanitay.client;

/**
 * Created By: Itay Sabato<br/>
 * Date: 17/05/12 <br/>
 * Time: 22:33 <br/>
 */
public class MovementEquation {
    private final float p0;
    private final float v0;

    public MovementEquation(float p0, float v0) {
        this.p0 = p0;
        this.v0 = v0;
    }

    public float getTranslation(float dt) {
        return p0 + (dt*v0);
    }
}
