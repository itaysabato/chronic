package com.shanitay.client;

import org.vectomatic.dom.svg.OMSVGAnimationElement;
import org.vectomatic.dom.svg.OMSVGGElement;
import org.vectomatic.dom.svg.OMSVGSVGElement;

/**
 * Created By: Itay Sabato<br/>
 * Date: 17/05/12 <br/>
 * Time: 20:04 <br/>
 */
public class ElementLoader {
    private final OMSVGGElement bg;
    private final OMSVGGElement bg1;
    private final OMSVGGElement bg2;
    private final OMSVGGElement bg3;
    private final OMSVGGElement bg4;
    private final OMSVGGElement nose;
    private final OMSVGGElement nose5;
    private final OMSVGGElement nose4;
    private final OMSVGGElement nose3;
    private final OMSVGGElement nose2;
    private final OMSVGGElement nose1;
    private final OMSVGGElement tongue;
    private final OMSVGGElement leftOpen;
    private final OMSVGGElement rightOpen;
    private final OMSVGGElement mouthWide;
    private final OMSVGGElement mouthThin;
    private final OMSVGGElement ballsButton;
    private final OMSVGGElement leftSocket;
    private final OMSVGGElement rightSocket;
    private final OMSVGGElement ball1;
    private final OMSVGGElement ball2;
    private final OMSVGGElement ball3;
    private final OMSVGAnimationElement ballScale;

    public ElementLoader(OMSVGSVGElement svgsvgElement) {
        tongue = Utils.getGElement("tongue", svgsvgElement);
        mouthWide = Utils.getGElement("mouthWide", svgsvgElement);
        mouthThin = Utils.getGElement("mouthThin", svgsvgElement);
        ballsButton = Utils.getGElement("ballsButton", svgsvgElement);
        ball1 = Utils.getGElement("ball1", svgsvgElement);
        ball2 = Utils.getGElement("ball2", svgsvgElement);
        ball3 = Utils.getGElement("ball3", svgsvgElement);
        leftOpen = Utils.getGElement("eyeballLeftOpen", svgsvgElement);
        leftSocket = Utils.getGElement("leftSocket", svgsvgElement);
        rightOpen = Utils.getGElement("eyeballRightOpen", svgsvgElement);
        rightSocket = Utils.getGElement("rightSocket", svgsvgElement);
        bg = Utils.getGElement("bg", svgsvgElement);
        bg4 = Utils.getGElement("bg4", svgsvgElement);
        bg3 = Utils.getGElement("bg3", svgsvgElement);
        bg2 = Utils.getGElement("bg2", svgsvgElement);
        bg1 = Utils.getGElement("bg1", svgsvgElement);
        nose = Utils.getGElement("nose", svgsvgElement);
        nose5 = Utils.getGElement("nose5", svgsvgElement);
        nose4 = Utils.getGElement("nose4", svgsvgElement);
        nose3 = Utils.getGElement("nose3", svgsvgElement);
        nose2 = Utils.getGElement("nose2", svgsvgElement);
        nose1 = Utils.getGElement("nose1", svgsvgElement);
        ballScale = Utils.getAnimationElement("ballScale", svgsvgElement);
    }

    public OMSVGGElement getBg() {
        return bg;
    }

    public OMSVGGElement getBg1() {
        return bg1;
    }

    public OMSVGGElement getBg2() {
        return bg2;
    }

    public OMSVGGElement getBg3() {
        return bg3;
    }

    public OMSVGGElement getBg4() {
        return bg4;
    }

    public OMSVGGElement getNose() {
        return nose;
    }

    public OMSVGGElement getNose5() {
        return nose5;
    }

    public OMSVGGElement getNose4() {
        return nose4;
    }

    public OMSVGGElement getNose3() {
        return nose3;
    }

    public OMSVGGElement getNose2() {
        return nose2;
    }

    public OMSVGGElement getNose1() {
        return nose1;
    }

    public OMSVGGElement getTongue() {
        return tongue;
    }

    public OMSVGGElement getLeftOpen() {
        return leftOpen;
    }

    public OMSVGGElement getRightOpen() {
        return rightOpen;
    }

    public OMSVGGElement getMouthWide() {
        return mouthWide;
    }

    public OMSVGGElement getBallsButton() {
        return ballsButton;
    }

    public OMSVGGElement getMouthThin() {
        return mouthThin;
    }

    public OMSVGGElement getLeftSocket() {
        return leftSocket;
    }

    public OMSVGGElement getRightSocket() {
        return rightSocket;
    }

    public OMSVGGElement getBall1() {
        return ball1;
    }

    public OMSVGGElement getBall2() {
        return ball2;
    }

    public OMSVGGElement getBall3() {
        return ball3;
    }

    public OMSVGAnimationElement getBallScale() {
        return ballScale;
    }
}
