package org.iesteis.model.equipment;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import java.io.IOException;
/**
 * Unidades monetarias usadas para expresar costes de equipo.
 */
public enum Unit {
    CP, GP, SP;

    @JsonValue

    public String toValue() {
        switch (this) {
            case CP: return "cp";
            case GP: return "gp";
            case SP: return "sp";
        }
        return null;
    }

    @JsonCreator
    public static Unit forValue(String value) throws IOException {
        if (value.equals("cp")) return CP;
        if (value.equals("gp")) return GP;
        if (value.equals("sp")) return SP;
        throw new IOException("Cannot deserialize Unit");
    }
}