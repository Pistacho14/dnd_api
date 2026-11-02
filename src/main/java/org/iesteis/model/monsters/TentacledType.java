// TentacledType.java

package org.iesteis.model.monsters;


import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import java.io.IOException;

public enum TentacledType {
    PER_DAY, RECHARGE_AFTER_REST, RECHARGE_ON_ROLL;

    @JsonValue

    public String toValue() {
        switch (this) {
            case PER_DAY: return "per day";
            case RECHARGE_AFTER_REST: return "recharge after rest";
            case RECHARGE_ON_ROLL: return "recharge on roll";
        }
        return null;
    }

    @JsonCreator

    public static TentacledType forValue(String value) throws IOException {
        if (value.equals("per day")) return PER_DAY;
        if (value.equals("recharge after rest")) return RECHARGE_AFTER_REST;
        if (value.equals("recharge on roll")) return RECHARGE_ON_ROLL;
        throw new IOException("Cannot deserialize TentacledType");
    }
}

