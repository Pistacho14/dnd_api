package org.iesteis.model.classes;

public class Item {
    private ItemOptionType optionType;
    private Long count;
    private Proficiency of;
    private Unit unit;
    private ItemChoice choice;

    public ItemOptionType getOptionType() { return optionType; }
    public void setOptionType(ItemOptionType value) { this.optionType = value; }

    public Long getCount() { return count; }
    public void setCount(Long value) { this.count = value; }

    public Proficiency getOf() { return of; }
    public void setOf(Proficiency value) { this.of = value; }

    public Unit getUnit() { return unit; }
    public void setUnit(Unit value) { this.unit = value; }

    public ItemChoice getChoice() { return choice; }
    public void setChoice(ItemChoice value) { this.choice = value; }
}