// Blindsight.java

package org.iesteis.model.monsters;


import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import java.io.IOException;

public enum Blindsight {
    THE_10_FT, THE_120_FT, THE_120_FT_UNIMPEDED_BY_MAGICAL_DARKNESS, THE_150_FT, THE_150_FT_UNIMPEDED_BY_MAGICAL_DARKNESS, THE_30_FT, THE_60_FT, THE_90_FT;

    @JsonValue

    public String toValue() {
        switch (this) {
            case THE_10_FT: return "10 ft.";
            case THE_120_FT: return "120 ft.";
            case THE_120_FT_UNIMPEDED_BY_MAGICAL_DARKNESS: return "120 ft. (unimpeded by magical darkness)";
            case THE_150_FT: return "150 ft.";
            case THE_150_FT_UNIMPEDED_BY_MAGICAL_DARKNESS: return "150 ft. (unimpeded by magical darkness)";
            case THE_30_FT: return "30 ft.";
            case THE_60_FT: return "60 ft.";
            case THE_90_FT: return "90 ft.";
        }
        return null;
    }

    @JsonCreator

    public static Blindsight forValue(String value) throws IOException {
        if (value.equals("10 ft.")) return THE_10_FT;
        if (value.equals("120 ft.")) return THE_120_FT;
        if (value.equals("120 ft. (unimpeded by magical darkness)")) return THE_120_FT_UNIMPEDED_BY_MAGICAL_DARKNESS;
        if (value.equals("150 ft.")) return THE_150_FT;
        if (value.equals("150 ft. (unimpeded by magical darkness)")) return THE_150_FT_UNIMPEDED_BY_MAGICAL_DARKNESS;
        if (value.equals("30 ft.")) return THE_30_FT;
        if (value.equals("60 ft.")) return THE_60_FT;
        if (value.equals("90 ft.")) return THE_90_FT;
        throw new IOException("Cannot deserialize Blindsight");
    }
}

