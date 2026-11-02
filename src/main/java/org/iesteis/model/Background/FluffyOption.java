package org.iesteis.model.background;

import com.fasterxml.jackson.annotation.JsonProperty;

public class FluffyOption {
    @JsonProperty("option_type")
    private String optionType;
    @JsonProperty("item")
    private Feat item;
    public FluffyOption() {}

    public FluffyOption(String optionType, Feat item) {
        this.optionType = optionType;
        this.item = item;
    }

    public String getOptionType() { return optionType; }
    public void setOptionType(String value) { this.optionType = value; }

    public Feat getItem() { return item; }
    public void setItem(Feat value) { this.item = value; }
}