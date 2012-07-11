package com.shanitay.client.credits;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;

/**
 * Created By: Itay Sabato<br/>
 * Date: 05/05/12 <br/>
 * Time: 02:39 <br/>
 */
public class CreditsWidget extends Composite {

    interface CreditsWidgetUiBinder extends UiBinder<Widget, CreditsWidget> {}

    private static final CreditsWidgetUiBinder uiBinder = GWT.create(CreditsWidgetUiBinder.class);

    public CreditsWidget() {
        initWidget(uiBinder.createAndBindUi(this));
    }
}