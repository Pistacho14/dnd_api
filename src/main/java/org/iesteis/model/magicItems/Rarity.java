package org.iesteis.model.magicItems;


import com.fasterxml.jackson.annotation.JsonProperty;
/**
 * Rareza de un objeto mágico.
 */
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
