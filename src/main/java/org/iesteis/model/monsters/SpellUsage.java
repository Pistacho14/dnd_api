// SpellUsage.java

package org.iesteis.model.monsters;


import com.fasterxml.jackson.annotation.JsonProperty;
/**
 * Frecuencia y cantidad de usos de un conjuro de monstruo.
 */
public class SpellUsage {
    @JsonProperty("type")
    private FluffyType type;
    @JsonProperty("times")
    private Long times;
    public SpellUsage() {}

    public SpellUsage(FluffyType type, Long times) {
        this.type = type;
        this.times = times;
    }

    public FluffyType getType() { return type; }
    public void setType(FluffyType value) { this.type = value; }

    public Long getTimes() { return times; }
    public void setTimes(Long value) { this.times = value; }
}

