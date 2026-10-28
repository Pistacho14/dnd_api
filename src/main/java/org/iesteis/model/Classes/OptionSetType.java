package org.iesteis.model.Classes;

import java.io.IOException;

public enum OptionSetType {
    OPTIONS_ARRAY;

    public String toValue() {
        switch (this) {
            case OPTIONS_ARRAY: return "options_array";
        }
        return null;
    }

    public static OptionSetType forValue(String value) throws IOException {
        if (value.equals("options_array")) return OPTIONS_ARRAY;
        throw new IOException("Cannot deserialize OptionSetType");
    }
}