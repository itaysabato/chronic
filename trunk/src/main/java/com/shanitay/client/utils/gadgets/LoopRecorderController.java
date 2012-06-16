package com.shanitay.client.utils.gadgets;

import com.shanitay.client.utils.Utils;
import org.vectomatic.dom.svg.OMSVGGElement;
import org.vectomatic.dom.svg.OMSVGSVGElement;

/**
 * Created By: Itay Sabato<br/>
 * Date: 02/06/12 <br/>
 * Time: 23:29 <br/>
 */
public class LoopRecorderController {
    private LoopRecorder loopRecorder = null;

    private final OMSVGGElement playEnabled;
    private final OMSVGGElement playDisabled;
    private final OMSVGGElement recordEnabled;
    private final OMSVGGElement recordDisabled;
    private final OMSVGGElement stopPlaying;
    private final OMSVGGElement stopRecording;

    public LoopRecorderController(OMSVGSVGElement svgElement) {
        playEnabled = Utils.getGElement("playEnabled", svgElement);
        playDisabled = Utils.getGElement("playDisabled", svgElement);
        recordEnabled = Utils.getGElement("recordEnabled", svgElement);
        recordDisabled = Utils.getGElement("recordDisabled", svgElement);
        stopPlaying = Utils.getGElement("stopPlaying", svgElement);
        stopRecording = Utils.getGElement("stopRecording", svgElement);

        initHandlers();
    }

    public void setRecorder(LoopRecorder recorder) {
        if(loopRecorder != null && loopRecorder.getState() == LoopRecorder.State.RECORDING){
            loopRecorder.stop();
        }

        loopRecorder = recorder;

        switch (loopRecorder.getState()) {
            case INITIAL:
                setInitial();
                break;

            case RECORDING:
                setRecording();
                break;

            case PLAYING:
                setPlaying();
                break;

            case IDLE:
                setIdle();
                break;
        }
    }

    private void initHandlers() {
        Utils.addHandler(playEnabled, new Utils.SomeHandler() {
            public void handle() {
                setPlaying();
                loopRecorder.playLoop();
            }
        });

        Utils.SomeHandler stopHandler = new Utils.SomeHandler() {
            public void handle() {
                setIdle();
                loopRecorder.stop();
            }
        };
        Utils.addHandler(stopPlaying, stopHandler);
        Utils.addHandler(stopRecording, stopHandler);

        Utils.addHandler(recordEnabled, new Utils.SomeHandler() {
            public void handle() {
                setRecording();
                loopRecorder.startRecording();
            }
        });
    }

    private void setInitial() {
        Utils.show(playDisabled);
        Utils.hide(playEnabled);

        Utils.show(recordEnabled);
        Utils.hide(recordDisabled);
    }

    private void setRecording() {
        Utils.hide(recordDisabled);
        Utils.hide(recordEnabled);
        Utils.show(playDisabled);
        Utils.hide(playEnabled);
    }

    private void setIdle() {
        Utils.hide(playDisabled);
        Utils.show(playEnabled);
        Utils.hide(recordDisabled);
        Utils.show(recordEnabled);
    }

    private void setPlaying() {
        Utils.hide(playDisabled);
        Utils.hide(playEnabled);
        Utils.show(recordDisabled);
        Utils.hide(recordEnabled);
    }
}
