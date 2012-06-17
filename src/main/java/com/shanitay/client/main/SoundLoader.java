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
    final Sound igulSlidePos;
    final Sound igulSlideNeg;
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
    final Sound squareColor;
    final Sound cube2;
    final Sound upTriIgul;
    final Sound pinkCube;
    final Sound coolIgul;
    final Sound partGreen;
    final Sound movingHouse;
    final Sound slideForward;
    final Sound slideBackward;
    final Sound colorDoor;

    public SoundLoader() {
        soundController = new SoundController();

        slide = getSound("slide");
        watchRight = getSound("watchRight");
        igulSlidePos = getSound("igulSlidePos");
        igulSlideNeg = getSound("igulSlideNeg");
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
        squareColor = getSound("squareColor");
        cube2 = getSound("cube2");
        upTriIgul = getSound("upTriIgul");
        pinkCube = getSound("pinkCube");
        coolIgul = getSound("coolIgul");
        partGreen = getSound("partGreen");
        movingHouse = getSound("movingHouse");
        slideForward = getSound("slideForward");
        slideBackward = getSound("slideBackward");
        colorDoor = getSound("colorDoor");
    }

    private Sound getSound(String name) {
        return Utils.getSound("main/"+name+".mp3", soundController);
    }
}
