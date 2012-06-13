package com.shanitay.client.clip;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;

/**
 * Created By: Itay Sabato<br/>
 * Date: 05/05/12 <br/>
 * Time: 02:39 <br/>
 */
public class ClipWidget extends Composite {

    interface ClipWidgetUiBinder extends UiBinder<Widget, ClipWidget> {}

    private static final ClipWidgetUiBinder uiBinder = GWT.create(ClipWidgetUiBinder.class);

    public ClipWidget() {
        initWidget(uiBinder.createAndBindUi(this));
    }
}