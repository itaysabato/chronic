package com.shanitay.client;

import com.shanitay.client.clip.ClipWidgetBinder;
import com.shanitay.client.main.MainWidgetBinder;
import com.shanitay.client.pilot.PilotWidgetBinder;
import com.shanitay.client.robot.RobotWidgetBinder;

/**
 * Created By: Itay Sabato<br/>
 * Date: 13/06/12 <br/>
 * Time: 18:57 <br/>
 */
public enum PlaceType {
    CLIP(new ClipWidgetBinder()),
    PLACES(new DefaultWidgetBinder()),
    MAIN(new MainWidgetBinder()),
    PILOT(new PilotWidgetBinder()),
    ROBOT(new RobotWidgetBinder()),
    TRAILER(new ClipWidgetBinder());

    private final transient WidgetBinder widgetBinder;

    private PlaceType(WidgetBinder widgetBinder) {
        this.widgetBinder = widgetBinder;
    }

    public WidgetBinder getWidgetBinder() {
        return widgetBinder;
    }
}
