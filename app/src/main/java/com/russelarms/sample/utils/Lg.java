package com.russelarms.sample.utils;

import android.util.Log;

/**
 * Created by Ruslan on 06.08.2015.
 */
public class Lg {

    private static final String PREFIX = "SAMPLE ";
    public static final int LOGCAT_BUFFER_SIZE = 3000;

    private static boolean shouldLog() {
//        return BuildConfig.IS_LOGCAT_LOGGER_ENABLED;
        return true;
    }

    public static void i (String tag, String text){
        if (shouldLog()) {
            if (text.length() > LOGCAT_BUFFER_SIZE){
                String s = text;
                while (s.length() > LOGCAT_BUFFER_SIZE){
                    String s1 = s.substring(0, LOGCAT_BUFFER_SIZE);
                    s = s.substring(LOGCAT_BUFFER_SIZE);
                    Log.i(PREFIX + tag, s1);
                }
                Log.i(PREFIX + tag, s);
            } else {
                Log.i(PREFIX + tag, text);
            }
        }
    }

    public static void e (String tag, String text) {
        if (shouldLog()) {
            if (text.length() > LOGCAT_BUFFER_SIZE){
                String s = text;
                while (s.length() > LOGCAT_BUFFER_SIZE){
                    String s1 = s.substring(0, LOGCAT_BUFFER_SIZE);
                    s = s.substring(LOGCAT_BUFFER_SIZE);
                    Log.e(PREFIX + tag, s1);
                }
                Log.e(PREFIX + tag, s);
            } else {
                Log.e(PREFIX + tag, text);
            }
        }
    }

    public static void w (String tag, String text) {
        if (shouldLog()) {
            if (text.length() > LOGCAT_BUFFER_SIZE){
                String s = text;
                while (s.length() > LOGCAT_BUFFER_SIZE){
                    String s1 = s.substring(0, LOGCAT_BUFFER_SIZE);
                    s = s.substring(LOGCAT_BUFFER_SIZE);
                    Log.w(PREFIX + tag, s1);
                }
                Log.w(PREFIX + tag, s);
            } else {
                Log.w(PREFIX + tag, text);
            }
        }
    }
}
