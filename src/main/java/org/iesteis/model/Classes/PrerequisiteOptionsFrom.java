package org.iesteis.model.classes;

import com.fasterxml.jackson.annotation.JsonProperty;
/**
 * Conjunto de alternativas de requisitos de multiclase.
 */
public class PrerequisiteOptionsFrom {
    @JsonProperty("option_set_type")
    private OptionSetType optionSetType;
    @JsonProperty("options")
    private PurpleOption[] options;
    public PrerequisiteOptionsFrom() {}

    public PrerequisiteOptionsFrom(OptionSetType optionSetType, PurpleOption[] options) {
        this.optionSetType = optionSetType;
        this.options = options;
    }

    public OptionSetType getOptionSetType() { return optionSetType; }
    public void setOptionSetType(OptionSetType value) { this.optionSetType = value; }

    public PurpleOption[] getOptions() { return options; }
    public void setOptions(PurpleOption[] value) { this.options = value; }
}