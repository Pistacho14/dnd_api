package org.iesteis.model.classes;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PurpleFrom {
    @JsonProperty("option_set_type")
    private OptionSetType optionSetType;
    @JsonProperty("options")
    private TentacledOption[] options;
    public PurpleFrom() {}

    public PurpleFrom(OptionSetType optionSetType, TentacledOption[] options) {
        this.optionSetType = optionSetType;
        this.options = options;
    }

    public OptionSetType getOptionSetType() { return optionSetType; }
    public void setOptionSetType(OptionSetType value) { this.optionSetType = value; }

    public TentacledOption[] getOptions() { return options; }
    public void setOptions(TentacledOption[] value) { this.options = value; }
}