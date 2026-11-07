package org.iesteis.model.classes;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import java.io.IOException;
/**
 * Tipo de elección indicado para las opciones de equipo de una clase.
 */
public enum ChoiceType {
    EQUIPMENT;

    @JsonValue

    public String toValue() {
        switch (this) {
            case EQUIPMENT: return "equipment";
        }
        return null;
    }

    @JsonCreator
    public static ChoiceType forValue(String value) throws IOException {
        if (value.equals("equipment")) return EQUIPMENT;
        throw new IOException("Cannot deserialize ChoiceType");
    }
}