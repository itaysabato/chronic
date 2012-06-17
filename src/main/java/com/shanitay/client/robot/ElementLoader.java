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

        bgCoop1 = Utils.getGElement("bgCoop1", svgsvgElement);
        bgCoop2 = Utils.getGElement("bgCoop2", svgsvgElement);
        bgCoop3 = Utils.getGElement("bgCoop3", svgsvgElement);

        smallLightning = Utils.getGElement("smallLightning", svgsvgElement);

        eyeBallLeft = Utils.getGElement("eyeBallLeft", svgsvgElement);
        eyeBallRight = Utils.getGElement("eyeBallRight", svgsvgElement);

//        step1 = Utils.getGElement("step1", svgsvgElement);
//        step2 = Utils.getGElement("step2", svgsvgElement);
//        step3 = Utils.getGElement("step3", svgsvgElement);
//        step4 = Utils.getGElement("step4", svgsvgElement);
//        step5 = Utils.getGElement("step5", svgsvgElement);
//        step6 = Utils.getGElement("step6", svgsvgElement);
//        step7 = Utils.getGElement("step7", svgsvgElement);

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
