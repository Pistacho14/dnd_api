package org.iesteis.model.Classes;

public class StickyOption {
    private FluffyOptionType optionType;
    private Item[] items;
    private Long count;
    private Unit unit;

    public FluffyOptionType getOptionType() { return optionType; }
    public void setOptionType(FluffyOptionType value) { this.optionType = value; }

    public Item[] getItems() { return items; }
    public void setItems(Item[] value) { this.items = value; }

    public Long getCount() { return count; }
    public void setCount(Long value) { this.count = value; }

    public Unit getUnit() { return unit; }
    public void setUnit(Unit value) { this.unit = value; }
}