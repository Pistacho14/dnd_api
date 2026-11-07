// LegendaryAction.java

package org.iesteis.model.monsters;


import com.fasterxml.jackson.annotation.JsonProperty;
/**
 * Acción legendaria de un monstruo y sus efectos asociados.
 */
public class LegendaryAction {
    @JsonProperty("name")
    private String name;
    @JsonProperty("desc")
    private String desc;
    @JsonProperty("damage")
    private Damage[] damage;
    @JsonProperty("dc")
    private Dc dc;
    @JsonProperty("spellcasting")
    private LegendaryActionSpellcasting spellcasting;
    public LegendaryAction() {}

    public LegendaryAction(String name, String desc, Damage[] damage, Dc dc, LegendaryActionSpellcasting spellcasting) {
        this.name = name;
        this.desc = desc;
        this.damage = damage;
        this.dc = dc;
        this.spellcasting = spellcasting;
    }

    public String getName() { return name; }
    public void setName(String value) { this.name = value; }

    public String getDesc() { return desc; }
    public void setDesc(String value) { this.desc = value; }

    public Damage[] getDamage() { return damage; }
    public void setDamage(Damage[] value) { this.damage = value; }

    public Dc getDc() { return dc; }
    public void setDc(Dc value) { this.dc = value; }

    public LegendaryActionSpellcasting getSpellcasting() { return spellcasting; }
    public void setSpellcasting(LegendaryActionSpellcasting value) { this.spellcasting = value; }
}

