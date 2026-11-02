package org.iesteis.model.classes;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import java.io.IOException;

public enum ProficiencyChoiceType {
    PROFICIENCIES;

    @JsonValue

    public String toValue() {
        switch (this) {
            case PROFICIENCIES: return "proficiencies";
        }
        return null;
    }

    @JsonCreator
    public static ProficiencyChoiceType forValue(String value) throws IOException {
        if (value.equals("proficiencies")) return PROFICIENCIES;
        throw new IOException("Cannot deserialize ProficiencyChoiceType");
    }
}