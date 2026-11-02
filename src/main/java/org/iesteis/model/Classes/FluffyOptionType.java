package org.iesteis.model.classes;

import com.fasterxml.jackson.annotation.JsonCreator;

import java.io.IOException;

public enum FluffyOptionType {
    MONEY, MULTIPLE;

    public String toValue() {
        switch (this) {
            case MONEY: return "money";
            case MULTIPLE: return "multiple";
        }
        return null;
    }

    @JsonCreator
    public static FluffyOptionType forValue(String value) throws IOException {
        if (value.equals("money")) return MONEY;
        if (value.equals("multiple")) return MULTIPLE;
        throw new IOException("Cannot deserialize FluffyOptionType");
    }
}