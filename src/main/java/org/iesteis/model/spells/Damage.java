package org.iesteis.model.spells;


import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Map;
/**
 * Tipos de daño de un conjuro y su daño según el nivel de espacio.
 */
public class Damage {
    @JsonProperty("damage_type")
    private School damageType;
    @JsonProperty("damage_at_slot_level")
    private Map<String, String> damageAtSlotLevel;
    public Damage() {}

    public Damage(School damageType, Map<String, String> damageAtSlotLevel) {
        this.damageType = damageType;
        this.damageAtSlotLevel = damageAtSlotLevel;
    }

    public School getDamageType() { return damageType; }
    public void setDamageType(School value) { this.damageType = value; }

    public Map<String, String> getDamageAtSlotLevel() { return damageAtSlotLevel; }
    public void setDamageAtSlotLevel(Map<String, String> value) { this.damageAtSlotLevel = value; }
}
