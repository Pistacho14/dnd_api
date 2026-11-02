package org.iesteis.model.classes;

public class AbilityScoreOptionsFrom {
    private OptionSetType optionSetType;
    private FluffyOption[] options;

    public OptionSetType getOptionSetType() { return optionSetType; }
    public void setOptionSetType(OptionSetType value) { this.optionSetType = value; }

    public FluffyOption[] getOptions() { return options; }
    public void setOptions(FluffyOption[] value) { this.options = value; }
}