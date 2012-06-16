package com.shanitay.client.utils.animations;

import com.shanitay.client.utils.Utils;
import org.vectomatic.dom.svg.OMSVGElement;

/**
* Created By: Itay Sabato<br/>
* Date: 20/05/12 <br/>
* Time: 01:57 <br/>
*/
public enum AnimatorImpls implements StateChangeAnimator {
   APPEAR {
       public void inAnimation(OMSVGElement target) {
           Utils.show(target);
       }

       public void offAnimation(OMSVGElement target) {
           Utils.hide(target);
       }
   },

   DISAPPEAR {
       public void inAnimation(OMSVGElement target) {
           Utils.hide(target);
       }

       public void offAnimation(OMSVGElement target) {
           Utils.show(target);
       }
   }
}
