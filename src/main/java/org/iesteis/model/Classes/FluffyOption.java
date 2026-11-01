package org.iesteis.model.classes;

public class FluffyOption {
    private PurpleOptionType optionType;
    private Proficiency item;

    public PurpleOptionType getOptionType() { return optionType; }
    public void setOptionType(PurpleOptionType value) { this.optionType = value; }

    public Proficiency getItem() { return item; }
    public void setItem(Proficiency value) { this.item = value; }
}