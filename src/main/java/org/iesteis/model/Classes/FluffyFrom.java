package org.iesteis.model.classes;

import com.fasterxml.jackson.annotation.JsonProperty;
/**
 * Conjunto de opciones de competencia para una elección de clase.
 */
public class FluffyFrom {
    @JsonProperty("option_set_type")
    private OptionSetType optionSetType;
    @JsonProperty("options")
    private IndigoOption[] options;
    public FluffyFrom() {}

    public FluffyFrom(OptionSetType optionSetType, IndigoOption[] options) {
        this.optionSetType = optionSetType;
        this.options = options;
    }

    public OptionSetType getOptionSetType() { return optionSetType; }
    public void setOptionSetType(OptionSetType value) { this.optionSetType = value; }

    public IndigoOption[] getOptions() { return options; }
    public void setOptions(IndigoOption[] value) { this.options = value; }
}