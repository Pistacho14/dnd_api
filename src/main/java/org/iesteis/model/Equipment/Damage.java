package org.iesteis.model.equipment;

public class Damage {
    private String damageDice;
    private Ability damageType;

    public String getDamageDice() { return damageDice; }
    public void setDamageDice(String value) { this.damageDice = value; }

    public Ability getDamageType() { return damageType; }
    public void setDamageType(Ability value) { this.damageType = value; }
}