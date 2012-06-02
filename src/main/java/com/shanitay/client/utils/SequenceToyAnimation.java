package com.shanitay.client.utils;

import com.google.gwt.core.client.Scheduler;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Created By: Itay Sabato<br/>
 * Date: 19/05/12 <br/>
 * Time: 23:10 <br/>
 */
public class SequenceToyAnimation implements Toy.Animation {
    private boolean looping = false;
    private boolean stopping =false;
    private final int totalDurationMillis;
    private List<myCommand> myCommands = new LinkedList<myCommand>();
    private final List<ScheduledAnimation> scheduledAnimations;

    public SequenceToyAnimation(int totalDurationMillis, ScheduledAnimation... scheduledAnimations) {
        this(totalDurationMillis, Arrays.asList(scheduledAnimations));
    }

    public SequenceToyAnimation(ScheduledAnimation... scheduledAnimations) {
            this(0, Arrays.asList(scheduledAnimations));
    }

    public SequenceToyAnimation(int totalDurationMillis, List<ScheduledAnimation> scheduledAnimations) {
        this.totalDurationMillis = totalDurationMillis;
        this.scheduledAnimations = scheduledAnimations;
    }

    public void setLooping(boolean looping) {
        this.looping = looping;
    }

    public void play() {
        stopping =false;
        innerPlay();

        if(looping){

            Scheduler.get().scheduleFixedDelay(new Scheduler.RepeatingCommand() {
                public boolean execute() {
                    if (looping && !stopping) {
                        innerPlay();
                        return true;
                    }
                    else {
                        return false;
                    }
                }
            }, totalDurationMillis);
        }
    }

    private void innerPlay() {
        myCommands.clear();
        for (ScheduledAnimation scheduledAnimation : scheduledAnimations) {
            final myCommand myCommand = new SequenceToyAnimation.myCommand(scheduledAnimation.getAnimation());
            myCommands.add(myCommand);
            Scheduler.get().scheduleFixedDelay(myCommand, scheduledAnimation.getStartTimeMillis());
        }
    }

    public void stop() {
        stopping = true;
        for (myCommand command : myCommands) {
            command.stop = true;
        }

        myCommands.clear();

        for (ScheduledAnimation scheduledAnimation : scheduledAnimations) {
            scheduledAnimation.getAnimation().stop();
        }
    }

    private class myCommand implements Scheduler.RepeatingCommand {
        private boolean stop = false;
        private final Toy.Animation animation;

        private myCommand(Toy.Animation animation) {
            this.animation = animation;
        }

        public boolean execute() {
            if(!stop){
                animation.play();
            }
            return false;
        }
    }

}
