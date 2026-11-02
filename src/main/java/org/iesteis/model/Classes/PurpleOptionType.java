package org.iesteis.model.classes;

import com.fasterxml.jackson.annotation.JsonCreator;

import java.io.IOException;

public enum PurpleOptionType {
    CHOICE, REFERENCE;

    public String toValue() {
        switch (this) {
            case CHOICE: return "choice";
            case REFERENCE: return "reference";
        }
        return null;
    }

    @JsonCreator
    public static PurpleOptionType forValue(String value) throws IOException {
        if (value.equals("choice")) return CHOICE;
        if (value.equals("reference")) return REFERENCE;
        throw new IOException("Cannot deserialize PurpleOptionType");
    }
}