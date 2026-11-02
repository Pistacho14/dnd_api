package org.iesteis.model.classes;

import com.fasterxml.jackson.annotation.JsonProperty;

public class StickyOption {
    @JsonProperty("option_type")
    private FluffyOptionType optionType;
    @JsonProperty("items")
    private Item[] items;
    @JsonProperty("count")
    private Long count;
    @JsonProperty("unit")
    private Unit unit;
    public StickyOption() {}

    public StickyOption(FluffyOptionType optionType, Item[] items, Long count, Unit unit) {
        this.optionType = optionType;
        this.items = items;
        this.count = count;
        this.unit = unit;
    }

    public FluffyOptionType getOptionType() { return optionType; }
    public void setOptionType(FluffyOptionType value) { this.optionType = value; }

    public Item[] getItems() { return items; }
    public void setItems(Item[] value) { this.items = value; }

    public Long getCount() { return count; }
    public void setCount(Long value) { this.count = value; }

    public Unit getUnit() { return unit; }
    public void setUnit(Unit value) { this.unit = value; }
}