package org.iesteis.model.background;

public class Choice {
    private long choose;
    private String type;
    private ChoiceFrom from;

    public long getChoose() { return choose; }
    public void setChoose(long value) { this.choose = value; }

    public String getType() { return type; }
    public void setType(String value) { this.type = value; }

    public ChoiceFrom getFrom() { return from; }
    public void setFrom(ChoiceFrom value) { this.from = value; }
}