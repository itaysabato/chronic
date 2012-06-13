package com.shanitay.client;

import com.allen_sauer.gwt.log.client.Log;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.user.client.History;
import com.google.gwt.user.client.ui.Hyperlink;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;

public class shanitay implements EntryPoint {
    private VerticalPanel mainPage;

    public void onModuleLoad() {
        try {
            mainPage = new VerticalPanel();
            mainPage.add(new Hyperlink("Pilot", "Pilot"));
            mainPage.add(new Hyperlink("Robot", "Robot"));

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
        }
    }

    private void setView(String historyToken) {
        RootPanel.get().clear();
        Widget widget = mainPage;

        if(historyToken != null && !historyToken.isEmpty()){
            String upperToken = historyToken.toUpperCase();

            try {
                PlaceType placeType = PlaceType.valueOf(upperToken);
                widget = placeType.getWidgetBinder().initWidget();
            }
            catch (IllegalArgumentException e) {
                // ignore
            }
        }

        RootPanel.get().add(widget);
    }
}
