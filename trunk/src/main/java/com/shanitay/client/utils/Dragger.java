package com.shanitay.client.utils;

import com.allen_sauer.gwt.voices.client.Sound;
import com.google.gwt.event.dom.client.*;
import org.vectomatic.dom.svg.OMSVGGElement;
import org.vectomatic.dom.svg.OMSVGMatrix;
import org.vectomatic.dom.svg.OMSVGPoint;
import org.vectomatic.dom.svg.OMSVGSVGElement;

/**
 * Created By: Itay Sabato<br/>
 * Date: 28/05/12 <br/>
 * Time: 00:11 <br/>
 */
public class Dragger {
    private final OMSVGSVGElement container;
    private final OMSVGPoint start;
    private final OMSVGPoint end;

    private boolean dragging = false;
    private OMSVGPoint lastTouch = null;
    private final OMSVGPoint lastTranslation;
    private final OMSVGPoint transformationVector;
    private OMSVGGElement target;

    private Sound forwardSound = null;
    private Sound backwardSound = null;

    public Dragger(OMSVGSVGElement container, float startX, float startY, float endX, float endY) {
        this.container = container;
        start = container.createSVGPoint(startX, startY);
        end = container.createSVGPoint(endX, endY);
        lastTranslation = container.createSVGPoint(start);
        transformationVector = container.createSVGPoint();
    }

    public void makeDraggable(final OMSVGGElement target, Sound forwardSound, Sound backwardSound) {
        this.target = target;
        this.forwardSound = forwardSound;
        this.backwardSound = backwardSound;

        translate(start.getX(), start.getY());

        this.target.addMouseDownHandler(new MouseDownHandler() {
            public void onMouseDown(MouseDownEvent event) {
                event.preventDefault();
                lastTouch = getEventPoint(event);
                dragging = true;
            }
        });

        this.target.addMouseUpHandler(new MouseUpHandler() {
            public void onMouseUp(MouseUpEvent event) {
                event.preventDefault();
                dragging = false;
                lastTouch = null;
            }
        });

        this.target.addMouseOutHandler(new MouseOutHandler() {
            public void onMouseOut(MouseOutEvent event) {
                event.preventDefault();
                dragging = false;
                lastTouch = null;
            }
        });

        this.target.addMouseMoveHandler(new MouseMoveHandler() {
            public void onMouseMove(MouseMoveEvent event) {
                event.preventDefault();

                if (dragging) {
                    OMSVGPoint currentTouch = getEventPoint(event);
//                    Log.debug("******* before current touch: "+currentTouch.getX()+","+currentTouch.getY());
                    transformationVector.setX(currentTouch.getX());
                    transformationVector.setY(currentTouch.getY());
                    transformationVector.substract(lastTouch);
//                    Log.debug("******* after last touch: " + lastTouch.getX() + "," + lastTouch.getY());
                    translateAlongAxis();
                    lastTouch = currentTouch;
                }
            }
        });
    }

    private void translateAlongAxis() {
        float newY = lastTranslation.getY() + transformationVector.getY();
        float newX = lastTranslation.getX();

        if(newY > end.getY()){
            newY = end.getY();
        }
        if (newY < start.getY()) {
            newY = start.getY();
        }

        float dy = newY - lastTranslation.getY();

        if(dy > 0) {
            forwardSound.play();
        }
        else if(dy < 0) {
            backwardSound.play();
        }
//        Log.debug("---------------------------------------------------------------------------------------------------------");
//        Log.debug("transformation: " + transformationVector.getX() + "," + transformationVector.getY());
//        Log.debug("new translation: " + newY + "," + newX);
//        Log.debug("last touch: "+lastTouch.getX()+","+lastTouch.getY());
//        Log.debug("last translation: " + lastTouch.getX() + "," + lastTouch.getY());
//        Log.debug("Moved y by: "+dy);

        translate(newX, newY);
    }

    private void translate(float newX, float newY) {
        lastTranslation.setX(newX);
        lastTranslation.setY(newY);
        Utils.translate(target, lastTranslation.getX(), lastTranslation.getY());
    }

    private OMSVGPoint getEventPoint(MouseEvent event) {
        OMSVGMatrix ctm = container.getScreenCTM();
        final OMSVGMatrix inverse = ctm.inverse();

        OMSVGPoint svgPoint = container.createSVGPoint(event.getClientX(), event.getClientY());
        svgPoint = svgPoint.matrixTransform(inverse);
        return svgPoint;
    }
}
