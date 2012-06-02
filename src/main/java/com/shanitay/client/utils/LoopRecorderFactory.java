package com.shanitay.client.utils;

import org.vectomatic.dom.svg.OMSVGGElement;
import org.vectomatic.dom.svg.OMSVGSVGElement;

/**
 * Created By: Itay Sabato<br/>
 * Date: 02/06/12 <br/>
 * Time: 16:26 <br/>
 */
public class LoopRecorderFactory {
    private static LoopRecorder recorder = null;

    public static boolean hasRecorder() {
        return recorder != null;
    }

    public static LoopRecorder getRecorder() {
        return recorder;
    }

    public static void initRecorder(LoopRecorder recorder, OMSVGSVGElement svgElement) {
        LoopRecorderFactory.recorder = recorder;

        final OMSVGGElement playEnabled = Utils.getGElement("playEnabled", svgElement);
        final OMSVGGElement playDisabled = Utils.getGElement("playDisabled", svgElement);
        final OMSVGGElement recordEnabled = Utils.getGElement("recordEnabled", svgElement);
        final OMSVGGElement recordDisabled = Utils.getGElement("recordDisabled", svgElement);
        OMSVGGElement stopPlaying = Utils.getGElement("stopPlaying", svgElement);
        OMSVGGElement stopRecording = Utils.getGElement("stopRecording", svgElement);

        Utils.show(playDisabled);
        Utils.hide(playEnabled);

        Utils.show(recordEnabled);
        Utils.hide(recordDisabled);

        Utils.addHandler(playEnabled, new Utils.SomeHandler() {
            public void handle() {
                Utils.hide(playDisabled);
                Utils.hide(playEnabled);
                Utils.show(recordDisabled);
                Utils.hide(recordEnabled);
                LoopRecorderFactory.recorder.playLoop();
            }
        });

        Utils.SomeHandler stopHandler = new Utils.SomeHandler() {
            public void handle() {
                Utils.hide(playDisabled);
                Utils.show(playEnabled);
                Utils.hide(recordDisabled);
                Utils.show(recordEnabled);
                LoopRecorderFactory.recorder.stop();
            }
        };
        Utils.addHandler(stopPlaying, stopHandler);
        Utils.addHandler(stopRecording, stopHandler);

        Utils.addHandler(recordEnabled, new Utils.SomeHandler() {
            public void handle() {
                Utils.hide(recordDisabled);
                Utils.hide(recordEnabled);
                Utils.show(playDisabled);
                Utils.hide(playEnabled);
                LoopRecorderFactory.recorder.startRecording();
            }
        });
    }
}
