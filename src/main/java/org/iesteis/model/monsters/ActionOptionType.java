// ActionOptionType.java

package org.iesteis.model.monsters;


import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import java.io.IOException;
/**
 * Tipos de opción disponibles para las acciones de monstruo.
 */
public enum ActionOptionType {
    ACTION, MULTIPLE;

    @JsonValue

    public String toValue() {
        switch (this) {
            case ACTION: return "action";
            case MULTIPLE: return "multiple";
        }
        return null;
    }

    @JsonCreator

    public static ActionOptionType forValue(String value) throws IOException {
        if (value.equals("action")) return ACTION;
        if (value.equals("multiple")) return MULTIPLE;
        throw new IOException("Cannot deserialize ActionOptionType");
    }
}

