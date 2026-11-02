// ActionUsage.java

package org.iesteis.model.monsters;


import com.fasterxml.jackson.annotation.JsonProperty;
public class ActionUsage {
    @JsonProperty("type")
    private TentacledType type;
    @JsonProperty("times")
    private Long times;
    @JsonProperty("dice")
    private Dice dice;
    @JsonProperty("min_value")
    private Long minValue;
    @JsonProperty("rest_types")
    private String[] restTypes;
    public ActionUsage() {}

    public ActionUsage(TentacledType type, Long times, Dice dice, Long minValue, String[] restTypes) {
        this.type = type;
        this.times = times;
        this.dice = dice;
        this.minValue = minValue;
        this.restTypes = restTypes;
    }

    public TentacledType getType() { return type; }
    public void setType(TentacledType value) { this.type = value; }

    public Long getTimes() { return times; }
    public void setTimes(Long value) { this.times = value; }

    public Dice getDice() { return dice; }
    public void setDice(Dice value) { this.dice = value; }

    public Long getMinValue() { return minValue; }
    public void setMinValue(Long value) { this.minValue = value; }

    public String[] getRESTTypes() { return restTypes; }
    public void setRESTTypes(String[] value) { this.restTypes = value; }
}

