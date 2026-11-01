package org.iesteis.model.classes;

import java.io.IOException;

public enum ProficiencyChoiceType {
    PROFICIENCIES;

    public String toValue() {
        switch (this) {
            case PROFICIENCIES: return "proficiencies";
        }
        return null;
    }

    public static ProficiencyChoiceType forValue(String value) throws IOException {
        if (value.equals("proficiencies")) return PROFICIENCIES;
        throw new IOException("Cannot deserialize ProficiencyChoiceType");
    }
}