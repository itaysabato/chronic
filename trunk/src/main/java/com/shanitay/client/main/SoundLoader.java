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
    final Sound slideForward;
    final Sound slideBackward;
    final Sound colorDoor;
    final Sound bigForward;
    final Sound bigBackward;

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
        slideForward = getSound("slideForward");
        slideBackward = getSound("slideBackward");
        colorDoor = getSound("colorDoor");
        bigForward = getSound("bigForward");
        bigBackward = getSound("bigBackward");

        colorDoor.setBalance(100);
        slide.setBalance(100);
        pinkLine.setBalance(100);
        bigForward.setBalance(100);
        cube2.setBalance(80);
        coolIgul.setBalance(80);
        igulSlideNeg.setBalance(60);
        igulSlidePos.setBalance(60);
        upTriIgul.setBalance(60);
        squareColor.setBalance(60);
        pinkCube.setBalance(40);
        yellowMiddleCube.setBalance(40);
        orangeCube.setBalance(40);
        redLine.setBalance(40);

        yellowLineDown.setBalance(-40);
        blueCube.setBalance(-40);
        blackCube.setBalance(-40);
        house.setBalance(-40);
        greenLineDown.setBalance(-60);
        igulColor.setBalance(-60);
        redButton.setBalance(-80);
        pinkButton.setBalance(-80);
        partGreen.setBalance(-100);
        bigBackward.setBalance(-100);


    }

    private Sound getSound(String name) {
        return Utils.getSound("main/" + name + ".mp3", soundController);
    }
}
