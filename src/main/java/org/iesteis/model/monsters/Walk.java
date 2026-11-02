// Walk.java

package org.iesteis.model.monsters;


import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import java.io.IOException;

public enum Walk {
    THE_10_FT, THE_120_FT, THE_150_FT, THE_15_FT, THE_20_FT, THE_25_FT, THE_30_FT, THE_40_FT, THE_50_FT, THE_5_FT, THE_60_FT, THE_80_FT, THE_90_FT;

    @JsonValue

    public String toValue() {
        switch (this) {
            case THE_10_FT: return "10 ft.";
            case THE_120_FT: return "120 ft.";
            case THE_150_FT: return "150 ft.";
            case THE_15_FT: return "15 ft.";
            case THE_20_FT: return "20 ft.";
            case THE_25_FT: return "25 ft.";
            case THE_30_FT: return "30 ft.";
            case THE_40_FT: return "40 ft.";
            case THE_50_FT: return "50 ft.";
            case THE_5_FT: return "5 ft.";
            case THE_60_FT: return "60 ft.";
            case THE_80_FT: return "80 ft.";
            case THE_90_FT: return "90 ft.";
        }
        return null;
    }

    @JsonCreator

    public static Walk forValue(String value) throws IOException {
        if (value.equals("10 ft.")) return THE_10_FT;
        if (value.equals("120 ft.")) return THE_120_FT;
        if (value.equals("150 ft.")) return THE_150_FT;
        if (value.equals("15 ft.")) return THE_15_FT;
        if (value.equals("20 ft.")) return THE_20_FT;
        if (value.equals("25 ft.")) return THE_25_FT;
        if (value.equals("30 ft.")) return THE_30_FT;
        if (value.equals("40 ft.")) return THE_40_FT;
        if (value.equals("50 ft.")) return THE_50_FT;
        if (value.equals("5 ft.")) return THE_5_FT;
        if (value.equals("60 ft.")) return THE_60_FT;
        if (value.equals("80 ft.")) return THE_80_FT;
        if (value.equals("90 ft.")) return THE_90_FT;
        throw new IOException("Cannot deserialize Walk");
    }
}

