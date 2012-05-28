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
    final Sound tooth1;
    final Sound tooth2;
    final Sound tooth3;
    final Sound tooth4;
    final Sound tooth5;
    final Sound tooth6;
    final Sound electric;
    final Sound earLeft;
    final Sound earRight;
    final Sound coop;
    final Sound pumpHouse;
    final Sound step1;
    final Sound step2;
    final Sound step3;
    final Sound step4;
    final Sound step5;
    final Sound step6;
    final Sound step7;
    final Sound leftBraw;
    final Sound rightBraw;
    final Sound mot;
    final Sound nose;
    final Sound toothBottom;
    final Sound open;
    final Sound close;

    public SoundLoader() {
        SoundController soundController = new SoundController();

        nose = Utils.getSound("crash1.mp3", soundController);
        tooth1 = Utils.getSound("snar2.mp3", soundController);
        tooth2 = Utils.getSound("snare1.mp3", soundController);
        tooth3 = Utils.getSound("hihat1.mp3", soundController);
        tooth4 = Utils.getSound("cowbell1.mp3", soundController);
        tooth5 = Utils.getSound("basedrum2.mp3", soundController);
        tooth6 = Utils.getSound("basedrum1.mp3", soundController);
        electric = Utils.getSound("electric.mp3", soundController);
        earLeft = Utils.getSound("80s.mp3", soundController);
        earRight = Utils.getSound("splash1.mp3", soundController);
        coop = Utils.getSound("boom_new.mp3", soundController);
        pumpHouse = Utils.getSound("base06_new.mp3", soundController);

        step1 = Utils.getSound("laugh.mp3", soundController);
        step2 = Utils.getSound("base07.mp3", soundController);
        step3 = Utils.getSound("gun10.mp3", soundController);
        step4 = Utils.getSound("gun5.mp3", soundController);
        step5 = Utils.getSound("beep1.mp3", soundController);
        step6 = Utils.getSound("base10new.mp3", soundController);
        step7 = Utils.getSound("laser10.mp3", soundController);

        leftBraw = Utils.getSound("base1.mp3", soundController);
        rightBraw = Utils.getSound("cowbell2.mp3", soundController);
        mot = Utils.getSound("laser10.mp3", soundController);
        toothBottom = Utils.getSound("yeah.mp3", soundController);

        open = Utils.getSound("open2.mp3", soundController);
        close = Utils.getSound("close2.mp3", soundController);

    }
}
