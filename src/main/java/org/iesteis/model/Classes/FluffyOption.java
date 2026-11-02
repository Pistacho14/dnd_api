package org.iesteis.model.classes;

import com.fasterxml.jackson.annotation.JsonProperty;

public class FluffyOption {
    public FluffyOption(PurpleOptionType optionType, Proficiency item) {
        this.optionType = optionType;
        this.item = item;
    }

    public FluffyOption() {}

    @JsonProperty("option_type")
    private PurpleOptionType optionType;
    @JsonProperty("item")
    private Proficiency item;

    public PurpleOptionType getOptionType() { return optionType; }
    public void setOptionType(PurpleOptionType value) { this.optionType = value; }

    public Proficiency getItem() { return item; }
    public void setItem(Proficiency value) { this.item = value; }
}