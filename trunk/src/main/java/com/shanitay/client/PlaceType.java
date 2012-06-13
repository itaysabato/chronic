package com.shanitay.client;

import com.shanitay.client.pilot.PilotWidgetBinder;
import com.shanitay.client.robot.RobotWidgetBinder;

/**
 * Created By: Itay Sabato<br/>
 * Date: 13/06/12 <br/>
 * Time: 18:57 <br/>
 */
public enum PlaceType {
    PLACES(new DefaultWidgetBinder()),
    MAIN(new DefaultWidgetBinder()),
    PILOT(new PilotWidgetBinder()),
    ROBOT(new RobotWidgetBinder());

    private final transient WidgetBinder widgetBinder;

    private PlaceType(WidgetBinder widgetBinder) {
        this.widgetBinder = widgetBinder;
    }

    public WidgetBinder getWidgetBinder() {
        return widgetBinder;
    }
}
