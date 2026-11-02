package org.iesteis.model.classes;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import java.io.IOException;

public enum Name {
    CANTRIPS, CHANGING_YOUR_PREPARED_SPELLS, PREPARED_SPELLS_OF_LEVEL_1, SPELLCASTING_ABILITY, SPELLCASTING_FOCUS, SPELL_SLOTS;

    @JsonValue

    public String toValue() {
        switch (this) {
            case CANTRIPS: return "Cantrips";
            case CHANGING_YOUR_PREPARED_SPELLS: return "Changing Your Prepared Spells";
            case PREPARED_SPELLS_OF_LEVEL_1: return "Prepared Spells of Level 1+";
            case SPELLCASTING_ABILITY: return "Spellcasting Ability";
            case SPELLCASTING_FOCUS: return "Spellcasting Focus";
            case SPELL_SLOTS: return "Spell Slots";
        }
        return null;
    }

    @JsonCreator
    public static Name forValue(String value) throws IOException {
        if (value.equals("Cantrips")) return CANTRIPS;
        if (value.equals("Changing Your Prepared Spells")) return CHANGING_YOUR_PREPARED_SPELLS;
        if (value.equals("Prepared Spells of Level 1+")) return PREPARED_SPELLS_OF_LEVEL_1;
        if (value.equals("Spellcasting Ability")) return SPELLCASTING_ABILITY;
        if (value.equals("Spellcasting Focus")) return SPELLCASTING_FOCUS;
        if (value.equals("Spell Slots")) return SPELL_SLOTS;
        throw new IOException("Cannot deserialize Name");
    }
}