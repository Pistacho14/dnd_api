package org.iesteis.model.spells;


import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import java.io.IOException;
/**
 * Nombres de escuelas, daños y clases incluidos en los datos de conjuros.
 */
public enum Name {
    ABJURATION, ACID, BARD, BLUDGEONING, CLERIC, COLD, CONJURATION, DIVINATION, DRUID, ENCHANTMENT, EVOCATION, FIRE, FORCE, ILLUSION, LIGHTNING, NECROMANCY, NECROTIC, PALADIN, PIERCING, POISON, PSYCHIC, RADIANT, RANGER, SLASHING, SORCERER, THUNDER, TRANSMUTATION, WARLOCK, WIZARD;

    @JsonValue

    public String toValue() {
        switch (this) {
            case ABJURATION: return "Abjuration";
            case ACID: return "Acid";
            case BARD: return "Bard";
            case BLUDGEONING: return "Bludgeoning";
            case CLERIC: return "Cleric";
            case COLD: return "Cold";
            case CONJURATION: return "Conjuration";
            case DIVINATION: return "Divination";
            case DRUID: return "Druid";
            case ENCHANTMENT: return "Enchantment";
            case EVOCATION: return "Evocation";
            case FIRE: return "Fire";
            case FORCE: return "Force";
            case ILLUSION: return "Illusion";
            case LIGHTNING: return "Lightning";
            case NECROMANCY: return "Necromancy";
            case NECROTIC: return "Necrotic";
            case PALADIN: return "Paladin";
            case PIERCING: return "Piercing";
            case POISON: return "Poison";
            case PSYCHIC: return "Psychic";
            case RADIANT: return "Radiant";
            case RANGER: return "Ranger";
            case SLASHING: return "Slashing";
            case SORCERER: return "Sorcerer";
            case THUNDER: return "Thunder";
            case TRANSMUTATION: return "Transmutation";
            case WARLOCK: return "Warlock";
            case WIZARD: return "Wizard";
        }
        return null;
    }

    @JsonCreator

    public static Name forValue(String value) throws IOException {
        if (value.equals("Abjuration")) return ABJURATION;
        if (value.equals("Acid")) return ACID;
        if (value.equals("Bard")) return BARD;
        if (value.equals("Bludgeoning")) return BLUDGEONING;
        if (value.equals("Cleric")) return CLERIC;
        if (value.equals("Cold")) return COLD;
        if (value.equals("Conjuration")) return CONJURATION;
        if (value.equals("Divination")) return DIVINATION;
        if (value.equals("Druid")) return DRUID;
        if (value.equals("Enchantment")) return ENCHANTMENT;
        if (value.equals("Evocation")) return EVOCATION;
        if (value.equals("Fire")) return FIRE;
        if (value.equals("Force")) return FORCE;
        if (value.equals("Illusion")) return ILLUSION;
        if (value.equals("Lightning")) return LIGHTNING;
        if (value.equals("Necromancy")) return NECROMANCY;
        if (value.equals("Necrotic")) return NECROTIC;
        if (value.equals("Paladin")) return PALADIN;
        if (value.equals("Piercing")) return PIERCING;
        if (value.equals("Poison")) return POISON;
        if (value.equals("Psychic")) return PSYCHIC;
        if (value.equals("Radiant")) return RADIANT;
        if (value.equals("Ranger")) return RANGER;
        if (value.equals("Slashing")) return SLASHING;
        if (value.equals("Sorcerer")) return SORCERER;
        if (value.equals("Thunder")) return THUNDER;
        if (value.equals("Transmutation")) return TRANSMUTATION;
        if (value.equals("Warlock")) return WARLOCK;
        if (value.equals("Wizard")) return WIZARD;
        throw new IOException("Cannot deserialize Name");
    }
}

