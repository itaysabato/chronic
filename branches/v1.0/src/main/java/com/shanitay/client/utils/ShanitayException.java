package com.shanitay.client.utils;

/**
 * Created By: Itay Sabato<br/>
 * Date: 13/05/12 <br/>
 * Time: 23:16 <br/>
 */
public class ShanitayException extends RuntimeException {
    public ShanitayException() {
    }

    public ShanitayException(String message) {
        super(message);
    }

    public ShanitayException(String message, Throwable cause) {
        super(message, cause);
    }

    public ShanitayException(Throwable cause) {
        super(cause);
    }
}
