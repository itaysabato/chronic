package com.shanitay.client.utils;

import org.vectomatic.dom.svg.OMSVGGElement;

/**
* Created By: Itay Sabato<br/>
* Date: 20/05/12 <br/>
* Time: 01:57 <br/>
*/
public enum AnimatorImpls implements StateChangeAnimator {
   APPEAR {
       public void inAnimation(OMSVGGElement target) {
           Utils.show(target);
       }

       public void offAnimation(OMSVGGElement target) {
           Utils.hide(target);
       }
   },

   DISAPPEAR {
       public void inAnimation(OMSVGGElement target) {
           Utils.hide(target);
       }

       public void offAnimation(OMSVGGElement target) {
           Utils.show(target);
       }
   }
}
