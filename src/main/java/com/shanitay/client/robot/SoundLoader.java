package com.shanitay.client.robot;

import com.allen_sauer.gwt.voices.client.Sound;
import com.allen_sauer.gwt.voices.client.SoundController;
import com.shanitay.client.utils.Utils;

/**
 * Created By: Itay Sabato<br/>
 * Date: 17/05/12 <br/>
 * Time: 20:04 <br/>
 */
class SoundLoader {
    private final Sound bg;
    private final Sound nose;
    private final Sound mouth;
    private final Sound balls;
    private final Sound tongue;
    private final Sound leftEye;
    private final Sound rightEye;

    public SoundLoader() {
        SoundController soundController = new SoundController();

        balls = Utils.getSound("yeah.mp3", soundController);
        mouth = Utils.getSound("laugh.mp3", soundController);
        bg = Utils.getSound("base06 new.mp3", soundController);
        nose = Utils.getSound("base10new.mp3", soundController);
        leftEye = Utils.getSound("boom new.mp3", soundController);
        rightEye = Utils.getSound("smash nwe.mp3", soundController);
        tongue = Utils.getSound("80s Dance Bass Synth 04 new.mp3", soundController);
    }

    public Sound getBg() {
        return bg;
    }

    public Sound getNose() {
        return nose;
    }

    public Sound getMouth() {
        return mouth;
    }

    public Sound getBalls() {
        return balls;
    }

    public Sound getTongue() {
        return tongue;
    }

    public Sound getLeftEye() {
        return leftEye;
    }

    public Sound getRightEye() {
        return rightEye;
    }
}
