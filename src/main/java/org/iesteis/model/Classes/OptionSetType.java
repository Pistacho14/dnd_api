package org.iesteis.model.classes;

import com.fasterxml.jackson.annotation.JsonCreator;

import java.io.IOException;

public enum OptionSetType {
    OPTIONS_ARRAY;

    public String toValue() {
        switch (this) {
            case OPTIONS_ARRAY: return "options_array";
        }
        return null;
    }

    @JsonCreator
    public static OptionSetType forValue(String value) throws IOException {
        if (value.equals("options_array")) return OPTIONS_ARRAY;
        throw new IOException("Cannot deserialize OptionSetType");
    }
}