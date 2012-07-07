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
    private final SoundController soundController;

    final Sound tooth1;
    final Sound tooth2;
    final Sound tooth3;
    final Sound tooth4;
    final Sound tooth5;
    final Sound tooth6;
    final Sound electric;
    final Sound earLeft;
    final Sound earRight;
    final Sound leftBraw;
    final Sound rightBraw;
    final Sound mot;
    final Sound surprise;
    final Sound toothBottom;
    final Sound open;
    final Sound close;
    final Sound drum1;
    final Sound drum2;
    final Sound drum3;
    final Sound drum4;
    final Sound tv;
    final Sound disk;
    final Sound nose;

    public SoundLoader() {
        soundController = new SoundController();

        surprise = getSound("surprise");
        tooth1 = getSound("tooth1");
        tooth2 = getSound("tooth2");
        tooth3 = getSound("tooth3");
        tooth4 = getSound("tooth4");
        tooth5 = getSound("tooth5");
        tooth6 = getSound("tooth6");
        electric = getSound("electric");
        earLeft = getSound("earLeft");
        earRight = getSound("earRight");

        leftBraw = getSound("leftBraw");
        rightBraw = getSound("rightBraw");
        mot = getSound("mot");
        toothBottom = getSound("toothBottom");

        open = getSound("open");
        close = getSound("close");

        drum1 = getSound("drum1");
        drum2 = getSound("drum2");
        drum3 = getSound("drum3");
        drum4 = getSound("drum4");

        tv = getSound("tv");
        disk = getSound("disk");
        nose = getSound("nose");

        tooth1.setBalance(100);
        tooth2.setBalance(100);
        tooth3.setBalance(100);
        tooth4.setBalance(100);
        tooth5.setBalance(100);
        tooth6.setBalance(100);

        drum1.setBalance(-100);
        drum2.setBalance(-100);
        drum3.setBalance(-100);
        drum4.setBalance(-100);
    }

    private Sound getSound(String name) {
        return Utils.getSound("robot/"+ name + ".mp3", soundController);
    }
}
