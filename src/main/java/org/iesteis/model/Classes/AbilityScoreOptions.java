package org.iesteis.model.Classes;

public class AbilityScoreOptions {
    private String desc;
    private long choose;
    private String type;
    private AbilityScoreOptionsFrom from;

    public String getDesc() { return desc; }
    public void setDesc(String value) { this.desc = value; }

    public long getChoose() { return choose; }
    public void setChoose(long value) { this.choose = value; }

    public String getType() { return type; }
    public void setType(String value) { this.type = value; }

    public AbilityScoreOptionsFrom getFrom() { return from; }
    public void setFrom(AbilityScoreOptionsFrom value) { this.from = value; }
}