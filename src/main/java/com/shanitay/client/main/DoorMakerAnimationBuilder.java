package com.shanitay.client.main;

import com.allen_sauer.gwt.voices.client.Sound;
import com.shanitay.client.utils.ShaniColors;
import com.shanitay.client.utils.Toy;
import com.shanitay.client.utils.Utils;
import com.shanitay.client.utils.animations.FillColorAnimator;
import org.vectomatic.dom.svg.OMSVGAnimationElement;
import org.vectomatic.dom.svg.events.EndEvent;
import org.vectomatic.dom.svg.events.EndHandler;

/**
* Created By: Itay Sabato<br/>
* Date: 17/06/12 <br/>
* Time: 01:13 <br/>
*/
class DoorMakerAnimationBuilder {
    private final OMSVGAnimationElement makerMove;
    private final OMSVGAnimationElement moonGif1;
    private boolean continueGif = false;
    private boolean vanishDoor = false;
    private boolean playing = false;
    private boolean stopping = false;

    private ElementLoader elementLoader;
    private final Toy.Animation pinkAnimation = new Toy.Animation() {
        public void setLooping(boolean looping) {
            //To change body of implemented methods use File | Settings | File Templates.
        }

        public void play() {
            sound.play();
            makerMove.beginElement();
            vanishDoor = false;
        }

        public void stop() {
            //To change body of implemented methods use File | Settings | File Templates.
        }
    };
    private final DoorMakerToyAnimation redAnimation = new DoorMakerToyAnimation();
    private Sound sound = null;

    public DoorMakerAnimationBuilder(final ElementLoader elementLoader) {
        this.elementLoader = elementLoader;
        makerMove = elementLoader.getAnimation("makerMove");
        final OMSVGAnimationElement doorVanishAnimation = elementLoader.getAnimation("doorVanish");

        moonGif1 = elementLoader.getAnimation("moonGif1");

        final FillColorAnimator fillColorAnimator = new FillColorAnimator(ShaniColors.LIGHT_BLUE, ShaniColors.YELLOW);

        doorVanishAnimation.addEndHandler(new EndHandler() {
            public void onEnd(EndEvent event) {
                continueGif = true;
                moonGif1.beginElement();
                pinkAnimation.play();
            }
        });

        final OMSVGAnimationElement doorReturn = elementLoader.getAnimation("doorReturn");

        doorReturn.addEndHandler(new EndHandler() {
            public void onEnd(EndEvent event) {
                fillColorAnimator.offAnimation(elementLoader.doorRect);
                continueGif = false;
                if (!stopping) {
                    innerRedPlay();
                }
                else {
                    playing = false;
                    stopping = false;
                }
            }
        });

        OMSVGAnimationElement moonGif13 = elementLoader.getAnimation("moonGif13");
        moonGif13.addEndHandler(new EndHandler() {
            public void onEnd(EndEvent event) {
                if (continueGif) {
                    moonGif1.beginElement();
                }
            }
        });

        makerMove.addEndHandler(new EndHandler() {
            public void onEnd(EndEvent event) {
                if (vanishDoor) {
                    doorVanishAnimation.beginElement();
                    fillColorAnimator.inAnimation(elementLoader.doorRect);
                }
                else {
                    doorReturn.beginElement();
                }
            }
        });
    }

    private void innerRedPlay() {
        sound.play();
        makerMove.beginElement();
        vanishDoor = true;
    }

    public Toy.Animation getPinkButton() {
        return pinkAnimation;
    }

    public DoorMakerToyAnimation getRedButton() {
        return redAnimation;
    }

    public class DoorMakerToyAnimation implements Toy.Animation {
        public void setSound(Sound sound) {
            DoorMakerAnimationBuilder.this.sound = sound;
        }

        public void setLooping(boolean looping) {
            //To change body of implemented methods use File | Settings | File Templates.
        }

        public void play() {
            if (!playing) {
                Utils.hide(elementLoader.redButton);
                playing = true;
                innerRedPlay();
            }
            else {
                Utils.show(elementLoader.redButton);
                stopping = true;
            }
        }

        public void stop() {

        }
    }
}
