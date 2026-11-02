// SuccessType.java

package org.iesteis.model.monsters;


import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import java.io.IOException;

public enum SuccessType {
    HALF, NONE;

    @JsonValue

    public String toValue() {
        switch (this) {
            case HALF: return "half";
            case NONE: return "none";
        }
        return null;
    }

    @JsonCreator

    public static SuccessType forValue(String value) throws IOException {
        if (value.equals("half")) return HALF;
        if (value.equals("none")) return NONE;
        throw new IOException("Cannot deserialize SuccessType");
    }
}

