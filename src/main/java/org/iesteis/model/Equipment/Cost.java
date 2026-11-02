package org.iesteis.model.equipment;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Cost {
    public Cost(long quantity, Unit unit) {
        this.quantity = quantity;
        this.unit = unit;
    }

    public Cost() {}

    @JsonProperty("quantity")
    private long quantity;
    @JsonProperty("unit")
    private Unit unit;

    public long getQuantity() { return quantity; }
    public void setQuantity(long value) { this.quantity = value; }

    public Unit getUnit() { return unit; }
    public void setUnit(Unit value) { this.unit = value; }
}