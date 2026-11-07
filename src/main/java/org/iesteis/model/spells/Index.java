package org.iesteis.model.spells;


import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import java.io.IOException;
/**
 * Identificadores de escuelas, daños y clases usados por los datos de conjuros.
 */
public enum Index {
    ABJURATION, ACID, BARD, BLUDGEONING, CLERIC, COLD, CONJURATION, DIVINATION, DRUID, ENCHANTMENT, EVOCATION, FIRE, FORCE, ILLUSION, LIGHTNING, NECROMANCY, NECROTIC, PALADIN, PIERCING, POISON, PSYCHIC, RADIANT, RANGER, SLASHING, SORCERER, THUNDER, TRANSMUTATION, WARLOCK, WIZARD;

    @JsonValue

    public String toValue() {
        switch (this) {
            case ABJURATION: return "abjuration";
            case ACID: return "acid";
            case BARD: return "bard";
            case BLUDGEONING: return "bludgeoning";
            case CLERIC: return "cleric";
            case COLD: return "cold";
            case CONJURATION: return "conjuration";
            case DIVINATION: return "divination";
            case DRUID: return "druid";
            case ENCHANTMENT: return "enchantment";
            case EVOCATION: return "evocation";
            case FIRE: return "fire";
            case FORCE: return "force";
            case ILLUSION: return "illusion";
            case LIGHTNING: return "lightning";
            case NECROMANCY: return "necromancy";
            case NECROTIC: return "necrotic";
            case PALADIN: return "paladin";
            case PIERCING: return "piercing";
            case POISON: return "poison";
            case PSYCHIC: return "psychic";
            case RADIANT: return "radiant";
            case RANGER: return "ranger";
            case SLASHING: return "slashing";
            case SORCERER: return "sorcerer";
            case THUNDER: return "thunder";
            case TRANSMUTATION: return "transmutation";
            case WARLOCK: return "warlock";
            case WIZARD: return "wizard";
        }
        return null;
    }

    @JsonCreator

    public static Index forValue(String value) throws IOException {
        if (value.equals("abjuration")) return ABJURATION;
        if (value.equals("acid")) return ACID;
        if (value.equals("bard")) return BARD;
        if (value.equals("bludgeoning")) return BLUDGEONING;
        if (value.equals("cleric")) return CLERIC;
        if (value.equals("cold")) return COLD;
        if (value.equals("conjuration")) return CONJURATION;
        if (value.equals("divination")) return DIVINATION;
        if (value.equals("druid")) return DRUID;
        if (value.equals("enchantment")) return ENCHANTMENT;
        if (value.equals("evocation")) return EVOCATION;
        if (value.equals("fire")) return FIRE;
        if (value.equals("force")) return FORCE;
        if (value.equals("illusion")) return ILLUSION;
        if (value.equals("lightning")) return LIGHTNING;
        if (value.equals("necromancy")) return NECROMANCY;
        if (value.equals("necrotic")) return NECROTIC;
        if (value.equals("paladin")) return PALADIN;
        if (value.equals("piercing")) return PIERCING;
        if (value.equals("poison")) return POISON;
        if (value.equals("psychic")) return PSYCHIC;
        if (value.equals("radiant")) return RADIANT;
        if (value.equals("ranger")) return RANGER;
        if (value.equals("slashing")) return SLASHING;
        if (value.equals("sorcerer")) return SORCERER;
        if (value.equals("thunder")) return THUNDER;
        if (value.equals("transmutation")) return TRANSMUTATION;
        if (value.equals("warlock")) return WARLOCK;
        if (value.equals("wizard")) return WIZARD;
        throw new IOException("Cannot deserialize Index");
    }
}

