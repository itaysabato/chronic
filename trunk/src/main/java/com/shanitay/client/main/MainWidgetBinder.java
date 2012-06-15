package com.shanitay.client.main;

import com.google.gwt.core.client.GWT;
import com.shanitay.client.AbstractSvgWidgetBinder;
import com.shanitay.client.utils.Toy;
import com.shanitay.client.utils.Utils;
import org.vectomatic.dom.svg.OMSVGSVGElement;
import org.vectomatic.dom.svg.ui.SVGResource;

/**
 * Created By: Itay Sabato<br/>
 * Date: 19/05/12 <br/>
 * Time: 20:24 <br/>
 */
public class MainWidgetBinder extends AbstractSvgWidgetBinder {

    private SoundLoader soundLoader;
    private ElementLoader elementLoader;
    private AnimationLoader animationLoader;

    protected OMSVGSVGElement bindWidgets() {
        final OMSVGSVGElement svgElement = getSvg();
        soundLoader = new SoundLoader();
        elementLoader = new ElementLoader(svgElement);
        animationLoader = new AnimationLoader(elementLoader);

        bindBlackCube();
        bindGreenLine();
        bindRedLine();
        bindIgulColors();

        return svgElement;
    }

    private void bindRedLine() {
        Utils.attachToy(elementLoader.redLine, soundLoader.redLine, false, animationLoader.redLine);
    }

    private void bindGreenLine() {
        Utils.attachToy(elementLoader.greenLineDown, soundLoader.greenLineDown, false, animationLoader.greenLineDown);
    }

    private void bindIgulColors() {
        final Toy toy = Utils.attachToy(elementLoader.igulColor1, soundLoader.igulColor, true, animationLoader.igulColor);
        toyStopperHandler toyStopperHandler = new MainWidgetBinder.toyStopperHandler(toy);
        Utils.addHandler(elementLoader.igulColor2, toyStopperHandler);
        Utils.addHandler(elementLoader.igulColor3, toyStopperHandler);
        Utils.addHandler(elementLoader.igulColor4, toyStopperHandler);
    }

    private void bindBlackCube() {
        Utils.attachToy(elementLoader.blackCube, soundLoader.blackCube, false, animationLoader.blackCube);
    }

    private OMSVGSVGElement getSvg() {
        MainBundle mainBundle = GWT.create(MainBundle.class);
        final SVGResource svgResource = mainBundle.mainSvg();
        return svgResource.getSvg();
    }

    private static class toyStopperHandler implements Utils.SomeHandler {
        private final Toy toy;

        public toyStopperHandler(Toy toy) {
            this.toy = toy;
        }

        public void handle() {
            toy.stop();
        }
    }
}
