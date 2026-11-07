package org.iesteis.model.background;

import com.fasterxml.jackson.annotation.JsonProperty;
/**
 * Conjunto de opciones disponibles para elegir una competencia.
 */
public class ProficiencyChoiceFrom {
    @JsonProperty("option_set_type")
    private String optionSetType;
    @JsonProperty("options")
    private FluffyOption[] options;
    public ProficiencyChoiceFrom() {}

    public ProficiencyChoiceFrom(String optionSetType, FluffyOption[] options) {
        this.optionSetType = optionSetType;
        this.options = options;
    }

    public String getOptionSetType() { return optionSetType; }
    public void setOptionSetType(String value) { this.optionSetType = value; }

    public FluffyOption[] getOptions() { return options; }
    public void setOptions(FluffyOption[] value) { this.options = value; }
}