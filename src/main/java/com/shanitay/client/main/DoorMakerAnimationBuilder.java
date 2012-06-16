package com.shanitay.client.main;

import com.shanitay.client.utils.Toy;
import com.shanitay.client.utils.Utils;
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
    private boolean ignore = false;
    private ElementLoader animationLoader;

    public DoorMakerAnimationBuilder(ElementLoader elementLoader) {
        this.animationLoader = elementLoader;
        makerMove = elementLoader.getAnimation("makerMove");
        final OMSVGAnimationElement doorVanishAnimation = elementLoader.getAnimation("doorVanish");

        moonGif1 = elementLoader.getAnimation("moonGif1");

        doorVanishAnimation.addEndHandler(new EndHandler() {
            public void onEnd(EndEvent event) {
                continueGif = true;
                moonGif1.beginElement();
                ignore = false;
            }
        });

        final OMSVGAnimationElement doorReturn = elementLoader.getAnimation("doorReturn");

        doorReturn.addEndHandler(new EndHandler() {
            public void onEnd(EndEvent event) {
                continueGif = false;
                ignore = false;
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
                }
                else {
                    doorReturn.beginElement();
                }
            }
        });
    }

    public Toy.Animation getPinkButton() {
        return new Toy.Animation() {
            public void setLooping(boolean looping) {
                //To change body of implemented methods use File | Settings | File Templates.
            }

            public void play() {
                if (!ignore) {
                    ignore = true;
                    Utils.show(animationLoader.redButton);
                    makerMove.beginElement();
                    vanishDoor = false;
                }
            }

            public void stop() {
                //To change body of implemented methods use File | Settings | File Templates.
            }
        };
    }

    public Toy.Animation getRedButton() {
        return new Toy.Animation() {
            public void setLooping(boolean looping) {
                //To change body of implemented methods use File | Settings | File Templates.
            }

            public void play() {
                if (!ignore) {
                    ignore = true;
                    Utils.hide(animationLoader.redButton);
                    makerMove.beginElement();
                    vanishDoor = true;
                }
            }

            public void stop() {

            }
        };
    }
}
