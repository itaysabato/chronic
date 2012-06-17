package com.shanitay.client.trailer;

import com.google.gwt.user.client.ui.Widget;
import com.shanitay.client.WidgetBinder;

/**
 * Created By: Itay Sabato<br/>
 * Date: 13/06/12 <br/>
 * Time: 20:49 <br/>
 */
public class TrailerWidgetBinder implements WidgetBinder {

    public Widget initWidget() {
        return new TrailerWidget();
    }
}
