package org.iesteis.model.Equipment;

public class ArmorClass {
    private long base;
    private boolean dexBonus;
    private Long maxBonus;

    public long getBase() { return base; }
    public void setBase(long value) { this.base = value; }

    public boolean getDexBonus() { return dexBonus; }
    public void setDexBonus(boolean value) { this.dexBonus = value; }

    public Long getMaxBonus() { return maxBonus; }
    public void setMaxBonus(Long value) { this.maxBonus = value; }
}