// SpecialAbilityUsage.java

package org.iesteis.model.monsters;


import com.fasterxml.jackson.annotation.JsonProperty;
/**
 * Frecuencia y límites de uso de una aptitud especial.
 */
public class SpecialAbilityUsage {
    @JsonProperty("type")
    private FluffyType type;
    @JsonProperty("times")
    private long times;
    @JsonProperty("times_in_lair")
    private Long timesInLair;
    public SpecialAbilityUsage() {}

    public SpecialAbilityUsage(FluffyType type, long times, Long timesInLair) {
        this.type = type;
        this.times = times;
        this.timesInLair = timesInLair;
    }

    public FluffyType getType() { return type; }
    public void setType(FluffyType value) { this.type = value; }

    public long getTimes() { return times; }
    public void setTimes(long value) { this.times = value; }

    public Long getTimesInLair() { return timesInLair; }
    public void setTimesInLair(Long value) { this.timesInLair = value; }
}

