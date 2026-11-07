package org.iesteis.model.traits;


import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import java.io.IOException;
/**
 * Tipos de alternativa definidos para las competencias de rasgos.
 */
public enum OptionType {
    REFERENCE;

    @JsonValue

    public String toValue() {
        switch (this) {
            case REFERENCE: return "reference";
        }
        return null;
    }

    @JsonCreator

    public static OptionType forValue(String value) throws IOException {
        if (value.equals("reference")) return REFERENCE;
        throw new IOException("Cannot deserialize OptionType");
    }
}
