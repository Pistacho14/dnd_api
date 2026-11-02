// ActionOptions.java

package org.iesteis.model.monsters;


import com.fasterxml.jackson.annotation.JsonProperty;
public class ActionOptions {
    @JsonProperty("choose")
    private long choose;
    @JsonProperty("type")
    private ActionOptionType type;
    @JsonProperty("from")
    private From from;
    @JsonProperty("desc")
    private String desc;
    public ActionOptions() {}

    public ActionOptions(long choose, ActionOptionType type, From from, String desc) {
        this.choose = choose;
        this.type = type;
        this.from = from;
        this.desc = desc;
    }

    public long getChoose() { return choose; }
    public void setChoose(long value) { this.choose = value; }

    public ActionOptionType getType() { return type; }
    public void setType(ActionOptionType value) { this.type = value; }

    public From getFrom() { return from; }
    public void setFrom(From value) { this.from = value; }

    public String getDesc() { return desc; }
    public void setDesc(String value) { this.desc = value; }
}

