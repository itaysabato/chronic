package com.shanitay.client.pilot;

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
public class PilotWidgetBinder extends AbstractSvgWidgetBinder {

    protected OMSVGSVGElement bindWidgets() {
        PilotBundle pilotBundle = GWT.create(PilotBundle.class);
        final SVGResource svgResource = pilotBundle.mainSvg();
        final OMSVGSVGElement svgElement = svgResource.getSvg();

        final SoundLoader soundLoader = new SoundLoader();
        final ElementLoader elementLoader = new ElementLoader(svgElement);
        final AnimationLoader animationLoader = new AnimationLoader(elementLoader);

        Utils.attachToy(elementLoader.getTongue(), soundLoader.getTongue(), true, animationLoader.getTongue());
        Utils.attachToy(elementLoader.getMouthThin(), soundLoader.getMouth(), false, animationLoader.getMouth());
        Utils.attachToy(elementLoader.getLeftSocket(), soundLoader.getLeftEye(), false, animationLoader.getLeftEye());
        Utils.attachToy(elementLoader.getRightSocket(), soundLoader.getRightEye(), false, animationLoader.getRightEye());

        final Toy bgToy = Utils.attachToy(elementLoader.getBg(), soundLoader.getBg(), true, animationLoader.getBg());
        Utils.stopToy(elementLoader.getBg1(), bgToy);
        Utils.stopToy(elementLoader.getBg2(), bgToy);
        Utils.stopToy(elementLoader.getBg3(), bgToy);
        Utils.stopToy(elementLoader.getBg4(), bgToy);

        final Toy noseToy = Utils.attachToy(elementLoader.getNose(), soundLoader.getNose(), true, animationLoader.getNose());
        Utils.stopToy(elementLoader.getNose1(), noseToy);
        Utils.stopToy(elementLoader.getNose2(), noseToy);
        Utils.stopToy(elementLoader.getNose3(), noseToy);
        Utils.stopToy(elementLoader.getNose4(), noseToy);
        Utils.stopToy(elementLoader.getNose5(), noseToy);

        Utils.attachToy(elementLoader.getBallsButton(), soundLoader.getBalls(), false, animationLoader.getBalls(), animationLoader.getBallScale());

        return svgElement;
    }

    @Override
    protected void shutdown() {

    }
}
