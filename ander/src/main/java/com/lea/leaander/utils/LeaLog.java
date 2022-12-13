package com.lea.leaander.utils;

import android.util.Log;

public class LeaLog {
    private LeaLog() {
        throw new UnsupportedOperationException("cannot be instantiated");
    }

    public static boolean debug = true;
    private static final String TAG = "LEAANDER_DRIVE";
    public static final String TAG_TCP = "LEAANDER_DRIVE_TCP";
    public static final String TAG_LOCATION = "LEAANDER_DRIVE_LOCATION";

    public static void i(String msg) {
        if (debug)
            Log.i(TAG, msg);
    }

    public static void d(String msg) {
        if (debug)
            Log.d(TAG, msg);
    }

    public static void e(String msg) {
        if (debug)
            Log.e(TAG, msg);
    }

    public static void v(String msg) {
        if (debug)
            Log.v(TAG, msg);
    }

    public static void w(String msg) {
        if (debug)
            Log.w(TAG, msg);
    }

    // 下面是传入自定义tag的函数
    public static void i(String tag, String msg) {
        if (debug) {
            Log.i(tag, msg);
        }
    }

    public static void d(String tag, String msg) {
        if (debug) {
            Log.d(tag, msg);
        }
    }

    public static void e(String tag, String msg) {
        if (debug) {
            Log.e(tag, msg);
        }
    }

    public static void v(String tag, String msg) {
        if (debug) {
            Log.v(tag, msg);
        }
    }

    public static void w(String tag, String msg) {
        if (debug) {
            Log.w(tag, msg);
        }
    }
}
