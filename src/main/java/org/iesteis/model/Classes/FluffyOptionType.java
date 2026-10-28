package org.iesteis.model.Classes;

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

    public static FluffyOptionType forValue(String value) throws IOException {
        if (value.equals("money")) return MONEY;
        if (value.equals("multiple")) return MULTIPLE;
        throw new IOException("Cannot deserialize FluffyOptionType");
    }
}