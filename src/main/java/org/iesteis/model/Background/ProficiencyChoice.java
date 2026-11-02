package org.iesteis.model.background;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ProficiencyChoice {
    public ProficiencyChoice(String desc, long choose, String type, ProficiencyChoiceFrom from) {
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
    private String type;
    @JsonProperty("from")
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