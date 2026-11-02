package org.iesteis.model.classes;

import com.fasterxml.jackson.annotation.JsonCreator;

import java.io.IOException;

public enum ItemOptionType {
    CHOICE, COUNTED_REFERENCE, MONEY;

    public String toValue() {
        switch (this) {
            case CHOICE: return "choice";
            case COUNTED_REFERENCE: return "counted_reference";
            case MONEY: return "money";
        }
        return null;
    }

    @JsonCreator
    public static ItemOptionType forValue(String value) throws IOException {
        if (value.equals("choice")) return CHOICE;
        if (value.equals("counted_reference")) return COUNTED_REFERENCE;
        if (value.equals("money")) return MONEY;
        throw new IOException("Cannot deserialize ItemOptionType");
    }
}