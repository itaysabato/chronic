package com.shanitay.client.utils;

import org.vectomatic.dom.svg.OMSVGElement;

/**
* Created By: Itay Sabato<br/>
* Date: 20/05/12 <br/>
* Time: 01:55 <br/>
*/
public interface StateChangeAnimator {
    void inAnimation(OMSVGElement target);
    void offAnimation(OMSVGElement target);
}
