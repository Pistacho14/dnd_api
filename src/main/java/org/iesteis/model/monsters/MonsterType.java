// MonsterType.java

package org.iesteis.model.monsters;


import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import java.io.IOException;

public enum MonsterType {
    ABERRATION, BEAST, CELESTIAL, CONSTRUCT, DRAGON, ELEMENTAL, FEY, FIEND, GIANT, HUMANOID, MONSTROSITY, OOZE, PLANT, SWARM_OF_TINY_BEASTS, SWARM_OF_TINY_UNDEAD, UNDEAD;

    @JsonValue

    public String toValue() {
        switch (this) {
            case ABERRATION: return "aberration";
            case BEAST: return "beast";
            case CELESTIAL: return "celestial";
            case CONSTRUCT: return "construct";
            case DRAGON: return "dragon";
            case ELEMENTAL: return "elemental";
            case FEY: return "fey";
            case FIEND: return "fiend";
            case GIANT: return "giant";
            case HUMANOID: return "humanoid";
            case MONSTROSITY: return "monstrosity";
            case OOZE: return "ooze";
            case PLANT: return "plant";
            case SWARM_OF_TINY_BEASTS: return "swarm of tiny beasts";
            case SWARM_OF_TINY_UNDEAD: return "swarm of tiny undead";
            case UNDEAD: return "undead";
        }
        return null;
    }

    @JsonCreator

    public static MonsterType forValue(String value) throws IOException {
        if (value.equals("aberration")) return ABERRATION;
        if (value.equals("beast")) return BEAST;
        if (value.equals("celestial")) return CELESTIAL;
        if (value.equals("construct")) return CONSTRUCT;
        if (value.equals("dragon")) return DRAGON;
        if (value.equals("elemental")) return ELEMENTAL;
        if (value.equals("fey")) return FEY;
        if (value.equals("fiend")) return FIEND;
        if (value.equals("giant")) return GIANT;
        if (value.equals("humanoid")) return HUMANOID;
        if (value.equals("monstrosity")) return MONSTROSITY;
        if (value.equals("ooze")) return OOZE;
        if (value.equals("plant")) return PLANT;
        if (value.equals("swarm of tiny beasts")) return SWARM_OF_TINY_BEASTS;
        if (value.equals("swarm of tiny undead")) return SWARM_OF_TINY_UNDEAD;
        if (value.equals("undead")) return UNDEAD;
        throw new IOException("Cannot deserialize MonsterType");
    }
}
