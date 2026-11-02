// Alignment.java

package org.iesteis.model.monsters;


import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import java.io.IOException;

public enum Alignment {
    CHAOTIC_EVIL, CHAOTIC_GOOD, CHAOTIC_NEUTRAL, LAWFUL_EVIL, LAWFUL_GOOD, LAWFUL_NEUTRAL, NEUTRAL, NEUTRAL_EVIL, NEUTRAL_GOOD, UNALIGNED;

    @JsonValue

    public String toValue() {
        switch (this) {
            case CHAOTIC_EVIL: return "chaotic evil";
            case CHAOTIC_GOOD: return "chaotic good";
            case CHAOTIC_NEUTRAL: return "chaotic neutral";
            case LAWFUL_EVIL: return "lawful evil";
            case LAWFUL_GOOD: return "lawful good";
            case LAWFUL_NEUTRAL: return "lawful neutral";
            case NEUTRAL: return "neutral";
            case NEUTRAL_EVIL: return "neutral evil";
            case NEUTRAL_GOOD: return "neutral good";
            case UNALIGNED: return "unaligned";
        }
        return null;
    }

    @JsonCreator

    public static Alignment forValue(String value) throws IOException {
        if (value.equals("chaotic evil")) return CHAOTIC_EVIL;
        if (value.equals("chaotic good")) return CHAOTIC_GOOD;
        if (value.equals("chaotic neutral")) return CHAOTIC_NEUTRAL;
        if (value.equals("lawful evil")) return LAWFUL_EVIL;
        if (value.equals("lawful good")) return LAWFUL_GOOD;
        if (value.equals("lawful neutral")) return LAWFUL_NEUTRAL;
        if (value.equals("neutral")) return NEUTRAL;
        if (value.equals("neutral evil")) return NEUTRAL_EVIL;
        if (value.equals("neutral good")) return NEUTRAL_GOOD;
        if (value.equals("unaligned")) return UNALIGNED;
        throw new IOException("Cannot deserialize Alignment");
    }
}

