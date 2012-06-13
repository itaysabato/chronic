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
    final OMSVGGElement coopButton;
    final OMSVGGElement bgCoop1;
    final OMSVGGElement bgCoop2;
    final OMSVGGElement bgCoop3;
    final OMSVGRectElement coopButtonCenter;
    final OMSVGElement pumpLight;
    final OMSVGGElement smallLightning;
    final OMSVGGElement eyeBallLeft;
    final OMSVGGElement eyeBallRight;
    final OMSVGGElement step1;
    final OMSVGGElement step2;
    final OMSVGGElement step3;
    final OMSVGGElement step4;
    final OMSVGGElement step5;
    final OMSVGGElement step6;
    final OMSVGGElement step7;
    final OMSVGRectElement step1Rect;
    final OMSVGRectElement step2Rect;
    final OMSVGRectElement step3Rect;
    final OMSVGRectElement step4Rect;
    final OMSVGRectElement step5Rect;
    final OMSVGRectElement step6Rect;
    final OMSVGRectElement step7Rect;
    final OMSVGGElement pump;
    final OMSVGGElement pumpColors1;
    final OMSVGGElement pumpColors2;
    final OMSVGGElement pumpColors3;
    final OMSVGGElement pumpHouse;
    final OMSVGGElement bgPump1;
    final OMSVGGElement bgPump2;
    final OMSVGGElement bgPump3;
    final OMSVGGElement bgPump4;
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

    public ElementLoader(OMSVGSVGElement svgsvgElement) {
        tooth1 = Utils.getGElement("tooth1", svgsvgElement);
        tooth2 = Utils.getGElement("tooth2", svgsvgElement);
        tooth3 = Utils.getGElement("tooth3", svgsvgElement);
        tooth4 = Utils.getGElement("tooth4", svgsvgElement);
        tooth5 = Utils.getGElement("tooth5", svgsvgElement);
        tooth6 = Utils.getGElement("tooth6", svgsvgElement);

        lightningButton = Utils.getGElement("lightningButton", svgsvgElement);
        electricWhite = Utils.getGElement("electricWhite", svgsvgElement);
        electricBlack = Utils.getGElement("electricBlack", svgsvgElement);

        earRight = (OMSVGPathElement) Utils.getSVGElement("earRight", svgsvgElement);
        earLeft = (OMSVGPathElement) Utils.getSVGElement("earLeft", svgsvgElement);
        earHandle = Utils.getGElement("earHandle", svgsvgElement);

        coopButton = Utils.getGElement("coopButton", svgsvgElement);
        bgCoop1 = Utils.getGElement("bgCoop1", svgsvgElement);
        bgCoop2 = Utils.getGElement("bgCoop2", svgsvgElement);
        bgCoop3 = Utils.getGElement("bgCoop3", svgsvgElement);
        coopButtonCenter = (OMSVGRectElement) Utils.getSVGElement("coopButtonCenter", svgsvgElement);

        pumpLight = Utils.getSVGElement("pumpLight", svgsvgElement);
        smallLightning = Utils.getGElement("smallLightning", svgsvgElement);

        eyeBallLeft = Utils.getGElement("eyeBallLeft", svgsvgElement);
        eyeBallRight = Utils.getGElement("eyeBallRight", svgsvgElement);

        step1 = Utils.getGElement("step1", svgsvgElement);
        step2 = Utils.getGElement("step2", svgsvgElement);
        step3 = Utils.getGElement("step3", svgsvgElement);
        step4 = Utils.getGElement("step4", svgsvgElement);
        step5 = Utils.getGElement("step5", svgsvgElement);
        step6 = Utils.getGElement("step6", svgsvgElement);
        step7 = Utils.getGElement("step7", svgsvgElement);

        step1Rect = getStepRect(step1);
        step2Rect = getStepRect(step2);
        step3Rect = getStepRect(step3);
        step4Rect = getStepRect(step4);
        step5Rect = getStepRect(step5);
        step6Rect = getStepRect(step6);
        step7Rect = getStepRect(step7);

        pump = Utils.getGElement("pump", svgsvgElement);
        pumpColors1 = Utils.getGElement("pumpColors1", svgsvgElement);
        pumpColors2 = Utils.getGElement("pumpColors2", svgsvgElement);
        pumpColors3 = Utils.getGElement("pumpColors3", svgsvgElement);
        pumpHouse = Utils.getGElement("pumpHouse", svgsvgElement);
        bgPump1 = Utils.getGElement("bgPump1", svgsvgElement);
        bgPump2 = Utils.getGElement("bgPump2", svgsvgElement);
        bgPump3 = Utils.getGElement("bgPump3", svgsvgElement);
        bgPump4 = Utils.getGElement("bgPump4", svgsvgElement);

        nose = Utils.getGElement("nose", svgsvgElement);
        surprised = Utils.getGElement("surprised", svgsvgElement);
        eyes = Utils.getGElement("eyes", svgsvgElement);

        teethDownOpen = Utils.getGElement("teethDownOpen", svgsvgElement);
        glasses = Utils.getGElement("glasses", svgsvgElement);

        lightning = Utils.getGElement("lightning", svgsvgElement);

        eyeBrawLeft = Utils.getGElement("eyeBrawLeft", svgsvgElement);
        eyeBrawRight = Utils.getGElement("eyeBrawRight", svgsvgElement);
        leftBrawRise = Utils.getAnimationElement("leftBrawRise", svgsvgElement);
        rightBrawRise = Utils.getAnimationElement("rightBrawRise", svgsvgElement);

        mot = (OMSVGRectElement) Utils.getSVGElement("mot", svgsvgElement);
        openMouthAnimation = Utils.getAnimationElement("openMouth", svgsvgElement);
        closeMouthAnimation = Utils.getAnimationElement("closeMouth", svgsvgElement);

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

        handleMove1 = Utils.getAnimationElement("handleMove1", svgsvgElement);
        eyeRightSur = Utils.getGElement("eyeRightSur", svgsvgElement);
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
}
