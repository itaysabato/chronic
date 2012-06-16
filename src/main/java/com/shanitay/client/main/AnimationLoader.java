package com.shanitay.client.main;

import com.shanitay.client.utils.MultiToyAnimation;
import com.shanitay.client.utils.SvgToyAnimation;
import com.shanitay.client.utils.Toy;
import org.vectomatic.dom.svg.OMSVGAnimationElement;
import org.vectomatic.dom.svg.events.EndEvent;
import org.vectomatic.dom.svg.events.EndHandler;

/**
 * Created By: Itay Sabato<br/>
 * Date: 17/05/12 <br/>
 * Time: 20:05 <br/>
 */
class AnimationLoader {
    private final ElementLoader elementLoader;

    final Toy.Animation slide;
    final Toy.Animation watchRight;
    final Toy.Animation orangeCube;
    final Toy.Animation blueCube;
    final Toy.Animation blackCube;
    final Toy.Animation yellowMiddleCube;
    final Toy.Animation house;
    final Toy.Animation blueTriangle;
    final Toy.Animation redLine;
    final Toy.Animation yellowLineDown;
    final Toy.Animation greenLineDown;
    final Toy.Animation pinkButton;
    final Toy.Animation redButton;
    final Toy.Animation igulColor;
    final Toy.Animation pinkLine;
    final Toy.Animation squareColor;
    final Toy.Animation cube2Move;
    final Toy.Animation upTriIgul;

    public AnimationLoader(ElementLoader elementLoader) {
        this.elementLoader = elementLoader;

        slide = createSlide();
        watchRight = createWatchRight();
        orangeCube = createOrangeCube();
        blueCube = createBlueCube();
        blackCube = createBlackCube();
        yellowMiddleCube = createYellowMiddleCube();
        house = createHouse();
        blueTriangle = createBlueTriangle();
        redLine = createRedLine();
        yellowLineDown = createYellowLineDown();
        greenLineDown = createGreenLineDown();
        pinkButton = createPinkButton();
        redButton = createRedButton();
        igulColor = createIgulColor();
        pinkLine = createPinkLine();
        squareColor = createSquareColor();
        cube2Move = createCube2Move();
        upTriIgul = createUpTriIgul();
    }

    private Toy.Animation createUpTriIgul() {
        Toy.Animation animationChain = getAnimationChain("triHandleRotation1", "triHandleRotation2");
        Toy.Animation triRotation = getAnimation("triRotation");
        return new MultiToyAnimation(triRotation, animationChain);
    }

    private SvgToyAnimation createCube2Move() {
        return new SvgToyAnimation(this.elementLoader.getAnimation("cube2Move"));
    }

    private Toy.Animation createSquareColor() {
        return getAnimationChain("squareColorChange1", "squareColorChange6");
    }

    private Toy.Animation createSlide() {
        return null;  //To change body of created methods use File | Settings | File Templates.
    }

    private Toy.Animation createWatchRight() {
        return null;  //To change body of created methods use File | Settings | File Templates.
    }

    private Toy.Animation createOrangeCube() {
        return null;  //To change body of created methods use File | Settings | File Templates.
    }

    private Toy.Animation createBlueCube() {
        return null;  //To change body of created methods use File | Settings | File Templates.
    }

    private Toy.Animation createBlackCube() {
        return getAnimation("moveBlackCube");
    }

    private Toy.Animation getAnimation(String elementId) {
        OMSVGAnimationElement animationElement = elementLoader.getAnimation(elementId);
        return new SvgToyAnimation(animationElement);
    }

    private Toy.Animation createYellowMiddleCube() {
        return null;  //To change body of created methods use File | Settings | File Templates.
    }

    private Toy.Animation createHouse() {
        return null;  //To change body of created methods use File | Settings | File Templates.
    }

    private Toy.Animation createBlueTriangle() {
        return null;  //To change body of created methods use File | Settings | File Templates.
    }

    private Toy.Animation createRedLine() {
        return getAnimation("redLineMove");
    }

    private Toy.Animation createYellowLineDown() {
        return null;  //To change body of created methods use File | Settings | File Templates.
    }

    private Toy.Animation createGreenLineDown() {
        return getAnimation("greenLineMove");
    }

    private Toy.Animation createPinkButton() {
        return null;  //To change body of created methods use File | Settings | File Templates.
    }

    private Toy.Animation createRedButton() {
        return null;  //To change body of created methods use File | Settings | File Templates.
    }

    private Toy.Animation createIgulColor() {
        String firstAnimationId = "igulColorGif1";
        final String lastAnimationId = "igulColorGif6";
        return getAnimationChain(firstAnimationId, lastAnimationId);
    }

    private Toy.Animation getAnimationChain(String firstAnimationId, String lastAnimationId) {
        final OMSVGAnimationElement firstAnimation = elementLoader.getAnimation(firstAnimationId);
        final OMSVGAnimationElement lastAnimation = elementLoader.getAnimation(lastAnimationId);
        return new GifSvgAnimation(firstAnimation, lastAnimation);
    }

    private Toy.Animation createPinkLine() {
        return null;  //To change body of created methods use File | Settings | File Templates.
    }

    private static class GifSvgAnimation implements Toy.Animation {
        private final OMSVGAnimationElement firstAnimation;

        private boolean looping;
        private boolean playing;
        private boolean stopping;

        public GifSvgAnimation(OMSVGAnimationElement firstAnimation, OMSVGAnimationElement lastAnimation) {
            this.firstAnimation = firstAnimation;

            lastAnimation.addEndHandler(new EndHandler() {
                public void onEnd(EndEvent event) {
                    if(looping && !stopping){
                        GifSvgAnimation.this.firstAnimation.beginElement();
                    }
                    else {
                        playing = false;
                        stopping = false;
                    }
                }
            });

            looping = false;
            playing = false;
            stopping = false;
        }

        public void setLooping(boolean looping) {
            this.looping = looping;
        }

        public void play() {
            if(!playing) {
                playing = true;
                stopping = false;
                firstAnimation.beginElement();
            }
            else {
                stopping = false;
            }
        }

        public void stop() {
            stopping = true;
        }
    }
}
