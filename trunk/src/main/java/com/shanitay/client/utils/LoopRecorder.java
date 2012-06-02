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

    private State state = State.INITIAL;
    private long startTimeMillis;
    private long relativeEndTimeMillis = -1;
    private StoppableRepeatingCommand nextPlayback;
    private final List<StoppableRepeatingCommand> currentPlaybacks = new LinkedList<StoppableRepeatingCommand>();
    private final List<ToyEvent> recordedEvents = new LinkedList<ToyEvent>();

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
            nextPlayback.stop();
            for (StoppableRepeatingCommand currentPlayback : currentPlaybacks) {
                currentPlayback.stop();
            }
        }
        state = State.IDLE;
    }

    void playLoop() {
        state = State.PLAYING;
        playOnce();

        nextPlayback = new StoppableRepeatingCommand(new Scheduler.RepeatingCommand() {
            public boolean execute() {
                playOnce();
                return true;
            }
        });

        Scheduler.get().scheduleFixedDelay(nextPlayback, (int) relativeEndTimeMillis);
    }

    private void playOnce() {
        currentPlaybacks.clear();

        for (final ToyEvent recordedEvent : recordedEvents) {
            final Toy target = recordedEvent.getTarget();

            Scheduler.RepeatingCommand cmd = new Scheduler.RepeatingCommand() {
                public boolean execute() {
                    target.toggle();
                    return false;
                }
            };
            StoppableRepeatingCommand stoppableRepeatingCommand = new StoppableRepeatingCommand(cmd);

            currentPlaybacks.add(stoppableRepeatingCommand);
            Scheduler.get().scheduleFixedDelay(stoppableRepeatingCommand, (int) recordedEvent.getTimestampMillis());
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

    State getState() {
        return state;
    }

    static enum State {
        INITIAL,
        RECORDING,
        PLAYING,
        IDLE
    }

    private class StoppableRepeatingCommand implements Scheduler.RepeatingCommand {
        private boolean continueLoop = true;
        private final Scheduler.RepeatingCommand delegate;

        private StoppableRepeatingCommand(Scheduler.RepeatingCommand delegate) {
            this.delegate = delegate;
        }

        public boolean execute() {
            if (continueLoop) {
                return delegate.execute();
            }
            return false;
        }

        public void stop() {
            continueLoop = false;
        }
    }
}
