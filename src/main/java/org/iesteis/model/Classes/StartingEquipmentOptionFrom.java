package org.iesteis.model.classes;

import com.fasterxml.jackson.annotation.JsonProperty;
/**
 * Conjunto de alternativas de equipo inicial de una clase.
 */
public class StartingEquipmentOptionFrom {
    @JsonProperty("option_set_type")
    private OptionSetType optionSetType;
    @JsonProperty("options")
    private StickyOption[] options;
    public StartingEquipmentOptionFrom() {}

    public StartingEquipmentOptionFrom(OptionSetType optionSetType, StickyOption[] options) {
        this.optionSetType = optionSetType;
        this.options = options;
    }

    public OptionSetType getOptionSetType() { return optionSetType; }
    public void setOptionSetType(OptionSetType value) { this.optionSetType = value; }

    public StickyOption[] getOptions() { return options; }
    public void setOptions(StickyOption[] value) { this.options = value; }
}