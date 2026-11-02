package org.iesteis.model.equipment;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ArmorClass {
    public ArmorClass(long base, boolean dexBonus, Long maxBonus) {
        this.base = base;
        this.dexBonus = dexBonus;
        this.maxBonus = maxBonus;
    }

    public ArmorClass() {}

    @JsonProperty("base")
    private long base;
    @JsonProperty("dex_bonus")
    private boolean dexBonus;
    @JsonProperty("max_bonus")
    private Long maxBonus;

    public long getBase() { return base; }
    public void setBase(long value) { this.base = value; }

    public boolean getDexBonus() { return dexBonus; }
    public void setDexBonus(boolean value) { this.dexBonus = value; }

    public Long getMaxBonus() { return maxBonus; }
    public void setMaxBonus(Long value) { this.maxBonus = value; }
}