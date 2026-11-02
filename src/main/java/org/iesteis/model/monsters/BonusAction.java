// BonusAction.java

package org.iesteis.model.monsters;


import com.fasterxml.jackson.annotation.JsonProperty;
public class BonusAction {
    @JsonProperty("name")
    private String name;
    @JsonProperty("desc")
    private String desc;
    @JsonProperty("dc")
    private Dc dc;
    @JsonProperty("usage")
    private ActionUsage usage;
    @JsonProperty("damage")
    private Damage[] damage;
    @JsonProperty("spellcasting")
    private ActionSpellcasting spellcasting;
    public BonusAction() {}

    public BonusAction(String name, String desc, Dc dc, ActionUsage usage, Damage[] damage, ActionSpellcasting spellcasting) {
        this.name = name;
        this.desc = desc;
        this.dc = dc;
        this.usage = usage;
        this.damage = damage;
        this.spellcasting = spellcasting;
    }

    public String getName() { return name; }
    public void setName(String value) { this.name = value; }

    public String getDesc() { return desc; }
    public void setDesc(String value) { this.desc = value; }

    public Dc getDc() { return dc; }
    public void setDc(Dc value) { this.dc = value; }

    public ActionUsage getUsage() { return usage; }
    public void setUsage(ActionUsage value) { this.usage = value; }

    public Damage[] getDamage() { return damage; }
    public void setDamage(Damage[] value) { this.damage = value; }

    public ActionSpellcasting getSpellcasting() { return spellcasting; }
    public void setSpellcasting(ActionSpellcasting value) { this.spellcasting = value; }
}

