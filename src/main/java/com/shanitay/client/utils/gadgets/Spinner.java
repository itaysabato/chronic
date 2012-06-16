package com.shanitay.client.utils.gadgets;

import com.allen_sauer.gwt.voices.client.Sound;
import com.allen_sauer.gwt.voices.client.handler.PlaybackCompleteEvent;
import com.allen_sauer.gwt.voices.client.handler.SoundHandler;
import com.allen_sauer.gwt.voices.client.handler.SoundLoadStateChangeEvent;
import com.google.gwt.event.dom.client.*;
import com.shanitay.client.utils.Utils;
import org.vectomatic.dom.svg.OMSVGGElement;
import org.vectomatic.dom.svg.OMSVGMatrix;
import org.vectomatic.dom.svg.OMSVGPoint;
import org.vectomatic.dom.svg.OMSVGSVGElement;

/**
 * Created By: Itay Sabato<br/>
 * Date: 28/05/12 <br/>
 * Time: 00:11 <br/>
 */
public class Spinner {
    private boolean positivePlaying = false;
    private final Sound positiveSound;
    private boolean negativePlaying = false;
    private final Sound negativeSound;
    private OMSVGPoint center = null;
    private OMSVGPoint last = null;
    private float lastAngle = 0;
    private boolean dragging = false;

    private Float lowerBoundAngle= 0f;
    private Float upperBoundAngle = 360f;

    public Spinner(Sound positiveSound, Sound negativeSound) {
        this.positiveSound = positiveSound;
        this.negativeSound = negativeSound;

        positiveSound.addEventHandler(new SoundHandler() {
            public void onPlaybackComplete(PlaybackCompleteEvent event) {
                positivePlaying = false;
            }

            public void onSoundLoadStateChange(SoundLoadStateChangeEvent event) {
                //To change body of implemented methods use File | Settings | File Templates.
            }
        });

        negativeSound.addEventHandler(new SoundHandler() {
            public void onPlaybackComplete(PlaybackCompleteEvent event) {
                negativePlaying = false;
            }

            public void onSoundLoadStateChange(SoundLoadStateChangeEvent event) {
                //To change body of implemented methods use File | Settings | File Templates.
            }
        });
    }

    public void setBounds(Float lowerBoundAngle, Float upperBoundAngle){
        this.lowerBoundAngle = lowerBoundAngle;
        this.upperBoundAngle = upperBoundAngle;
    }

    public void init(final OMSVGGElement round, final OMSVGSVGElement svgElement, final float centerX, final float centerY) {
        center = svgElement.createSVGPoint(centerX, centerY);

        round.addMouseDownHandler(new MouseDownHandler() {
            public void onMouseDown(MouseDownEvent event) {
                event.preventDefault();
                last = getEventPoint(event, svgElement);
//                lastAngle = 0;
                dragging = true;
            }
        });

        round.addMouseUpHandler(new MouseUpHandler() {
            public void onMouseUp(MouseUpEvent event) {
                event.preventDefault();
                dragging = false;
                last = null;
//                lastAngle = 0;
            }
        });

        round.addMouseOutHandler(new MouseOutHandler() {
            public void onMouseOut(MouseOutEvent event) {
                event.preventDefault();
                dragging = false;
                last = null;
//                lastAngle = 0;
            }
        });

        round.addMouseMoveHandler(new MouseMoveHandler() {
            public void onMouseMove(MouseMoveEvent event) {
                event.preventDefault();

                if (dragging) {
                    OMSVGPoint svgPoint = getEventPoint(event, svgElement);
                    double angle = Utils.getAngle(svgPoint, last);

                    if (angle < 0 && !negativePlaying) {
                        negativePlaying = true;
                        negativeSound.play();
                        positiveSound.stop();
                    }
                    else if (angle > 0 && !positivePlaying) {
                        positivePlaying = true;
                        positiveSound.play();
                        negativeSound.stop();
                    }

                    last = svgPoint;
                    lastAngle = lastAngle + (float) angle;

                    if(lastAngle < 0){
                        lastAngle = 360 + (lastAngle);
                    }

                    if(lastAngle < lowerBoundAngle || upperBoundAngle < lastAngle){
                        if(angle < 0){
                            lastAngle = lowerBoundAngle;
                        }
                        else {
                            lastAngle = upperBoundAngle;
                        }
                    }

                    Utils.rotate(round, lastAngle, centerX, centerY);
                }
            }
        });
    }

    private OMSVGPoint getEventPoint(MouseEvent event, OMSVGSVGElement svgElement) {
        OMSVGMatrix ctm = svgElement.getScreenCTM();
        final OMSVGMatrix inverse = ctm.inverse();

        OMSVGPoint svgPoint = svgElement.createSVGPoint(event.getClientX(), event.getClientY());
        svgPoint = svgPoint.matrixTransform(inverse);
        svgPoint = svgPoint.substract(center);
        return svgPoint;
    }
}
