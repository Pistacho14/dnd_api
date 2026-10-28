package org.iesteis.model.Classes;

public class ProficiencyChoice {
    private String desc;
    private long choose;
    private ProficiencyChoiceType type;
    private PurpleFrom from;

    public String getDesc() { return desc; }
    public void setDesc(String value) { this.desc = value; }

    public long getChoose() { return choose; }
    public void setChoose(long value) { this.choose = value; }

    public ProficiencyChoiceType getType() { return type; }
    public void setType(ProficiencyChoiceType value) { this.type = value; }

    public PurpleFrom getFrom() { return from; }
    public void setFrom(PurpleFrom value) { this.from = value; }
}