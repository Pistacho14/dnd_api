// From.java

package org.iesteis.model.monsters;


import com.fasterxml.jackson.annotation.JsonProperty;
public class From {
    @JsonProperty("option_set_type")
    private OptionSetType optionSetType;
    @JsonProperty("options")
    private OptionElement[] options;
    public From() {}

    public From(OptionSetType optionSetType, OptionElement[] options) {
        this.optionSetType = optionSetType;
        this.options = options;
    }

    public OptionSetType getOptionSetType() { return optionSetType; }
    public void setOptionSetType(OptionSetType value) { this.optionSetType = value; }

    public OptionElement[] getOptions() { return options; }
    public void setOptions(OptionElement[] value) { this.options = value; }
}

