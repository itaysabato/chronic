package com.shanitay.client;

import com.allen_sauer.gwt.log.client.Log;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.event.shared.UmbrellaException;
import com.google.gwt.user.client.History;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.Widget;

import java.util.Set;

public class shanitay implements EntryPoint {

    public void onModuleLoad() {
        try {
            GWT.setUncaughtExceptionHandler(new GWT.UncaughtExceptionHandler() {
                public void onUncaughtException(Throwable e) {
                    Log.error("Uncaught exception caught.", e);
                    handleThrowable(e);
                }
            });

            History.addValueChangeHandler(new ValueChangeHandler<String>() {
                public void onValueChange(ValueChangeEvent<String> stringValueChangeEvent) {
                    final String historyToken = stringValueChangeEvent.getValue();
                    setView(historyToken);
                }
            });

            setView(History.getToken());
        }
        catch (Throwable e) {
            Log.error("Failed to load module.", e);
            handleThrowable(e);
        }
    }

    private void handleThrowable(Throwable e) {
        if(e instanceof UmbrellaException){
            Set<Throwable> causes = ((UmbrellaException) e).getCauses();
            for (Throwable cause : causes) {
                Log.error("Umbrella caused by:", cause);
            }
        }
    }

    private void setView(String historyToken) {
        RootPanel.get().clear();
        WidgetBinder widgetBinder = PlaceType.MAIN.getWidgetBinder();

        if(historyToken != null && !historyToken.isEmpty()){
            String upperToken = historyToken.toUpperCase();

            try {
                PlaceType placeType = PlaceType.valueOf(upperToken);
                widgetBinder = placeType.getWidgetBinder();
            }
            catch (IllegalArgumentException e) {
                // ignore
            }
        }

        Widget widget = widgetBinder.initWidget();
        RootPanel.get().add(widget);
    }
}
