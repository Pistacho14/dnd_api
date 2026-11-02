package org.iesteis.model.magicItems;


import com.fasterxml.jackson.annotation.JsonProperty;
public class Rarity {
    @JsonProperty("name")
    private Name name;
    public Rarity() {}

    public Rarity(Name name) {
        this.name = name;
    }

    public Name getName() { return name; }
    public void setName(Name value) { this.name = value; }
}
