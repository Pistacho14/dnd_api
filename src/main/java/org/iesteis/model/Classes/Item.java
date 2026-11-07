package org.iesteis.model.classes;

import com.fasterxml.jackson.annotation.JsonProperty;
/**
 * Elemento del equipo inicial, expresado como referencia, cantidad o elección.
 */
public class Item {
    @JsonProperty("option_type")
    private ItemOptionType optionType;
    @JsonProperty("count")
    private Long count;
    @JsonProperty("of")
    private Proficiency of;
    @JsonProperty("unit")
    private Unit unit;
    @JsonProperty("choice")
    private ItemChoice choice;
    public Item() {}

    public Item(ItemOptionType optionType, Long count, Proficiency of, Unit unit, ItemChoice choice) {
        this.optionType = optionType;
        this.count = count;
        this.of = of;
        this.unit = unit;
        this.choice = choice;
    }

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