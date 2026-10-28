package org.iesteis.model.Equipment;

public class Content {
    private Ability item;
    private long quantity;

    public Ability getItem() { return item; }
    public void setItem(Ability value) { this.item = value; }

    public long getQuantity() { return quantity; }
    public void setQuantity(long value) { this.quantity = value; }
}