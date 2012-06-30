package com.shanitay.client;

import com.google.gwt.core.client.Scheduler;
import com.google.gwt.user.client.ui.SimplePanel;
import com.google.gwt.user.client.ui.Widget;

/**
 * Created By: Itay Sabato<br/>
 * Date: 30/06/12 <br/>
 * Time: 21:20 <br/>
 */
public class DelayWidgetBinder implements WidgetBinder {
    private final int delayMillis;
    private final WidgetBinder firstBinder;
    private final WidgetBinder secondBinder;

    private final SimplePanel panel = new MySimplePanel();

    public DelayWidgetBinder(int delayMillis, WidgetBinder firstBinder, WidgetBinder secondBinder) {
        this.delayMillis = delayMillis;
        this.firstBinder = firstBinder;
        this.secondBinder = secondBinder;
    }

    public Widget initWidget() {
        return panel;
    }

    private class MySimplePanel extends SimplePanel {
        @Override
        protected void onAttach() {
            super.onAttach();

            clear();
            add(firstBinder.initWidget());

            Scheduler.get().scheduleFixedDelay(new Scheduler.RepeatingCommand() {
                public boolean execute() {
                    clear();
                    add(secondBinder.initWidget());

                    return false;
                }
            }, delayMillis);
        }
    }
}
