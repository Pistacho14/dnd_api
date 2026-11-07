package org.iesteis.model.classes;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import java.io.IOException;
/**
 * Tipos de opción usados en las alternativas de equipo de clase.
 */
public enum FluffyOptionType {
    MONEY, MULTIPLE;

    @JsonValue

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