package com.shanitay.client;

import com.google.gwt.user.client.ui.Hyperlink;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;

/**
 * Created By: Itay Sabato<br/>
 * Date: 13/06/12 <br/>
 * Time: 20:21 <br/>
 */
public class DefaultWidgetBinder implements WidgetBinder {

    public Widget initWidget() {
        VerticalPanel panel = new VerticalPanel();

        for (PlaceType placeType : PlaceType.values()) {
            String lowerName = placeType.name().toLowerCase();
            Hyperlink hyperlink = new Hyperlink(lowerName, placeType.name());
            panel.add(hyperlink);
        }
        return panel;
    }
}
