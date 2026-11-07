// OptionSetType.java

package org.iesteis.model.monsters;


import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import java.io.IOException;
/**
 * Tipo de conjunto que agrupa opciones de acciones de monstruo.
 */
public enum OptionSetType {
    OPTIONS_ARRAY;

    @JsonValue

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

