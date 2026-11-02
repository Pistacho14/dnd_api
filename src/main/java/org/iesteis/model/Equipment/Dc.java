package org.iesteis.model.equipment;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Dc {
    @JsonProperty("dc_type")
    private Ability dcType;
    @JsonProperty("dc_value")
    private long dcValue;
    @JsonProperty("success_type")
    private SuccessType successType;
    public Dc() {}

    public Dc(Ability dcType, long dcValue, SuccessType successType) {
        this.dcType = dcType;
        this.dcValue = dcValue;
        this.successType = successType;
    }

    public Ability getDcType() { return dcType; }
    public void setDcType(Ability value) { this.dcType = value; }

    public long getDcValue() { return dcValue; }
    public void setDcValue(long value) { this.dcValue = value; }

    public SuccessType getSuccessType() { return successType; }
    public void setSuccessType(SuccessType value) { this.successType = value; }
}