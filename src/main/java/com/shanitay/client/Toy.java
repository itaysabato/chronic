package com.shanitay.client;

import com.allen_sauer.gwt.voices.client.Sound;
import com.allen_sauer.gwt.voices.client.handler.PlaybackCompleteEvent;
import com.allen_sauer.gwt.voices.client.handler.SoundHandler;
import com.allen_sauer.gwt.voices.client.handler.SoundLoadStateChangeEvent;

/**
 * Created By: Itay Sabato<br/>
 * Date: 13/05/12 <br/>
 * Time: 01:58 <br/>
 */
public class Toy {
    private final Sound sound;
    private final Animation animation;
    private boolean played = false;
    private boolean looping = false;

    public Toy(Sound sound, Animation animation) {
        this.sound = sound;
        this.animation = animation;

        sound.addEventHandler(new SoundHandler() {
            public void onPlaybackComplete(PlaybackCompleteEvent event) {
                Toy.this.animation.stop();
                played = false;
            }

            public void onSoundLoadStateChange(SoundLoadStateChangeEvent event) {
                // ignore
            }
        });
    }

    public void setLooping(boolean looping) {
        this.looping = looping;
        sound.setLooping(looping);
        animation.setLooping(looping);
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
        animation.play();
        played = true;
    }

    public void stop() {
        sound.stop();
        animation.stop();
        played = false;
    }

    public interface Animation {
        void setLooping(boolean looping);
        void play();
        void stop();
    }
}
