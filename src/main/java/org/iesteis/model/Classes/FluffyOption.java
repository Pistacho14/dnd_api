package org.iesteis.model.classes;

import com.fasterxml.jackson.annotation.JsonProperty;
/**
 * Alternativa que asocia un tipo de opción con una competencia.
 */
public class FluffyOption {
    @JsonProperty("option_type")
    private PurpleOptionType optionType;
    @JsonProperty("item")
    private Proficiency item;
    public FluffyOption() {}

    public FluffyOption(PurpleOptionType optionType, Proficiency item) {
        this.optionType = optionType;
        this.item = item;
    }

    public PurpleOptionType getOptionType() { return optionType; }
    public void setOptionType(PurpleOptionType value) { this.optionType = value; }

    public Proficiency getItem() { return item; }
    public void setItem(Proficiency value) { this.item = value; }
}