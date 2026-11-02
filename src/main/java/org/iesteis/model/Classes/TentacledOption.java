package org.iesteis.model.classes;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TentacledOption {
    public TentacledOption(PurpleOptionType optionType, Proficiency item, AbilityScoreOptions choice) {
        this.optionType = optionType;
        this.item = item;
        this.choice = choice;
    }

    public TentacledOption() {}

    @JsonProperty("option_type")
    private PurpleOptionType optionType;
    @JsonProperty("item")
    private Proficiency item;
    @JsonProperty("choice")
    private AbilityScoreOptions choice;

    public PurpleOptionType getOptionType() { return optionType; }
    public void setOptionType(PurpleOptionType value) { this.optionType = value; }

    public Proficiency getItem() { return item; }
    public void setItem(Proficiency value) { this.item = value; }

    public AbilityScoreOptions getChoice() { return choice; }
    public void setChoice(AbilityScoreOptions value) { this.choice = value; }
}