// MonsterAction.java

package org.iesteis.model.monsters;


import com.fasterxml.jackson.annotation.JsonProperty;
public class MonsterAction {
    @JsonProperty("name")
    private String name;
    @JsonProperty("desc")
    private String desc;
    @JsonProperty("multiattack_type")
    private MultiattackType multiattackType;
    @JsonProperty("actions")
    private OptionElement[] actions;
    @JsonProperty("action_options")
    private ActionOptions actionOptions;
    @JsonProperty("damage")
    private Damage[] damage;
    @JsonProperty("dc")
    private Dc dc;
    @JsonProperty("attack_bonus")
    private Long attackBonus;
    @JsonProperty("usage")
    private ActionUsage usage;
    @JsonProperty("spellcasting")
    private ActionSpellcasting spellcasting;
    public MonsterAction() {}

    public MonsterAction(String name, String desc, MultiattackType multiattackType, OptionElement[] actions, ActionOptions actionOptions, Damage[] damage, Dc dc, Long attackBonus, ActionUsage usage, ActionSpellcasting spellcasting) {
        this.name = name;
        this.desc = desc;
        this.multiattackType = multiattackType;
        this.actions = actions;
        this.actionOptions = actionOptions;
        this.damage = damage;
        this.dc = dc;
        this.attackBonus = attackBonus;
        this.usage = usage;
        this.spellcasting = spellcasting;
    }

    public String getName() { return name; }
    public void setName(String value) { this.name = value; }

    public String getDesc() { return desc; }
    public void setDesc(String value) { this.desc = value; }

    public MultiattackType getMultiattackType() { return multiattackType; }
    public void setMultiattackType(MultiattackType value) { this.multiattackType = value; }

    public OptionElement[] getActions() { return actions; }
    public void setActions(OptionElement[] value) { this.actions = value; }

    public ActionOptions getActionOptions() { return actionOptions; }
    public void setActionOptions(ActionOptions value) { this.actionOptions = value; }

    public Damage[] getDamage() { return damage; }
    public void setDamage(Damage[] value) { this.damage = value; }

    public Dc getDc() { return dc; }
    public void setDc(Dc value) { this.dc = value; }

    public Long getAttackBonus() { return attackBonus; }
    public void setAttackBonus(Long value) { this.attackBonus = value; }

    public ActionUsage getUsage() { return usage; }
    public void setUsage(ActionUsage value) { this.usage = value; }

    public ActionSpellcasting getSpellcasting() { return spellcasting; }
    public void setSpellcasting(ActionSpellcasting value) { this.spellcasting = value; }
}
