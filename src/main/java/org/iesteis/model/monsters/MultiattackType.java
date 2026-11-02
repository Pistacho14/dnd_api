// MultiattackType.java

package org.iesteis.model.monsters;


import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import java.io.IOException;

public enum MultiattackType {
    ACTIONS, ACTION_OPTIONS;

    @JsonValue

    public String toValue() {
        switch (this) {
            case ACTIONS: return "actions";
            case ACTION_OPTIONS: return "action_options";
        }
        return null;
    }

    @JsonCreator

    public static MultiattackType forValue(String value) throws IOException {
        if (value.equals("actions")) return ACTIONS;
        if (value.equals("action_options")) return ACTION_OPTIONS;
        throw new IOException("Cannot deserialize MultiattackType");
    }
}

