package com.assembleia.utils;

public class ValueUtils {

    public static boolean isEmpty(Object value) {
        return value == null;
    }

    public static boolean isNotEmpty(Object value) {
        return !isEmpty(value);
    }

}
