package org.iesteis.model.equipment;

import com.fasterxml.jackson.annotation.JsonProperty;
/**
 * Daño de un equipo, con sus dados y tipo de daño.
 */
public class Damage {
    @JsonProperty("damage_dice")
    private String damageDice;
    @JsonProperty("damage_type")
    private Ability damageType;
    public Damage() {}

    public Damage(String damageDice, Ability damageType) {
        this.damageDice = damageDice;
        this.damageType = damageType;
    }

    public String getDamageDice() { return damageDice; }
    public void setDamageDice(String value) { this.damageDice = value; }

    public Ability getDamageType() { return damageType; }
    public void setDamageType(Ability value) { this.damageType = value; }
}