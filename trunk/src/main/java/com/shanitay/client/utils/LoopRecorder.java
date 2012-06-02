package com.shanitay.client.utils;

import com.google.gwt.core.client.Scheduler;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Created By: Itay Sabato<br/>
 * Date: 02/06/12 <br/>
 * Time: 16:37 <br/>
 */
public class LoopRecorder {
    private long nextId = 0;
    private final Map<Long, Toy> toyMap = new HashMap<Long, Toy>();

    private State state = State.IDLE;
    private long startTimeMillis;
    private long relativeEndTimeMillis;
    private List<ToyEvent> recordedEvents = new LinkedList<ToyEvent>();
    private MyRepeatingCommand currentPlayback;

    void startRecording() {
        startTimeMillis = System.currentTimeMillis();
        recordedEvents.clear();
        state = State.RECORDING;
    }

    void stop() {
        if(state == State.RECORDING){
            relativeEndTimeMillis = System.currentTimeMillis() - startTimeMillis;
        }
        else if(state == State.PLAYING) {
            currentPlayback.continueLoop = false;
        }
        state = State.IDLE;
    }

    void playLoop() {
        state = State.PLAYING;
        playOnce();

        currentPlayback = new MyRepeatingCommand();

        Scheduler.get().scheduleFixedDelay(currentPlayback, (int) relativeEndTimeMillis);
    }

    private void playOnce() {
        for (final ToyEvent recordedEvent : recordedEvents) {
            final Toy target = recordedEvent.getTarget();

            Scheduler.get().scheduleFixedDelay(new Scheduler.RepeatingCommand() {
                public boolean execute() {
                    target.toggle();
                    return false;
                }
            }, (int) recordedEvent.getTimestampMillis());
        }
    }

    public void register(Toy toy) {
        toy.setId(nextId++);
        toyMap.put(toy.getId(), toy);
    }

    public void record(Toy toy) {
        long timestampMillis = System.currentTimeMillis() - startTimeMillis;

        if (state == State.RECORDING && toyMap.containsKey(toy.getId())) {
            if(recordedEvents.isEmpty()){
                startTimeMillis = timestampMillis + startTimeMillis;
                timestampMillis = 0;
            }
            ToyEvent event = new ToyEvent(timestampMillis, toy);
            recordedEvents.add(event);
        }
    }

    private static enum State {
        RECORDING,
        PLAYING,
        IDLE
    }

    private class MyRepeatingCommand implements Scheduler.RepeatingCommand {
        private boolean continueLoop = true;

        public boolean execute() {
            if (continueLoop) {
                playOnce();
                return true;
            }
            return false;
        }
    }
}
