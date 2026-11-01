package org.iesteis.model.classes;

public class OptionChoice {
    private String desc;
    private long choose;
    private ChoiceType type;
    private TentacledFrom from;

    public String getDesc() { return desc; }
    public void setDesc(String value) { this.desc = value; }

    public long getChoose() { return choose; }
    public void setChoose(long value) { this.choose = value; }

    public ChoiceType getType() { return type; }
    public void setType(ChoiceType value) { this.type = value; }

    public TentacledFrom getFrom() { return from; }
    public void setFrom(TentacledFrom value) { this.from = value; }
}