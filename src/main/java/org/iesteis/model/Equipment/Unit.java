package org.iesteis.model.equipment;

import java.io.IOException;

public enum Unit {
    CP, GP, SP;

    public String toValue() {
        switch (this) {
            case CP: return "cp";
            case GP: return "gp";
            case SP: return "sp";
        }
        return null;
    }

    public static Unit forValue(String value) throws IOException {
        if (value.equals("cp")) return CP;
        if (value.equals("gp")) return GP;
        if (value.equals("sp")) return SP;
        throw new IOException("Cannot deserialize Unit");
    }
}