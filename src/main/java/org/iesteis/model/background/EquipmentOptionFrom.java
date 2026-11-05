package org.iesteis.model.background;

import com.fasterxml.jackson.annotation.JsonProperty;

public class EquipmentOptionFrom {
    @JsonProperty("option_set_type")
    private String optionSetType;
    @JsonProperty("options")
    private PurpleOption[] options;
    public EquipmentOptionFrom() {}

    public EquipmentOptionFrom(String optionSetType, PurpleOption[] options) {
        this.optionSetType = optionSetType;
        this.options = options;
    }

    public String getOptionSetType() { return optionSetType; }
    public void setOptionSetType(String value) { this.optionSetType = value; }

    public PurpleOption[] getOptions() { return options; }
    public void setOptions(PurpleOption[] value) { this.options = value; }
}
