package org.iesteis.model.classes;

import java.io.IOException;

public enum Unit {
    GP;

    public String toValue() {
        switch (this) {
            case GP: return "gp";
        }
        return null;
    }

    public static Unit forValue(String value) throws IOException {
        if (value.equals("gp")) return GP;
        throw new IOException("Cannot deserialize Unit");
    }
}