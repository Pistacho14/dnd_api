package org.iesteis.model.background;

import java.io.IOException;

public enum OptionType {
    CHOICE, COUNTED_REFERENCE, MONEY;

    public String toValue() {
        switch (this) {
            case CHOICE: return "choice";
            case COUNTED_REFERENCE: return "counted_reference";
            case MONEY: return "money";
        }
        return null;
    }

    public static OptionType forValue(String value) throws IOException {
        if (value.equals("choice")) return CHOICE;
        if (value.equals("counted_reference")) return COUNTED_REFERENCE;
        if (value.equals("money")) return MONEY;
        throw new IOException("Cannot deserialize OptionType");
    }
}