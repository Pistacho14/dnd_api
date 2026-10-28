package org.iesteis.model.Background;

public class ProficiencyChoiceFrom {
    private String optionSetType;
    private FluffyOption[] options;

    public String getOptionSetType() { return optionSetType; }
    public void setOptionSetType(String value) { this.optionSetType = value; }

    public FluffyOption[] getOptions() { return options; }
    public void setOptions(FluffyOption[] value) { this.options = value; }
}