package org.iesteis.model.classes;

import com.fasterxml.jackson.annotation.JsonProperty;

public class OptionChoice {
    public OptionChoice(String desc, long choose, ChoiceType type, TentacledFrom from) {
        this.desc = desc;
        this.choose = choose;
        this.type = type;
        this.from = from;
    }

    public OptionChoice() {}

    @JsonProperty("desc")
    private String desc;
    @JsonProperty("choose")
    private long choose;
    @JsonProperty("type")
    private ChoiceType type;
    @JsonProperty("from")
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