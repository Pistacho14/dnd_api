package org.iesteis.model.equipment;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Content {
    public Content(Ability item, long quantity) {
        this.item = item;
        this.quantity = quantity;
    }

    public Content() {}

    @JsonProperty("item")
    private Ability item;
    @JsonProperty("quantity")
    private long quantity;

    public Ability getItem() { return item; }
    public void setItem(Ability value) { this.item = value; }

    public long getQuantity() { return quantity; }
    public void setQuantity(long value) { this.quantity = value; }
}