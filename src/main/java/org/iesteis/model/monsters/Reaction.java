// Reaction.java

package org.iesteis.model.monsters;


import com.fasterxml.jackson.annotation.JsonProperty;
public class Reaction {
    @JsonProperty("name")
    private String name;
    @JsonProperty("desc")
    private String desc;
    @JsonProperty("dc")
    private Dc dc;
    @JsonProperty("spellcasting")
    private LegendaryActionSpellcasting spellcasting;
    @JsonProperty("usage")
    private ActionUsage usage;
    @JsonProperty("damage")
    private Damage[] damage;
    public Reaction() {}

    public Reaction(String name, String desc, Dc dc, LegendaryActionSpellcasting spellcasting, ActionUsage usage, Damage[] damage) {
        this.name = name;
        this.desc = desc;
        this.dc = dc;
        this.spellcasting = spellcasting;
        this.usage = usage;
        this.damage = damage;
    }

    public String getName() { return name; }
    public void setName(String value) { this.name = value; }

    public String getDesc() { return desc; }
    public void setDesc(String value) { this.desc = value; }

    public Dc getDc() { return dc; }
    public void setDc(Dc value) { this.dc = value; }

    public LegendaryActionSpellcasting getSpellcasting() { return spellcasting; }
    public void setSpellcasting(LegendaryActionSpellcasting value) { this.spellcasting = value; }

    public ActionUsage getUsage() { return usage; }
    public void setUsage(ActionUsage value) { this.usage = value; }

    public Damage[] getDamage() { return damage; }
    public void setDamage(Damage[] value) { this.damage = value; }
}

