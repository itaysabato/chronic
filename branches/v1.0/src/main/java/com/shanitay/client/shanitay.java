package com.shanitay.client;

import com.allen_sauer.gwt.log.client.Log;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.user.client.History;
import com.google.gwt.user.client.ui.Hyperlink;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.shanitay.client.pilot.PilotWidgetBinder;
import com.shanitay.client.robot.RobotWidgetBinder;

public class shanitay implements EntryPoint {

    private MyNewWidget myNewWidget;
    private VerticalPanel mainPage;
    private final PilotWidgetBinder pilotWidgetBinder;
    private final RobotWidgetBinder robotWidgetBinder;

    public shanitay() {
        pilotWidgetBinder = new PilotWidgetBinder();
        robotWidgetBinder = new RobotWidgetBinder();
    }

    public void onModuleLoad() {
        try {
            myNewWidget = new MyNewWidget();
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
        if(historyToken == null || historyToken.isEmpty()){
            RootPanel.get().add(mainPage);
        }
        else if(historyToken.equalsIgnoreCase("pilot")){
            myNewWidget.init(pilotWidgetBinder);
            RootPanel.get().add(myNewWidget);
        }
        else if(historyToken.equalsIgnoreCase("robot")){
            myNewWidget.init(robotWidgetBinder);
            RootPanel.get().add(myNewWidget);
        }
    }
}
