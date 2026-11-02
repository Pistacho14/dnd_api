// DamageImmunityElement.java

package org.iesteis.model.monsters;


import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import java.io.IOException;

public enum DamageImmunityElement {
    ACID, BLUDGEONING, COLD, DAMAGE_TYPE_CHOSEN_FOR_THE_DRACONIC_ORIGIN_TRAIT_BELOW, FIRE, LIGHTNING, NECROTIC, PIERCING, POISON, PSYCHIC, RADIANT, SLASHING, THUNDER;

    @JsonValue

    public String toValue() {
        switch (this) {
            case ACID: return "acid";
            case BLUDGEONING: return "bludgeoning";
            case COLD: return "cold";
            case DAMAGE_TYPE_CHOSEN_FOR_THE_DRACONIC_ORIGIN_TRAIT_BELOW: return "damage type chosen for the draconic origin trait below";
            case FIRE: return "fire";
            case LIGHTNING: return "lightning";
            case NECROTIC: return "necrotic";
            case PIERCING: return "piercing";
            case POISON: return "poison";
            case PSYCHIC: return "psychic";
            case RADIANT: return "radiant";
            case SLASHING: return "slashing";
            case THUNDER: return "thunder";
        }
        return null;
    }

    @JsonCreator

    public static DamageImmunityElement forValue(String value) throws IOException {
        if (value.equals("acid")) return ACID;
        if (value.equals("bludgeoning")) return BLUDGEONING;
        if (value.equals("cold")) return COLD;
        if (value.equals("damage type chosen for the draconic origin trait below")) return DAMAGE_TYPE_CHOSEN_FOR_THE_DRACONIC_ORIGIN_TRAIT_BELOW;
        if (value.equals("fire")) return FIRE;
        if (value.equals("lightning")) return LIGHTNING;
        if (value.equals("necrotic")) return NECROTIC;
        if (value.equals("piercing")) return PIERCING;
        if (value.equals("poison")) return POISON;
        if (value.equals("psychic")) return PSYCHIC;
        if (value.equals("radiant")) return RADIANT;
        if (value.equals("slashing")) return SLASHING;
        if (value.equals("thunder")) return THUNDER;
        throw new IOException("Cannot deserialize DamageImmunityElement");
    }
}

