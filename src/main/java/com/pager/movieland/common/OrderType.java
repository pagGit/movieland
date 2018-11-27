package com.pager.movieland.common;

public enum OrderType {
    ASC,
    DESC;

    public static OrderType forName(String name) {
        for (OrderType value : values()) {
            if (value.name().equalsIgnoreCase(name.trim())) {
                return value;
            }
        }
        throw new IllegalArgumentException("Cannot get OrderType for value: " + name);
    }

    public static boolean isOrderType(String text) {
        for (OrderType value : values()) {
            if (value.name().equalsIgnoreCase(text.trim())) {
                return true;
            }
        }
        return false;
    }

}