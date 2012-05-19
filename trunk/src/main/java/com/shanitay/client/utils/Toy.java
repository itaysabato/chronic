package com.shanitay.client.utils;

import com.allen_sauer.gwt.voices.client.Sound;
import com.allen_sauer.gwt.voices.client.handler.PlaybackCompleteEvent;
import com.allen_sauer.gwt.voices.client.handler.SoundHandler;
import com.allen_sauer.gwt.voices.client.handler.SoundLoadStateChangeEvent;

import java.util.Arrays;
import java.util.List;

/**
 * Created By: Itay Sabato<br/>
 * Date: 13/05/12 <br/>
 * Time: 01:58 <br/>
 */
public class Toy {
    private final Sound sound;
    private final List<Animation> animations;
    private boolean played = false;
    private boolean looping = false;

    public Toy(Sound sound, final Animation... animations) {
        this(sound, Arrays.asList(animations));
    }

    public Toy(Sound sound, final List<Animation> animations) {
        this.sound = sound;
        this.animations = animations;

        sound.addEventHandler(new SoundHandler() {
            public void onPlaybackComplete(PlaybackCompleteEvent event) {
                if (looping) {
                    for (Animation animation : animations) {
                        animation.stop();
                    }
                    played = false;
                }
            }

            public void onSoundLoadStateChange(SoundLoadStateChangeEvent event) {
                // ignore
            }
        });
    }

    public void setLooping(boolean looping) {
        this.looping = looping;
        sound.setLooping(looping);

        for (Animation animation : animations) {
            animation.setLooping(looping);
        }
    }

    public void toggle() {
        if(played && looping) {
            stop();
        }
        else {
            play();
        }
    }

    public void play() {
        sound.play();
        for (Animation animation : animations) {
            animation.play();
        }
        played = true;
    }

    public void stop() {
        sound.stop();
        for (Animation animation : animations) {
            animation.stop();
        }
        played = false;
    }

    public interface Animation {
        void setLooping(boolean looping);
        void play();
        void stop();
    }
}
