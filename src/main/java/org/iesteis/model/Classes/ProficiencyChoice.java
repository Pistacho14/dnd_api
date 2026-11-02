package org.iesteis.model.classes;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ProficiencyChoice {
    public ProficiencyChoice(String desc, long choose, ProficiencyChoiceType type, PurpleFrom from) {
        this.desc = desc;
        this.choose = choose;
        this.type = type;
        this.from = from;
    }

    public ProficiencyChoice() {}

    @JsonProperty("desc")
    private String desc;
    @JsonProperty("choose")
    private long choose;
    @JsonProperty("type")
    private ProficiencyChoiceType type;
    @JsonProperty("from")
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