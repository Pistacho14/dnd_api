package org.iesteis.model.classes;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PrerequisiteOptions {
    @JsonProperty("type")
    private String type;
    @JsonProperty("choose")
    private long choose;
    @JsonProperty("from")
    private PrerequisiteOptionsFrom from;
    public PrerequisiteOptions() {}

    public PrerequisiteOptions(String type, long choose, PrerequisiteOptionsFrom from) {
        this.type = type;
        this.choose = choose;
        this.from = from;
    }

    public String getType() { return type; }
    public void setType(String value) { this.type = value; }

    public long getChoose() { return choose; }
    public void setChoose(long value) { this.choose = value; }

    public PrerequisiteOptionsFrom getFrom() { return from; }
    public void setFrom(PrerequisiteOptionsFrom value) { this.from = value; }
}