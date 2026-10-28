package org.iesteis.model.Background;

public class PurpleOption {
    private String optionType;
    private Item[] items;
    private Long count;
    private String unit;

    public String getOptionType() { return optionType; }
    public void setOptionType(String value) { this.optionType = value; }

    public Item[] getItems() { return items; }
    public void setItems(Item[] value) { this.items = value; }

    public Long getCount() { return count; }
    public void setCount(Long value) { this.count = value; }

    public String getUnit() { return unit; }
    public void setUnit(String value) { this.unit = value; }
}