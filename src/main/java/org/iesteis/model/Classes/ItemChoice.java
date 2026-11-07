package org.iesteis.model.classes;

import com.fasterxml.jackson.annotation.JsonProperty;
/**
 * Elección de elementos de equipo inicial de una clase.
 */
public class ItemChoice {
    @JsonProperty("desc")
    private String desc;
    @JsonProperty("choose")
    private long choose;
    @JsonProperty("type")
    private ChoiceType type;
    @JsonProperty("from")
    private FluffyFrom from;
    public ItemChoice() {}

    public ItemChoice(String desc, long choose, ChoiceType type, FluffyFrom from) {
        this.desc = desc;
        this.choose = choose;
        this.type = type;
        this.from = from;
    }

    public String getDesc() { return desc; }
    public void setDesc(String value) { this.desc = value; }

    public long getChoose() { return choose; }
    public void setChoose(long value) { this.choose = value; }

    public ChoiceType getType() { return type; }
    public void setType(ChoiceType value) { this.type = value; }

    public FluffyFrom getFrom() { return from; }
    public void setFrom(FluffyFrom value) { this.from = value; }
}