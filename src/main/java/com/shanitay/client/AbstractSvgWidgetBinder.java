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

        final MyNewWidget myNewWidget = new MyNewWidget() {
            @Override
            protected void onDetach() {
                super.onDetach();
                shutdown();
            }
        };

        myNewWidget.init(element);
        return myNewWidget;
    }

    protected abstract void shutdown();

    protected abstract OMSVGSVGElement bindWidgets();

}
