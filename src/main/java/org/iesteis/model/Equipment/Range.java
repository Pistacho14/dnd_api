package org.iesteis.model.equipment;

import com.fasterxml.jackson.annotation.JsonProperty;
/**
 * Alcance normal y largo de un equipo.
 */
public class Range {
    @JsonProperty("normal")
    private long normal;
    @JsonProperty("range_long")
    private Long rangeLong;
    public Range() {}

    public Range(long normal, Long rangeLong) {
        this.normal = normal;
        this.rangeLong = rangeLong;
    }

    public long getNormal() { return normal; }
    public void setNormal(long value) { this.normal = value; }

    public Long getRangeLong() { return rangeLong; }
    public void setRangeLong(Long value) { this.rangeLong = value; }
}