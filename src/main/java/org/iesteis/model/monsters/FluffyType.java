// FluffyType.java

package org.iesteis.model.monsters;


import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import java.io.IOException;

public enum FluffyType {
    AT_WILL, PER_DAY;

    @JsonValue

    public String toValue() {
        switch (this) {
            case AT_WILL: return "at will";
            case PER_DAY: return "per day";
        }
        return null;
    }

    @JsonCreator

    public static FluffyType forValue(String value) throws IOException {
        if (value.equals("at will")) return AT_WILL;
        if (value.equals("per day")) return PER_DAY;
        throw new IOException("Cannot deserialize FluffyType");
    }
}

