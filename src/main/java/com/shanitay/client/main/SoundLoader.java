package com.shanitay.client.main;

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

    final Sound slide;
    final Sound watchRight;
    final Sound igulSlide;
    final Sound orangeCube;
    final Sound blueCube;
    final Sound blackCube;
    final Sound yellowMiddleCube;
    final Sound house;
    final Sound blueTriangle;
    final Sound redLine;
    final Sound yellowLineDown;
    final Sound greenLineDown;
    final Sound pinkButton;
    final Sound redButton;
    final Sound igulColor;
    final Sound pinkLine;

    public SoundLoader() {
        soundController = new SoundController();

        slide = getSound("slide");
        watchRight = getSound("watchRight");
        igulSlide = getSound("igulSlide");
        orangeCube = getSound("orangeCube");
        blueCube = getSound("blueCube");
        blackCube = getSound("blackCube");
        yellowMiddleCube = getSound("yellowMiddleCube");
        house = getSound("house");
        blueTriangle = getSound("blueTriangle");
        redLine = getSound("redLine");
        yellowLineDown = getSound("yellowLineDown");
        greenLineDown = getSound("greenLineDown");
        pinkButton = getSound("pinkButton");
        redButton = getSound("redButton");
        igulColor = getSound("igulColor");
        pinkLine = getSound("pinkLine");
    }

    private Sound getSound(String name) {
        return Utils.getSound("main/"+name+".mp3", soundController);
    }
}
