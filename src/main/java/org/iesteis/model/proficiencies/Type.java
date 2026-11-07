package org.iesteis.model.proficiencies;


import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import java.io.IOException;
/**
 * Categorías de competencias, como armas, armaduras, herramientas y habilidades.
 */
public enum Type {
    ARMOR, ARTISAN_S_TOOLS, MUSICAL_INSTRUMENTS, OTHER, SAVING_THROWS, SKILLS, TOOLS, WEAPONS;

    @JsonValue

    public String toValue() {
        switch (this) {
            case ARMOR: return "Armor";
            case ARTISAN_S_TOOLS: return "Artisan's Tools";
            case MUSICAL_INSTRUMENTS: return "Musical Instruments";
            case OTHER: return "Other";
            case SAVING_THROWS: return "Saving Throws";
            case SKILLS: return "Skills";
            case TOOLS: return "Tools";
            case WEAPONS: return "Weapons";
        }
        return null;
    }

    @JsonCreator

    public static Type forValue(String value) throws IOException {
        if (value.equals("Armor")) return ARMOR;
        if (value.equals("Artisan's Tools")) return ARTISAN_S_TOOLS;
        if (value.equals("Musical Instruments")) return MUSICAL_INSTRUMENTS;
        if (value.equals("Other")) return OTHER;
        if (value.equals("Saving Throws")) return SAVING_THROWS;
        if (value.equals("Skills")) return SKILLS;
        if (value.equals("Tools")) return TOOLS;
        if (value.equals("Weapons")) return WEAPONS;
        throw new IOException("Cannot deserialize Type");
    }
}
