// Damage.java

package org.iesteis.model.monsters;


import com.fasterxml.jackson.annotation.JsonProperty;
/**
 * Cantidad y tipo de daño producidos por una acción de monstruo.
 */
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

