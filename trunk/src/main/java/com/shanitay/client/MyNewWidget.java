package com.shanitay.client;

import com.allen_sauer.gwt.voices.client.Sound;
import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.SimplePanel;
import com.google.gwt.user.client.ui.Widget;
import org.vectomatic.dom.svg.OMSVGGElement;
import org.vectomatic.dom.svg.OMSVGSVGElement;
import org.vectomatic.dom.svg.ui.SVGResource;

/**
 * Created By: Itay Sabato<br/>
 * Date: 05/05/12 <br/>
 * Time: 02:39 <br/>
 */
public class MyNewWidget extends Composite {

    public static final int BG_INTERVAL = 125;

    interface MyNewWidgetUiBinder extends UiBinder<Widget, MyNewWidget> {}

    private static final MyNewWidgetUiBinder uiBinder = GWT.create(MyNewWidgetUiBinder.class);
    private static final SVGBundle svgBundle = GWT.create(SVGBundle.class);

    @UiField
    SimplePanel panel;
    private final OMSVGSVGElement svgElement;

    public MyNewWidget() {
        initWidget(uiBinder.createAndBindUi(this));

        final SVGResource svgResource = svgBundle.mainSvg();
        svgElement = svgResource.getSvg();
        final MySVGWidget widget = new MySVGWidget(svgElement);
        panel.add(widget);

        bindWidgets();
    }

    private void bindWidgets() {
        final SoundLoader soundLoader = new SoundLoader();
        final ElementLoader elementLoader = new ElementLoader(svgElement);
        final AnimationLoader animationLoader = new AnimationLoader(elementLoader);

        attachToy(elementLoader.getTongue(), soundLoader.getTongue(), animationLoader.getTongue(), true);
        attachToy(elementLoader.getMouthThin(), soundLoader.getMouth(), animationLoader.getMouth(), false);
        attachToy(elementLoader.getLeftSocket(), soundLoader.getLeftEye(), animationLoader.getLeftEye(), false);
        attachToy(elementLoader.getRightSocket(), soundLoader.getRightEye(), animationLoader.getRightEye(), false);

        final Toy bgToy = attachToy(elementLoader.getBg(), soundLoader.getBg(), animationLoader.getBg(), true);
        stopToy(elementLoader.getBg1(), bgToy);
        stopToy(elementLoader.getBg2(), bgToy);
        stopToy(elementLoader.getBg3(), bgToy);
        stopToy(elementLoader.getBg4(), bgToy);

        final Toy noseToy = attachToy(elementLoader.getNose(), soundLoader.getNose(), animationLoader.getNose(), true);
        stopToy(elementLoader.getNose1(), noseToy);
        stopToy(elementLoader.getNose2(), noseToy);
        stopToy(elementLoader.getNose3(), noseToy);
        stopToy(elementLoader.getNose4(), noseToy);
        stopToy(elementLoader.getNose5(), noseToy);
    }

    private void stopToy(OMSVGGElement element, final Toy toy) {
        Utils.addHandler(element, new Utils.SomeHandler() {
            public void handle() {
                toy.stop();
            }
        });
    }

    private Toy attachToy(OMSVGGElement element, Sound sound, Toy.Animation animation, boolean looping) {
        final Toy toy = new Toy(sound, animation);
        toy.setLooping(looping);

        Utils.addHandler(element, new Utils.SomeHandler() {
            public void handle() {
                toy.toggle();
            }
        });

        return toy;
    }

//    private void bindBalls() {
//        final SvgToyAnimation ballFlyAnimation = createAnimationToy("ballFlyAnimation", 2);
//
//        final Toy.Animation animation = new Toy.Animation() {
//            public void setLooping(boolean looping) {
//                ballFlyAnimation.setLooping(looping);
//            }
//
//            public void play() {
//                final OMSVGAnimationElement svgAnimationElement = ballFlyAnimation.getSvgAnimationElement();
//                svgAnimationElement.setAttribute("xlink:href", "#ball" + (Random.nextInt(3) + 1));
//                ballFlyAnimation.play();
//            }
//
//            public void stop() {
//                ballFlyAnimation.stop();
//            }
//        };
//
//        ballsButton = getGElement("ballsButton");
//        bindToy(ballsButton, animation, "yeah.mp3", false);
//    }

    public class MySVGWidget extends Widget {
        public MySVGWidget(OMSVGSVGElement svg) {
            setElement(svg.getElement());
        }
    }
}