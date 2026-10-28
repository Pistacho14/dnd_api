package org.iesteis.model.Classes;

public class ItemChoice {
    private String desc;
    private long choose;
    private ChoiceType type;
    private FluffyFrom from;

    public String getDesc() { return desc; }
    public void setDesc(String value) { this.desc = value; }

    public long getChoose() { return choose; }
    public void setChoose(long value) { this.choose = value; }

    public ChoiceType getType() { return type; }
    public void setType(ChoiceType value) { this.type = value; }

    public FluffyFrom getFrom() { return from; }
    public void setFrom(FluffyFrom value) { this.from = value; }
}