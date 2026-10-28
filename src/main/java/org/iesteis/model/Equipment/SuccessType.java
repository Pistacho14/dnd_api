package org.iesteis.model.Equipment;

import java.io.IOException;

public enum SuccessType {
    NONE;

    public String toValue() {
        switch (this) {
            case NONE: return "none";
        }
        return null;
    }

    public static SuccessType forValue(String value) throws IOException {
        if (value.equals("none")) return NONE;
        throw new IOException("Cannot deserialize SuccessType");
    }
}