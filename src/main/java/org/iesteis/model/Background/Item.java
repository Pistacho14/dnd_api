package org.iesteis.model.background;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Item {
    public Item(OptionType optionType, Long count, Feat of, String unit, Choice choice) {
        this.optionType = optionType;
        this.count = count;
        this.of = of;
        this.unit = unit;
        this.choice = choice;
    }

    public Item() {}

    @JsonProperty("option_type")
    private OptionType optionType;
    @JsonProperty("count")
    private Long count;
    @JsonProperty("of")
    private Feat of;
    @JsonProperty("unit")
    private String unit;
    @JsonProperty("choice")
    private Choice choice;

    public OptionType getOptionType() { return optionType; }
    public void setOptionType(OptionType value) { this.optionType = value; }

    public Long getCount() { return count; }
    public void setCount(Long value) { this.count = value; }

    public Feat getOf() { return of; }
    public void setOf(Feat value) { this.of = value; }

    public String getUnit() { return unit; }
    public void setUnit(String value) { this.unit = value; }

    public Choice getChoice() { return choice; }
    public void setChoice(Choice value) { this.choice = value; }
}