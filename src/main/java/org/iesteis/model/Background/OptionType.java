package org.iesteis.model.background;

import com.fasterxml.jackson.annotation.JsonCreator;

import java.util.Locale;
/**
 * Tipos de opción de equipo admitidos en los datos de trasfondos.
 */
public enum OptionType {
    MONEY,
    CHOICE,
    COUNTED_REFERENCE;

    @JsonCreator
    public static OptionType fromJson(String value) {
        return valueOf(value.toUpperCase(Locale.ROOT));
    }
}