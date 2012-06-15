package com.shanitay.client.main;

import com.google.gwt.core.client.GWT;
import com.shanitay.client.AbstractSvgWidgetBinder;
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
        Utils.attachToy(elementLoader.greenLineDown, soundLoader.greenLineDown, false, animationLoader.greenLineDown);
        Utils.attachToy(elementLoader.redLine, soundLoader.redLine, false, animationLoader.redLine);


        return svgElement;
    }

    private void bindBlackCube() {
        Utils.attachToy(elementLoader.blackCube, soundLoader.blackCube, false, animationLoader.blackCube);
    }

    private OMSVGSVGElement getSvg() {
        MainBundle mainBundle = GWT.create(MainBundle.class);
        final SVGResource svgResource = mainBundle.mainSvg();
        return svgResource.getSvg();
    }
}
