package org.iesteis.model.background;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PurpleOption {
    @JsonProperty("option_type")
    private String optionType;
    @JsonProperty("items")
    private Item[] items;
    @JsonProperty("count")
    private Long count;
    @JsonProperty("unit")
    private String unit;
    public PurpleOption() {}

    public PurpleOption(String optionType, Item[] items, Long count, String unit) {
        this.optionType = optionType;
        this.items = items;
        this.count = count;
        this.unit = unit;
    }

    public String getOptionType() { return optionType; }
    public void setOptionType(String value) { this.optionType = value; }

    public Item[] getItems() { return items; }
    public void setItems(Item[] value) { this.items = value; }

    public Long getCount() { return count; }
    public void setCount(Long value) { this.count = value; }

    public String getUnit() { return unit; }
    public void setUnit(String value) { this.unit = value; }
}