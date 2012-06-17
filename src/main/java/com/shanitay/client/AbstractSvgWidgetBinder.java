package com.shanitay.client;

import com.google.gwt.user.client.ui.Widget;
import org.vectomatic.dom.svg.OMSVGSVGElement;

/**
 * Created By: Itay Sabato<br/>
 * Date: 13/06/12 <br/>
 * Time: 19:12 <br/>
 */
public abstract class AbstractSvgWidgetBinder implements WidgetBinder {

    public Widget initWidget() {
        OMSVGSVGElement element = bindWidgets();
        final MyNewWidget myNewWidget = new MyNewWidget();
        myNewWidget.init(element);
        return myNewWidget;
    }

    protected abstract OMSVGSVGElement bindWidgets();

}
