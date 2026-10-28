package org.iesteis.model.Equipment;

public class Dc {
    private Ability dcType;
    private long dcValue;
    private SuccessType successType;

    public Ability getDcType() { return dcType; }
    public void setDcType(Ability value) { this.dcType = value; }

    public long getDcValue() { return dcValue; }
    public void setDcValue(long value) { this.dcValue = value; }

    public SuccessType getSuccessType() { return successType; }
    public void setSuccessType(SuccessType value) { this.successType = value; }
}