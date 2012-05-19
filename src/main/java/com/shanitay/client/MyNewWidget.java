package com.shanitay.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.SimplePanel;
import com.google.gwt.user.client.ui.Widget;
import org.vectomatic.dom.svg.OMSVGSVGElement;

/**
 * Created By: Itay Sabato<br/>
 * Date: 05/05/12 <br/>
 * Time: 02:39 <br/>
 */
public class MyNewWidget extends Composite {

    interface MyNewWidgetUiBinder extends UiBinder<Widget, MyNewWidget> {}

    private static final MyNewWidgetUiBinder uiBinder = GWT.create(MyNewWidgetUiBinder.class);

    @UiField
    SimplePanel panel;

    public MyNewWidget() {
        initWidget(uiBinder.createAndBindUi(this));
    }

    public void init(WidgetBinder widgetBinder) {
        panel.clear();
        final OMSVGSVGElement svgElement = widgetBinder.bindWidgets();
        final MySVGWidget widget = new MySVGWidget(svgElement);
        panel.add(widget);
    }

    public class MySVGWidget extends Widget {
        public MySVGWidget(OMSVGSVGElement svg) {
            setElement(svg.getElement());
        }
    }
}