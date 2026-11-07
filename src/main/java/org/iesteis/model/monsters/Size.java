// Size.java

package org.iesteis.model.monsters;


import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import java.io.IOException;
/**
 * Tamaños posibles para los monstruos.
 */
public enum Size {
    GARGANTUAN, HUGE, LARGE, MEDIUM, MEDIUM_OR_SMALL, SMALL, TINY;

    @JsonValue

    public String toValue() {
        switch (this) {
            case GARGANTUAN: return "Gargantuan";
            case HUGE: return "Huge";
            case LARGE: return "Large";
            case MEDIUM: return "Medium";
            case MEDIUM_OR_SMALL: return "Medium or small";
            case SMALL: return "Small";
            case TINY: return "Tiny";
        }
        return null;
    }

    @JsonCreator

    public static Size forValue(String value) throws IOException {
        if (value.equals("Gargantuan")) return GARGANTUAN;
        if (value.equals("Huge")) return HUGE;
        if (value.equals("Large")) return LARGE;
        if (value.equals("Medium")) return MEDIUM;
        if (value.equals("Medium or small")) return MEDIUM_OR_SMALL;
        if (value.equals("Small")) return SMALL;
        if (value.equals("Tiny")) return TINY;
        throw new IOException("Cannot deserialize Size");
    }
}

