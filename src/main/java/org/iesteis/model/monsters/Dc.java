// Dc.java

package org.iesteis.model.monsters;


import com.fasterxml.jackson.annotation.JsonProperty;
public class Dc {
    @JsonProperty("dc_type")
    private ConditionImmunity dcType;
    @JsonProperty("dc_value")
    private Long dcValue;
    @JsonProperty("success_type")
    private SuccessType successType;
    public Dc() {}

    public Dc(ConditionImmunity dcType, Long dcValue, SuccessType successType) {
        this.dcType = dcType;
        this.dcValue = dcValue;
        this.successType = successType;
    }

    public ConditionImmunity getDcType() { return dcType; }
    public void setDcType(ConditionImmunity value) { this.dcType = value; }

    public Long getDcValue() { return dcValue; }
    public void setDcValue(Long value) { this.dcValue = value; }

    public SuccessType getSuccessType() { return successType; }
    public void setSuccessType(SuccessType value) { this.successType = value; }
}

