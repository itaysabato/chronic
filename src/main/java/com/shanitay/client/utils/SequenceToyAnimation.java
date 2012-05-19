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
    private List<myCommand> myCommands = new LinkedList<myCommand>();
    private final List<ScheduledAnimation> scheduledAnimations;

    public SequenceToyAnimation(ScheduledAnimation... scheduledAnimations) {
            this( Arrays.asList(scheduledAnimations));
    }

    public SequenceToyAnimation(List<ScheduledAnimation> scheduledAnimations) {
        this.scheduledAnimations = scheduledAnimations;
    }

    public void setLooping(boolean looping) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    public void play() {
        stop();
        innerPlay();
    }

    private void innerPlay() {
        for (ScheduledAnimation scheduledAnimation : scheduledAnimations) {
            final myCommand myCommand = new SequenceToyAnimation.myCommand(scheduledAnimation.animation);
            myCommands.add(myCommand);
            Scheduler.get().scheduleFixedDelay(myCommand, scheduledAnimation.getStartTimeMillis());
        }
    }

    public void stop() {
        for (myCommand command : myCommands) {
            command.stop = true;
        }

        myCommands.clear();

        for (ScheduledAnimation scheduledAnimation : scheduledAnimations) {
            scheduledAnimation.animation.stop();
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

    public static class ScheduledAnimation {
        private final Toy.Animation animation;
        private final int startTimeMillis;

        public ScheduledAnimation(Toy.Animation animation, int startTimeMillis) {
            this.animation = animation;
            this.startTimeMillis = startTimeMillis;
        }

        public Toy.Animation getAnimation() {
            return animation;
        }

        public int getStartTimeMillis() {
            return startTimeMillis;
        }
    }
}
