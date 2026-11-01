package org.iesteis.model.classes;

public class PrerequisiteOptionsFrom {
    private OptionSetType optionSetType;
    private PurpleOption[] options;

    public OptionSetType getOptionSetType() { return optionSetType; }
    public void setOptionSetType(OptionSetType value) { this.optionSetType = value; }

    public PurpleOption[] getOptions() { return options; }
    public void setOptions(PurpleOption[] value) { this.options = value; }
}