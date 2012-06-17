package com.shanitay.client.main;

import com.shanitay.client.utils.Utils;
import org.vectomatic.dom.svg.*;

/**
 * Created By: Itay Sabato<br/>
 * Date: 17/05/12 <br/>
 * Time: 20:04 <br/>
 */
class ElementLoader {
    private final OMSVGSVGElement svg;

    final OMSVGGElement slide;
    final OMSVGGElement watchRight1;
    final OMSVGGElement watchRight2;
    final OMSVGGElement watchRight3;
    final OMSVGGElement watchRight4;
    final OMSVGGElement igulSlide;
    final OMSVGRectElement orangeCube;
    final OMSVGRectElement blueCube;
    final OMSVGRectElement blackCube;
    final OMSVGRectElement yellowMiddleCube;
    final OMSVGRectElement house;
    final OMSVGGElement blueTriangle;
    final OMSVGGElement redLine;
    final OMSVGRectElement yellowLineDown;
    final OMSVGRectElement greenLineDown;
    final OMSVGRectElement pinkButton;
    final OMSVGRectElement redButton;
    final OMSVGGElement igulColor1;
    final OMSVGGElement igulColor2;
    final OMSVGGElement igulColor3;
    final OMSVGGElement igulColor4;
    final OMSVGRectElement pinkLine;
    final OMSVGGElement squareColor;
    final OMSVGGElement cube2;
    final OMSVGGElement upTriIgul;
    final OMSVGRectElement pinkCube;
    final OMSVGGElement coolIgul1;
    final OMSVGGElement coolIgul2;
    final OMSVGGElement coolIgul3;
    final OMSVGGElement coolIgul4;
    final OMSVGGElement coolIgul5;
    final OMSVGGElement partGreen;
    final OMSVGGElement movingHouse;
    final OMSVGGElement logo1;
    final OMSVGGElement logo2;
    final OMSVGGElement logo3;
    final OMSVGGElement logo4;
    final OMSVGGElement logo5;
    final OMSVGGElement colorDoor1;
    final OMSVGGElement colorDoor2;
    final OMSVGGElement colorDoor3;
    final OMSVGGElement colorDoor4;
    final OMSVGGElement colorDoor5;
    final OMSVGGElement bigGroup;
    final OMSVGRectElement doorRect;
    final OMSVGGElement create;

    public ElementLoader(OMSVGSVGElement svg) {
        this.svg = svg;

        slide = (OMSVGGElement) getElement("slide");
        watchRight1 = (OMSVGGElement) getElement("watchRight1");
        watchRight2 = (OMSVGGElement) getElement("watchRight2");
        watchRight3 = (OMSVGGElement) getElement("watchRight3");
        watchRight4 = (OMSVGGElement) getElement("watchRight4");
        igulSlide = (OMSVGGElement) getElement("igulSlide");
        orangeCube = (OMSVGRectElement) getElement("orangeCube");
        blueCube = (OMSVGRectElement) getElement("blueCube");
        blackCube = (OMSVGRectElement) getElement("blackCube");
        yellowMiddleCube = (OMSVGRectElement) getElement("yellowMiddleCube");
        pinkCube = (OMSVGRectElement) getElement("pinkCube");
        house = (OMSVGRectElement) getElement("house");
        blueTriangle = (OMSVGGElement) getElement("blueTriangle");
        redLine = (OMSVGGElement) getElement("redLine");
        yellowLineDown = (OMSVGRectElement) getElement("yellowLineDown");
        greenLineDown = (OMSVGRectElement) getElement("greenLineDown");
        pinkButton = (OMSVGRectElement) getElement("pinkButton");
        redButton = (OMSVGRectElement) getElement("redButton");
        igulColor1 = (OMSVGGElement) getElement("igulColor1");
        igulColor2 = (OMSVGGElement) getElement("igulColor2");
        igulColor3 = (OMSVGGElement) getElement("igulColor3");
        igulColor4 = (OMSVGGElement) getElement("igulColor4");
        pinkLine = (OMSVGRectElement) getElement("pinkLine");
        squareColor = (OMSVGGElement) getElement("squareColor");
        cube2 = (OMSVGGElement) getElement("cube2");
        upTriIgul = (OMSVGGElement) getElement("upTriIgul");
        coolIgul1 = (OMSVGGElement) getElement("coolIgul1");
        coolIgul2 = (OMSVGGElement) getElement("coolIgul2");
        coolIgul3 = (OMSVGGElement) getElement("coolIgul3");
        coolIgul4 = (OMSVGGElement) getElement("coolIgul4");
        coolIgul5 = (OMSVGGElement) getElement("coolIgul5");
        partGreen = (OMSVGGElement) getElement("partGreen");
        movingHouse = (OMSVGGElement) getElement("movingHouse");
        logo1 = (OMSVGGElement) getElement("logo1");
        logo2 = (OMSVGGElement) getElement("logo2");
        logo3 = (OMSVGGElement) getElement("logo3");
        logo4 = (OMSVGGElement) getElement("logo4");
        logo5 = (OMSVGGElement) getElement("logo5");

        colorDoor1 = (OMSVGGElement) getElement("colorDoor1");
        colorDoor2 = (OMSVGGElement) getElement("colorDoor2");
        colorDoor3 = (OMSVGGElement) getElement("colorDoor3");
        colorDoor4 = (OMSVGGElement) getElement("colorDoor4");
        colorDoor5 = (OMSVGGElement) getElement("colorDoor5");
        bigGroup = (OMSVGGElement) getElement("bigGroup");
        doorRect = (OMSVGRectElement) getElement("doorRect");
        create = (OMSVGGElement) getElement("create");
    }

    private OMSVGElement getElement(String elementId) {
        return Utils.getSVGElement(elementId, svg);
    }

    public OMSVGAnimationElement getAnimation(String elementId) {
        return Utils.getAnimationElement(elementId, svg);
    }
}
