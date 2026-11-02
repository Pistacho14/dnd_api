// Damage.java

package org.iesteis.model.monsters;


import com.fasterxml.jackson.annotation.JsonProperty;
public class Damage {
    @JsonProperty("damage_type")
    private ConditionImmunity damageType;
    @JsonProperty("damage_dice")
    private String damageDice;
    public Damage() {}

    public Damage(ConditionImmunity damageType, String damageDice) {
        this.damageType = damageType;
        this.damageDice = damageDice;
    }

    public ConditionImmunity getDamageType() { return damageType; }
    public void setDamageType(ConditionImmunity value) { this.damageType = value; }

    public String getDamageDice() { return damageDice; }
    public void setDamageDice(String value) { this.damageDice = value; }
}

