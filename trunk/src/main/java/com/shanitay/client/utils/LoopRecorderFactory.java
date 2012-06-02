package com.shanitay.client.utils;

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

    public static void initRecorder(LoopRecorder recorder) {
        LoopRecorderFactory.recorder = recorder;
    }
}
