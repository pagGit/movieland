package com.pager.movieland.common;

import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum OrderColumnName {
    PRICE,
    RATING;

    public static OrderColumnName forName(String name) {
        for (OrderColumnName value : values()) {
            if (value.name().equalsIgnoreCase(name.trim())) {
                return value;
            }
        }
        throw new IllegalArgumentException("Cannot get OrderColumnName for column: " + name);
    }

    public static boolean isOrderColumnName(String text) {
        for (OrderColumnName value : values()) {
            if (value.name().equalsIgnoreCase(text.trim())) {
                return true;
            }
        }
        return false;
    }
}
