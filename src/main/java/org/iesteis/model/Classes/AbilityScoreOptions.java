package org.iesteis.model.classes;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AbilityScoreOptions {
    @JsonProperty("desc")
    private String desc;
    @JsonProperty("choose")
    private long choose;
    @JsonProperty("type")
    private String type;
    @JsonProperty("from")
    private AbilityScoreOptionsFrom from;
    public AbilityScoreOptions() {}

    public AbilityScoreOptions(String desc, long choose, String type, AbilityScoreOptionsFrom from) {
        this.desc = desc;
        this.choose = choose;
        this.type = type;
        this.from = from;
    }

    public String getDesc() { return desc; }
    public void setDesc(String value) { this.desc = value; }

    public long getChoose() { return choose; }
    public void setChoose(long value) { this.choose = value; }

    public String getType() { return type; }
    public void setType(String value) { this.type = value; }

    public AbilityScoreOptionsFrom getFrom() { return from; }
    public void setFrom(AbilityScoreOptionsFrom value) { this.from = value; }
}