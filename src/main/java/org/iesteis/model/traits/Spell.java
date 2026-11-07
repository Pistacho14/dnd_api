package org.iesteis.model.traits;


import com.fasterxml.jackson.annotation.JsonProperty;
/**
 * Conjuro concedido por un rasgo y sus condiciones de uso y recuperación.
 */
public class Spell {
    @JsonProperty("spell")
    private Species spell;
    @JsonProperty("uses")
    private String uses;
    @JsonProperty("recovery")
    private String recovery;
    public Spell() {}

    public Spell(Species spell, String uses, String recovery) {
        this.spell = spell;
        this.uses = uses;
        this.recovery = recovery;
    }

    public Species getSpell() { return spell; }
    public void setSpell(Species value) { this.spell = value; }

    public String getUses() { return uses; }
    public void setUses(String value) { this.uses = value; }

    public String getRecovery() { return recovery; }
    public void setRecovery(String value) { this.recovery = value; }
}
