package org.iesteis.model.Classes;

public class StartingEquipmentOptionFrom {
    private OptionSetType optionSetType;
    private StickyOption[] options;

    public OptionSetType getOptionSetType() { return optionSetType; }
    public void setOptionSetType(OptionSetType value) { this.optionSetType = value; }

    public StickyOption[] getOptions() { return options; }
    public void setOptions(StickyOption[] value) { this.options = value; }
}