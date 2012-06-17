package com.shanitay.client.trailer;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;

/**
 * Created By: Itay Sabato<br/>
 * Date: 05/05/12 <br/>
 * Time: 02:39 <br/>
 */
public class TrailerWidget extends Composite {

    interface TrailerWidgetUiBinder extends UiBinder<Widget, TrailerWidget> {}

    private static final TrailerWidgetUiBinder uiBinder = GWT.create(TrailerWidgetUiBinder.class);

    public TrailerWidget() {
        initWidget(uiBinder.createAndBindUi(this));
    }
}