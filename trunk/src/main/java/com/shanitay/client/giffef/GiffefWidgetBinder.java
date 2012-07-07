package com.shanitay.client.giffef;

import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ClientBundle;
import com.shanitay.client.AbstractSvgWidgetBinder;
import org.vectomatic.dom.svg.OMSVGSVGElement;
import org.vectomatic.dom.svg.ui.SVGResource;

/**
 * Created By: Itay Sabato<br/>
 * Date: 07/07/12 <br/>
 * Time: 17:22 <br/>
 */
public class GiffefWidgetBinder extends AbstractSvgWidgetBinder {
    @Override
    protected void shutdown() {

    }

    @Override
    protected OMSVGSVGElement bindWidgets() {
        GiffefBundle bundle = GWT.create(GiffefBundle.class);
        final SVGResource svg = bundle.svg();
        return svg.getSvg();
    }

    interface GiffefBundle extends ClientBundle {
        @Source("giffef.svg")
        @SVGResource.Validated(validated = false)
        SVGResource svg();
    }
}
