package org.iesteis.model.classes;

import java.io.IOException;

public enum ChoiceType {
    EQUIPMENT;

    public String toValue() {
        switch (this) {
            case EQUIPMENT: return "equipment";
        }
        return null;
    }

    public static ChoiceType forValue(String value) throws IOException {
        if (value.equals("equipment")) return EQUIPMENT;
        throw new IOException("Cannot deserialize ChoiceType");
    }
}