package org.iesteis.model.traits;


import com.fasterxml.jackson.annotation.JsonProperty;
/**
 * Elección de competencias concedidas por un rasgo.
 */
public class ProficiencyChoices {
    @JsonProperty("desc")
    private String desc;
    @JsonProperty("choose")
    private long choose;
    @JsonProperty("type")
    private String type;
    @JsonProperty("from")
    private From from;
    public ProficiencyChoices() {}

    public ProficiencyChoices(String desc, long choose, String type, From from) {
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

    public From getFrom() { return from; }
    public void setFrom(From value) { this.from = value; }
}
