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

        nose = Utils.getSound("robot/nose.mp3", soundController);
        tooth1 = Utils.getSound("robot/tooth1.mp3", soundController);
        tooth2 = Utils.getSound("robot/tooth2.mp3", soundController);
        tooth3 = Utils.getSound("robot/tooth3.mp3", soundController);
        tooth4 = Utils.getSound("robot/tooth4.mp3", soundController);
        tooth5 = Utils.getSound("robot/tooth5.mp3", soundController);
        tooth6 = Utils.getSound("robot/tooth6.mp3", soundController);
        electric = Utils.getSound("robot/electric.mp3", soundController);
        earLeft = Utils.getSound("robot/earLeft.mp3", soundController);
        earRight = Utils.getSound("robot/earRight.mp3", soundController);
        coop = Utils.getSound("robot/coop.mp3", soundController);
        pumpHouse = Utils.getSound("robot/pumpHouse.mp3", soundController);

        step1 = Utils.getSound("robot/step1.mp3", soundController);
        step2 = Utils.getSound("robot/step2.mp3", soundController);
        step3 = Utils.getSound("robot/step3.mp3", soundController);
        step4 = Utils.getSound("robot/step4.mp3", soundController);
        step5 = Utils.getSound("robot/step5.mp3", soundController);
        step6 = Utils.getSound("robot/step6.mp3", soundController);
        step7 = Utils.getSound("robot/step7.mp3", soundController);

        leftBraw = Utils.getSound("robot/leftBraw.mp3", soundController);
        rightBraw = Utils.getSound("robot/rightBraw.mp3", soundController);
        mot = Utils.getSound("robot/mot.mp3", soundController);
        toothBottom = Utils.getSound("robot/toothBottom.mp3", soundController);

        open = Utils.getSound("robot/open.mp3", soundController);
        close = Utils.getSound("robot/close.mp3", soundController);

    }
}
