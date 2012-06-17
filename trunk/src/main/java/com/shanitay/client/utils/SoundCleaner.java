package com.shanitay.client.utils;

import com.allen_sauer.gwt.voices.client.Sound;

import java.util.LinkedList;
import java.util.List;

/**
 * Created By: Itay Sabato<br/>
 * Date: 18/06/12 <br/>
 * Time: 02:42 <br/>
 */
public class SoundCleaner {
    private static SoundCleaner ourInstance = new SoundCleaner();

    private final List<Sound> sounds = new LinkedList<Sound>();

    public static SoundCleaner getInstance() {
        return ourInstance;
    }

    private SoundCleaner() {
    }

    public void addSound(Sound sound) {
        sounds.add(sound);
    }

    public void cleanSounds() {
        for (Sound sound : sounds) {
            if (sound.getLooping()) {
                try {
                    sound.stop();
                }
                catch (Throwable e) {
                    // ignore
                }
            }
        }
    }
}
