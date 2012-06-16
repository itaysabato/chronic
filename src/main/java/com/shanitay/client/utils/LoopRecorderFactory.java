package com.shanitay.client.utils;

import com.shanitay.client.utils.gadgets.LoopRecorder;

/**
 * Created By: Itay Sabato<br/>
 * Date: 02/06/12 <br/>
 * Time: 16:26 <br/>
 */
public class LoopRecorderFactory {
    private static long nextId = 0;
    private static LoopRecorder recorder = null;

    public static boolean hasRecorder() {
        return recorder != null;
    }

    public static LoopRecorder getRecorder() {
        return recorder;
    }

    public static void setRecorder(LoopRecorder recorder) {
        LoopRecorderFactory.recorder = recorder;
    }

    public static void register(Toy toy) {
        toy.setId(nextId++);
    }
}
