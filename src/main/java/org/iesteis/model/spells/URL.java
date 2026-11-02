package org.iesteis.model.spells;


import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import java.io.IOException;

public enum URL {
    API_2024_CLASSES_BARD, API_2024_CLASSES_CLERIC, API_2024_CLASSES_DRUID, API_2024_CLASSES_PALADIN, API_2024_CLASSES_RANGER, API_2024_CLASSES_SORCERER, API_2024_CLASSES_WARLOCK, API_2024_CLASSES_WIZARD, API_2024_DAMAGE_TYPES_ACID, API_2024_DAMAGE_TYPES_BLUDGEONING, API_2024_DAMAGE_TYPES_COLD, API_2024_DAMAGE_TYPES_FIRE, API_2024_DAMAGE_TYPES_FORCE, API_2024_DAMAGE_TYPES_LIGHTNING, API_2024_DAMAGE_TYPES_NECROTIC, API_2024_DAMAGE_TYPES_PIERCING, API_2024_DAMAGE_TYPES_POISON, API_2024_DAMAGE_TYPES_PSYCHIC, API_2024_DAMAGE_TYPES_RADIANT, API_2024_DAMAGE_TYPES_SLASHING, API_2024_DAMAGE_TYPES_THUNDER, API_2024_MAGIC_SCHOOLS_ABJURATION, API_2024_MAGIC_SCHOOLS_CONJURATION, API_2024_MAGIC_SCHOOLS_DIVINATION, API_2024_MAGIC_SCHOOLS_ENCHANTMENT, API_2024_MAGIC_SCHOOLS_EVOCATION, API_2024_MAGIC_SCHOOLS_ILLUSION, API_2024_MAGIC_SCHOOLS_NECROMANCY, API_2024_MAGIC_SCHOOLS_TRANSMUTATION;

    @JsonValue

    public String toValue() {
        switch (this) {
            case API_2024_CLASSES_BARD: return "/api/2024/classes/bard";
            case API_2024_CLASSES_CLERIC: return "/api/2024/classes/cleric";
            case API_2024_CLASSES_DRUID: return "/api/2024/classes/druid";
            case API_2024_CLASSES_PALADIN: return "/api/2024/classes/paladin";
            case API_2024_CLASSES_RANGER: return "/api/2024/classes/ranger";
            case API_2024_CLASSES_SORCERER: return "/api/2024/classes/sorcerer";
            case API_2024_CLASSES_WARLOCK: return "/api/2024/classes/warlock";
            case API_2024_CLASSES_WIZARD: return "/api/2024/classes/wizard";
            case API_2024_DAMAGE_TYPES_ACID: return "/api/2024/damage-types/acid";
            case API_2024_DAMAGE_TYPES_BLUDGEONING: return "/api/2024/damage-types/bludgeoning";
            case API_2024_DAMAGE_TYPES_COLD: return "/api/2024/damage-types/cold";
            case API_2024_DAMAGE_TYPES_FIRE: return "/api/2024/damage-types/fire";
            case API_2024_DAMAGE_TYPES_FORCE: return "/api/2024/damage-types/force";
            case API_2024_DAMAGE_TYPES_LIGHTNING: return "/api/2024/damage-types/lightning";
            case API_2024_DAMAGE_TYPES_NECROTIC: return "/api/2024/damage-types/necrotic";
            case API_2024_DAMAGE_TYPES_PIERCING: return "/api/2024/damage-types/piercing";
            case API_2024_DAMAGE_TYPES_POISON: return "/api/2024/damage-types/poison";
            case API_2024_DAMAGE_TYPES_PSYCHIC: return "/api/2024/damage-types/psychic";
            case API_2024_DAMAGE_TYPES_RADIANT: return "/api/2024/damage-types/radiant";
            case API_2024_DAMAGE_TYPES_SLASHING: return "/api/2024/damage-types/slashing";
            case API_2024_DAMAGE_TYPES_THUNDER: return "/api/2024/damage-types/thunder";
            case API_2024_MAGIC_SCHOOLS_ABJURATION: return "/api/2024/magic-schools/abjuration";
            case API_2024_MAGIC_SCHOOLS_CONJURATION: return "/api/2024/magic-schools/conjuration";
            case API_2024_MAGIC_SCHOOLS_DIVINATION: return "/api/2024/magic-schools/divination";
            case API_2024_MAGIC_SCHOOLS_ENCHANTMENT: return "/api/2024/magic-schools/enchantment";
            case API_2024_MAGIC_SCHOOLS_EVOCATION: return "/api/2024/magic-schools/evocation";
            case API_2024_MAGIC_SCHOOLS_ILLUSION: return "/api/2024/magic-schools/illusion";
            case API_2024_MAGIC_SCHOOLS_NECROMANCY: return "/api/2024/magic-schools/necromancy";
            case API_2024_MAGIC_SCHOOLS_TRANSMUTATION: return "/api/2024/magic-schools/transmutation";
        }
        return null;
    }

    @JsonCreator

    public static URL forValue(String value) throws IOException {
        if (value.equals("/api/2024/classes/bard")) return API_2024_CLASSES_BARD;
        if (value.equals("/api/2024/classes/cleric")) return API_2024_CLASSES_CLERIC;
        if (value.equals("/api/2024/classes/druid")) return API_2024_CLASSES_DRUID;
        if (value.equals("/api/2024/classes/paladin")) return API_2024_CLASSES_PALADIN;
        if (value.equals("/api/2024/classes/ranger")) return API_2024_CLASSES_RANGER;
        if (value.equals("/api/2024/classes/sorcerer")) return API_2024_CLASSES_SORCERER;
        if (value.equals("/api/2024/classes/warlock")) return API_2024_CLASSES_WARLOCK;
        if (value.equals("/api/2024/classes/wizard")) return API_2024_CLASSES_WIZARD;
        if (value.equals("/api/2024/damage-types/acid")) return API_2024_DAMAGE_TYPES_ACID;
        if (value.equals("/api/2024/damage-types/bludgeoning")) return API_2024_DAMAGE_TYPES_BLUDGEONING;
        if (value.equals("/api/2024/damage-types/cold")) return API_2024_DAMAGE_TYPES_COLD;
        if (value.equals("/api/2024/damage-types/fire")) return API_2024_DAMAGE_TYPES_FIRE;
        if (value.equals("/api/2024/damage-types/force")) return API_2024_DAMAGE_TYPES_FORCE;
        if (value.equals("/api/2024/damage-types/lightning")) return API_2024_DAMAGE_TYPES_LIGHTNING;
        if (value.equals("/api/2024/damage-types/necrotic")) return API_2024_DAMAGE_TYPES_NECROTIC;
        if (value.equals("/api/2024/damage-types/piercing")) return API_2024_DAMAGE_TYPES_PIERCING;
        if (value.equals("/api/2024/damage-types/poison")) return API_2024_DAMAGE_TYPES_POISON;
        if (value.equals("/api/2024/damage-types/psychic")) return API_2024_DAMAGE_TYPES_PSYCHIC;
        if (value.equals("/api/2024/damage-types/radiant")) return API_2024_DAMAGE_TYPES_RADIANT;
        if (value.equals("/api/2024/damage-types/slashing")) return API_2024_DAMAGE_TYPES_SLASHING;
        if (value.equals("/api/2024/damage-types/thunder")) return API_2024_DAMAGE_TYPES_THUNDER;
        if (value.equals("/api/2024/magic-schools/abjuration")) return API_2024_MAGIC_SCHOOLS_ABJURATION;
        if (value.equals("/api/2024/magic-schools/conjuration")) return API_2024_MAGIC_SCHOOLS_CONJURATION;
        if (value.equals("/api/2024/magic-schools/divination")) return API_2024_MAGIC_SCHOOLS_DIVINATION;
        if (value.equals("/api/2024/magic-schools/enchantment")) return API_2024_MAGIC_SCHOOLS_ENCHANTMENT;
        if (value.equals("/api/2024/magic-schools/evocation")) return API_2024_MAGIC_SCHOOLS_EVOCATION;
        if (value.equals("/api/2024/magic-schools/illusion")) return API_2024_MAGIC_SCHOOLS_ILLUSION;
        if (value.equals("/api/2024/magic-schools/necromancy")) return API_2024_MAGIC_SCHOOLS_NECROMANCY;
        if (value.equals("/api/2024/magic-schools/transmutation")) return API_2024_MAGIC_SCHOOLS_TRANSMUTATION;
        throw new IOException("Cannot deserialize URL");
    }
}

