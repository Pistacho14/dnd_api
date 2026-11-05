package org.iesteis.model.classes;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AbilityScoreOptionsFrom {
    @JsonProperty("option_set_type")
    private OptionSetType optionSetType;
    @JsonProperty("options")
    private FluffyOption[] options;
    public AbilityScoreOptionsFrom() {}

    public AbilityScoreOptionsFrom(OptionSetType optionSetType, FluffyOption[] options) {
        this.optionSetType = optionSetType;
        this.options = options;
    }

    public OptionSetType getOptionSetType() { return optionSetType; }
    public void setOptionSetType(OptionSetType value) { this.optionSetType = value; }

    public FluffyOption[] getOptions() { return options; }
    public void setOptions(FluffyOption[] value) { this.options = value; }
}