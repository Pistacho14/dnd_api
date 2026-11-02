package org.iesteis.model.equipment;

import com.fasterxml.jackson.annotation.JsonCreator;

import java.io.IOException;

public enum Time {
    THE_10_MINUTES, THE_1_MINUTE, THE_5_MINUTES;

    public String toValue() {
        switch (this) {
            case THE_10_MINUTES: return "10 minutes";
            case THE_1_MINUTE: return "1 minute";
            case THE_5_MINUTES: return "5 minutes";
        }
        return null;
    }

    @JsonCreator
    public static Time forValue(String value) throws IOException {
        if (value.equals("10 minutes")) return THE_10_MINUTES;
        if (value.equals("1 minute")) return THE_1_MINUTE;
        if (value.equals("5 minutes")) return THE_5_MINUTES;
        throw new IOException("Cannot deserialize Time");
    }
}