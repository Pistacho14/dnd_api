// Proficiency.java

package org.iesteis.model.monsters;


import com.fasterxml.jackson.annotation.JsonProperty;
public class Proficiency {
    @JsonProperty("value")
    private long value;
    @JsonProperty("proficiency")
    private ConditionImmunity proficiency;
    public Proficiency() {}

    public Proficiency(long value, ConditionImmunity proficiency) {
        this.value = value;
        this.proficiency = proficiency;
    }

    public long getValue() { return value; }
    public void setValue(long value) { this.value = value; }

    public ConditionImmunity getProficiency() { return proficiency; }
    public void setProficiency(ConditionImmunity value) { this.proficiency = value; }
}

