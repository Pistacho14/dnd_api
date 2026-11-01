package org.iesteis.model.equipment;

public class Cost {
    private long quantity;
    private Unit unit;

    public long getQuantity() { return quantity; }
    public void setQuantity(long value) { this.quantity = value; }

    public Unit getUnit() { return unit; }
    public void setUnit(Unit value) { this.unit = value; }
}