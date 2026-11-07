package org.iesteis.model.classes;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import java.io.IOException;
/**
 * Unidad monetaria utilizada en las opciones de equipo de clase.
 */
public enum Unit {
    GP;

    @JsonValue

    public String toValue() {
        switch (this) {
            case GP: return "gp";
        }
        return null;
    }

    @JsonCreator
    public static Unit forValue(String value) throws IOException {
        if (value.equals("gp")) return GP;
        throw new IOException("Cannot deserialize Unit");
    }
}