package org.iesteis.model.Background;

public class ProficiencyChoice {
    private String desc;
    private long choose;
    private String type;
    private ProficiencyChoiceFrom from;

    public String getDesc() { return desc; }
    public void setDesc(String value) { this.desc = value; }

    public long getChoose() { return choose; }
    public void setChoose(long value) { this.choose = value; }

    public String getType() { return type; }
    public void setType(String value) { this.type = value; }

    public ProficiencyChoiceFrom getFrom() { return from; }
    public void setFrom(ProficiencyChoiceFrom value) { this.from = value; }
}