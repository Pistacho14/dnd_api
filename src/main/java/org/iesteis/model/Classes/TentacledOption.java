package org.iesteis.model.Classes;

public class TentacledOption {
    private PurpleOptionType optionType;
    private Proficiency item;
    private AbilityScoreOptions choice;

    public PurpleOptionType getOptionType() { return optionType; }
    public void setOptionType(PurpleOptionType value) { this.optionType = value; }

    public Proficiency getItem() { return item; }
    public void setItem(Proficiency value) { this.item = value; }

    public AbilityScoreOptions getChoice() { return choice; }
    public void setChoice(AbilityScoreOptions value) { this.choice = value; }
}