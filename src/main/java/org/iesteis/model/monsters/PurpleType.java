// PurpleType.java

package org.iesteis.model.monsters;


import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import java.io.IOException;
/**
 * Tipos de ataque o acción enumerados para las opciones de monstruo.
 */
public enum PurpleType {
    MELEE, RANGED, SPECIAL;

    @JsonValue

    public String toValue() {
        switch (this) {
            case MELEE: return "melee";
            case RANGED: return "ranged";
            case SPECIAL: return "special";
        }
        return null;
    }

    @JsonCreator

    public static PurpleType forValue(String value) throws IOException {
        if (value.equals("melee")) return MELEE;
        if (value.equals("ranged")) return RANGED;
        if (value.equals("special")) return SPECIAL;
        throw new IOException("Cannot deserialize PurpleType");
    }
}

