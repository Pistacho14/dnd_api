package org.iesteis.model.traits;


import com.fasterxml.jackson.annotation.JsonProperty;
public class Option {
    @JsonProperty("option_type")
    private OptionType optionType;
    @JsonProperty("item")
    private Species item;
    public Option() {}

    public Option(OptionType optionType, Species item) {
        this.optionType = optionType;
        this.item = item;
    }

    public OptionType getOptionType() { return optionType; }
    public void setOptionType(OptionType value) { this.optionType = value; }

    public Species getItem() { return item; }
    public void setItem(Species value) { this.item = value; }
}
