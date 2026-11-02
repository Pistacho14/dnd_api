package org.iesteis.model.background;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Choice {
    public Choice(long choose, String type, ChoiceFrom from) {
        this.choose = choose;
        this.type = type;
        this.from = from;
    }

    public Choice() {}

    @JsonProperty("choose")
    private long choose;
    @JsonProperty("type")
    private String type;
    @JsonProperty("from")
    private ChoiceFrom from;

    public long getChoose() { return choose; }
    public void setChoose(long value) { this.choose = value; }

    public String getType() { return type; }
    public void setType(String value) { this.type = value; }

    public ChoiceFrom getFrom() { return from; }
    public void setFrom(ChoiceFrom value) { this.from = value; }
}