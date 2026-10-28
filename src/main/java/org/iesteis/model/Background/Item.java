package org.iesteis.model.Background;

public class Item {
    private OptionType optionType;
    private Long count;
    private Feat of;
    private String unit;
    private Choice choice;

    public OptionType getOptionType() { return optionType; }
    public void setOptionType(OptionType value) { this.optionType = value; }

    public Long getCount() { return count; }
    public void setCount(Long value) { this.count = value; }

    public Feat getOf() { return of; }
    public void setOf(Feat value) { this.of = value; }

    public String getUnit() { return unit; }
    public void setUnit(String value) { this.unit = value; }

    public Choice getChoice() { return choice; }
    public void setChoice(Choice value) { this.choice = value; }
}