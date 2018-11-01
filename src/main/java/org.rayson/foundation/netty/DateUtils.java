package org.rayson.foundation.netty;

public class DateUtils {

    public static String getHexTime() {
        return Long.toHexString((System.currentTimeMillis()) / 1000).toUpperCase();
    }
}
