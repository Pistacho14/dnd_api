package org.iesteis.model.classes;

public class PrerequisiteOptions {
    private String type;
    private long choose;
    private PrerequisiteOptionsFrom from;

    public String getType() { return type; }
    public void setType(String value) { this.type = value; }

    public long getChoose() { return choose; }
    public void setChoose(long value) { this.choose = value; }

    public PrerequisiteOptionsFrom getFrom() { return from; }
    public void setFrom(PrerequisiteOptionsFrom value) { this.from = value; }
}