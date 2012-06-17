package com.shanitay.client.main;

import com.shanitay.client.utils.ShaniColors;
import com.shanitay.client.utils.Toy;
import com.shanitay.client.utils.animations.FillColorAnimator;
import com.shanitay.client.utils.animations.MultiToyAnimation;
import com.shanitay.client.utils.animations.PeekabooToyAnimation;
import com.shanitay.client.utils.animations.SvgToyAnimation;
import org.vectomatic.dom.svg.OMSVGAnimationElement;

/**
 * Created By: Itay Sabato<br/>
 * Date: 17/05/12 <br/>
 * Time: 20:05 <br/>
 */
class AnimationLoader {
    private final ElementLoader elementLoader;

    final Toy.Animation orangeCube;
    final Toy.Animation blueCube;
    final Toy.Animation blackCube;
    final Toy.Animation yellowMiddleCube;
    final Toy.Animation house;
    final Toy.Animation blueTriangle;
    final Toy.Animation redLine;
    final Toy.Animation yellowLineDown;
    final Toy.Animation greenLineDown;
    final Toy.Animation igulColor;
    final Toy.Animation pinkLine;
    final Toy.Animation squareColor;
    final Toy.Animation cube2Move;
    final Toy.Animation upTriIgul;
    final Toy.Animation pinkCube;
    final Toy.Animation coolIgul;
    final Toy.Animation partGreen;
    final Toy.Animation movingHouse;

    private final DoorMakerAnimationBuilder doorVanisherAnimation;
    final Toy.Animation pinkButton;
    final Toy.Animation redButton;
    final Toy.Animation colorDoor;

    public AnimationLoader(ElementLoader elementLoader) {
        this.elementLoader = elementLoader;

        orangeCube = createOrangeCube();
        blueCube = createBlueCube();
        pinkCube = createPinkCube();
        blackCube = createBlackCube();
        yellowMiddleCube = createYellowMiddleCube();
        house = createHouse();
        blueTriangle = createBlueTriangle();
        redLine = createRedLine();
        yellowLineDown = createYellowLineDown();
        greenLineDown = createGreenLineDown();
        igulColor = createIgulColor();
        pinkLine = createPinkLine();
        squareColor = createSquareColor();
        cube2Move = createCube2Move();
        upTriIgul = createUpTriIgul();
        coolIgul = createCoolIgul();
        partGreen = createPartGreen();
        movingHouse = createMovingHouse();
        colorDoor = createColorDoor();


        doorVanisherAnimation = new DoorMakerAnimationBuilder(elementLoader);
        pinkButton = doorVanisherAnimation.getPinkButton();
        redButton = doorVanisherAnimation.getRedButton();
    }

    private Toy.Animation createMovingHouse() {
        return getAnimation("movingHouseMove");
    }

    private Toy.Animation createPartGreen() {
        return getAnimation("partMove");
    }

    private Toy.Animation createCoolIgul() {
        String firstAnimationId = "coolIgulGif1";
        final String lastAnimationId = "coolIgulGif8";
        return getAnimationChain(firstAnimationId, lastAnimationId);
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

    private Toy.Animation createOrangeCube() {
        FillColorAnimator colorAnimator = new FillColorAnimator(ShaniColors.RED, ShaniColors.YELLOW);
        return new PeekabooToyAnimation(colorAnimator, 250, elementLoader.orangeCube);
    }

    private Toy.Animation createBlueCube() {
        FillColorAnimator colorAnimator = new FillColorAnimator(ShaniColors.TURQUOISE, ShaniColors.PINK);
        return new PeekabooToyAnimation(colorAnimator, 250, elementLoader.blueCube);
    }

    private Toy.Animation createPinkCube() {
        FillColorAnimator colorAnimator = new FillColorAnimator(ShaniColors.PINK, ShaniColors.RED);
        return new PeekabooToyAnimation(colorAnimator, 250, elementLoader.pinkCube);
    }

    private Toy.Animation createYellowMiddleCube() {
        FillColorAnimator colorAnimator = new FillColorAnimator(ShaniColors.YELLOW, ShaniColors.GREEN);
        return new PeekabooToyAnimation(colorAnimator, 250, elementLoader.yellowMiddleCube);
    }

    private Toy.Animation createBlackCube() {
        return getAnimation("moveBlackCube");
    }

    private Toy.Animation getAnimation(String elementId) {
        OMSVGAnimationElement animationElement = elementLoader.getAnimation(elementId);
        return new SvgToyAnimation(animationElement);
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

    private Toy.Animation createIgulColor() {
        String firstAnimationId = "igulColorGif1";
        final String lastAnimationId = "igulColorGif6";
        return getAnimationChain(firstAnimationId, lastAnimationId);
    }

    private Toy.Animation createColorDoor() {
        String firstAnimationId = "colorDoorGif1";
        final String lastAnimationId = "colorDoorGif8";
        return getAnimationChain(firstAnimationId, lastAnimationId);
    }
    private Toy.Animation getAnimationChain(String firstAnimationId, String lastAnimationId) {
        final OMSVGAnimationElement firstAnimation = elementLoader.getAnimation(firstAnimationId);
        final OMSVGAnimationElement lastAnimation = elementLoader.getAnimation(lastAnimationId);
        return new ChainedSvgAnimation(firstAnimation, lastAnimation);
    }

    private Toy.Animation createPinkLine() {
        return getAnimationChain("pinkLineExpand1", "pinkLineExpand2");
    }

}
