// Dice.java

package org.iesteis.model.monsters;


import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import java.io.IOException;
/**
 * Valores de dados usados en las expresiones de monstruos.
 */
public enum Dice {
    THE_1_D6;

    @JsonValue

    public String toValue() {
        switch (this) {
            case THE_1_D6: return "1d6";
        }
        return null;
    }

    @JsonCreator

    public static Dice forValue(String value) throws IOException {
        if (value.equals("1d6")) return THE_1_D6;
        throw new IOException("Cannot deserialize Dice");
    }
}

