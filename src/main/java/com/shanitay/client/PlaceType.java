package com.shanitay.client;

import com.shanitay.client.clip.ClipWidgetBinder;
import com.shanitay.client.giffef.GiffefWidgetBinder;
import com.shanitay.client.main.MainWidgetBinder;
import com.shanitay.client.pilot.PilotWidgetBinder;
import com.shanitay.client.robot.RobotWidgetBinder;
import com.shanitay.client.trailer.TrailerWidgetBinder;

/**
 * Created By: Itay Sabato<br/>
 * Date: 13/06/12 <br/>
 * Time: 18:57 <br/>
 */
public enum PlaceType {
    PLACES(new DefaultWidgetBinder()),
    PILOT(new PilotWidgetBinder()),
    MAIN(new MainWidgetBinder()),
    CLIP(new DelayWidgetBinder(6000, new GiffefWidgetBinder(), new ClipWidgetBinder())),
    ROBOT(new RobotWidgetBinder()),
    TRAILER(new DelayWidgetBinder(6000, new GiffefWidgetBinder(), new TrailerWidgetBinder()));

    private final transient WidgetBinder widgetBinder;

    private PlaceType(WidgetBinder widgetBinder) {
        this.widgetBinder = widgetBinder;
    }

    public WidgetBinder getWidgetBinder() {
        return widgetBinder;
    }
}
