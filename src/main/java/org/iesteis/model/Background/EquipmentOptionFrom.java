package org.iesteis.model.background;

public class EquipmentOptionFrom {
    private String optionSetType;
    private PurpleOption[] options;

    public String getOptionSetType() { return optionSetType; }
    public void setOptionSetType(String value) { this.optionSetType = value; }

    public PurpleOption[] getOptions() { return options; }
    public void setOptions(PurpleOption[] value) { this.options = value; }
}