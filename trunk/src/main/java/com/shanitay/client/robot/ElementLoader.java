package com.shanitay.client.robot;

import com.shanitay.client.utils.Utils;
import org.vectomatic.dom.svg.*;
import org.vectomatic.dom.svg.events.BeginEvent;
import org.vectomatic.dom.svg.events.BeginHandler;

/**
 * Created By: Itay Sabato<br/>
 * Date: 17/05/12 <br/>
 * Time: 20:04 <br/>
 */
class ElementLoader {
    private final OMSVGSVGElement svg;

    private boolean mouthOpen = false;
    final OMSVGGElement tooth1;
    final OMSVGGElement tooth2;
    final OMSVGGElement tooth3;
    final OMSVGGElement tooth4;
    final OMSVGGElement tooth5;
    final OMSVGGElement tooth6;
    final OMSVGGElement electricWhite;
    final OMSVGGElement electricBlack;
    final OMSVGGElement lightningButton;
    final OMSVGPathElement earRight;
    final OMSVGPathElement earLeft;
    final OMSVGGElement earHandle;
    final OMSVGGElement bgCoop1;
    final OMSVGGElement bgCoop2;
    final OMSVGGElement bgCoop3;
    final OMSVGGElement smallLightning;
    final OMSVGGElement eyeBallLeft;
    final OMSVGGElement eyeBallRight;
    final OMSVGGElement teethDownOpen;
    final OMSVGGElement glasses;
    final OMSVGGElement surprised;
    final OMSVGGElement nose;
    final OMSVGGElement eyes;
    final OMSVGGElement lightning;
    final OMSVGAnimationElement leftBrawRise;
    final OMSVGAnimationElement rightBrawRise;
    final OMSVGGElement eyeBrawLeft;
    final OMSVGGElement eyeBrawRight;
    final OMSVGRectElement mot;
    final OMSVGAnimationElement openMouthAnimation;
    final OMSVGAnimationElement closeMouthAnimation;
    final OMSVGAnimationElement handleMove1;
    final OMSVGGElement eyeRightSur;
    final OMSVGGElement track1;
    final OMSVGGElement track2;
    final OMSVGGElement track3;
    final OMSVGGElement track4;
    final OMSVGRectElement pinkButton1;
    final OMSVGRectElement greenButton2;
    final OMSVGRectElement redButton3;
    final OMSVGRectElement blueButton4;
    final OMSVGRectElement drum1;
    final OMSVGRectElement drum2;
    final OMSVGPolygonElement drum3;
    final OMSVGRectElement drum4;
    final OMSVGGElement backArrow;

    public ElementLoader(OMSVGSVGElement svg) {
        this.svg = svg;

        backArrow = (OMSVGGElement) getElement("backArrow");

        track1 = (OMSVGGElement) getElement("track1");
        pinkButton1 = (OMSVGRectElement) getElement("pinkButton");

        track2 = (OMSVGGElement) getElement("track2");
        greenButton2 = (OMSVGRectElement) getElement("greenButton");

        track3 = (OMSVGGElement) getElement("track3");
        redButton3 = (OMSVGRectElement) getElement("redButton");

        track4 = (OMSVGGElement) getElement("track4");
        blueButton4 = (OMSVGRectElement) getElement("blueButton");

        drum1 = (OMSVGRectElement) getElement("drum1");
        drum2 = (OMSVGRectElement) getElement("drum2");
        drum3 = (OMSVGPolygonElement) getElement("drum3");
        drum4 = (OMSVGRectElement) getElement("drum4");

        tooth1 = Utils.getGElement("tooth1", this.svg);
        tooth2 = Utils.getGElement("tooth2", this.svg);
        tooth3 = Utils.getGElement("tooth3", this.svg);
        tooth4 = Utils.getGElement("tooth4", this.svg);
        tooth5 = Utils.getGElement("tooth5", this.svg);
        tooth6 = Utils.getGElement("tooth6", this.svg);

        lightningButton = Utils.getGElement("lightningButton", this.svg);
        electricWhite = Utils.getGElement("electricWhite", this.svg);
        electricBlack = Utils.getGElement("electricBlack", this.svg);

        earRight = (OMSVGPathElement) Utils.getSVGElement("earRight", this.svg);
        earLeft = (OMSVGPathElement) Utils.getSVGElement("earLeft", this.svg);
        earHandle = Utils.getGElement("earHandle", this.svg);

        bgCoop1 = Utils.getGElement("bgCoop1", this.svg);
        bgCoop2 = Utils.getGElement("bgCoop2", this.svg);
        bgCoop3 = Utils.getGElement("bgCoop3", this.svg);

        smallLightning = Utils.getGElement("smallLightning", this.svg);

        eyeBallLeft = Utils.getGElement("eyeBallLeft", this.svg);
        eyeBallRight = Utils.getGElement("eyeBallRight", this.svg);

//        step1 = Utils.getGElement("step1", svgsvgElement);
//        step2 = Utils.getGElement("step2", svgsvgElement);
//        step3 = Utils.getGElement("step3", svgsvgElement);
//        step4 = Utils.getGElement("step4", svgsvgElement);
//        step5 = Utils.getGElement("step5", svgsvgElement);
//        step6 = Utils.getGElement("step6", svgsvgElement);
//        step7 = Utils.getGElement("step7", svgsvgElement);

        nose = Utils.getGElement("nose", this.svg);
        surprised = Utils.getGElement("surprised", this.svg);
        eyes = Utils.getGElement("eyes", this.svg);

        teethDownOpen = Utils.getGElement("teethDownOpen", this.svg);
        glasses = Utils.getGElement("glasses", this.svg);

        lightning = Utils.getGElement("lightning", this.svg);

        eyeBrawLeft = Utils.getGElement("eyeBrawLeft", this.svg);
        eyeBrawRight = Utils.getGElement("eyeBrawRight", this.svg);
        leftBrawRise = Utils.getAnimationElement("leftBrawRise", this.svg);
        rightBrawRise = Utils.getAnimationElement("rightBrawRise", this.svg);

        mot = (OMSVGRectElement) Utils.getSVGElement("mot", this.svg);
        openMouthAnimation = Utils.getAnimationElement("openMouth", this.svg);
        closeMouthAnimation = Utils.getAnimationElement("closeMouth", this.svg);

        openMouthAnimation.addBeginHandler(new BeginHandler() {
            public void onBegin(BeginEvent event) {
                mouthOpen = true;
            }
        });

        closeMouthAnimation.addBeginHandler(new BeginHandler() {
            public void onBegin(BeginEvent event) {
                mouthOpen = false;
            }
        });

        handleMove1 = Utils.getAnimationElement("handleMove1", this.svg);
        eyeRightSur = Utils.getGElement("eyeRightSur", this.svg);
    }

    private OMSVGElement getElement(String elementId) {
        return Utils.getSVGElement(elementId, svg);
    }

    private OMSVGRectElement getStepRect(OMSVGGElement step) {
        OMSVGRectElement rect = null;
        for (OMNode omNode : step.getChildNodes()) {
            if(omNode instanceof OMSVGRectElement){
                rect = (OMSVGRectElement) omNode;
                break;
            }
        }
        return rect;
    }

    public boolean isMouthOpen() {
        return mouthOpen;
    }

    public OMSVGAnimationElement getAnimation(String elementId) {
        return Utils.getAnimationElement(elementId, svg);
    }
}
