package org.iesteis.model.spells;


import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import java.io.IOException;

public enum AttackType {
    MELEE, RANGED;

    @JsonValue

    public String toValue() {
        switch (this) {
            case MELEE: return "melee";
            case RANGED: return "ranged";
        }
        return null;
    }

    @JsonCreator

    public static AttackType forValue(String value) throws IOException {
        if (value.equals("melee")) return MELEE;
        if (value.equals("ranged")) return RANGED;
        throw new IOException("Cannot deserialize AttackType");
    }
}

