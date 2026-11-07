// ComponentsRequired.java

package org.iesteis.model.monsters;


import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import java.io.IOException;
/**
 * Componentes de conjuro requeridos en el lanzamiento de un monstruo.
 */
public enum ComponentsRequired {
    M, S, V;

    @JsonValue

    public String toValue() {
        switch (this) {
            case M: return "M";
            case S: return "S";
            case V: return "V";
        }
        return null;
    }

    @JsonCreator

    public static ComponentsRequired forValue(String value) throws IOException {
        if (value.equals("M")) return M;
        if (value.equals("S")) return S;
        if (value.equals("V")) return V;
        throw new IOException("Cannot deserialize ComponentsRequired");
    }
}

