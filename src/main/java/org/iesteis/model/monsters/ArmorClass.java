// ArmorClass.java

package org.iesteis.model.monsters;


import com.fasterxml.jackson.annotation.JsonProperty;
/**
 * Clase de armadura de un monstruo y sus componentes.
 */
public class ArmorClass {
    @JsonProperty("value")
    private long value;
    @JsonProperty("armor")
    private ConditionImmunity[] armor;
    public ArmorClass() {}

    public ArmorClass(long value, ConditionImmunity[] armor) {
        this.value = value;
        this.armor = armor;
    }

    public long getValue() { return value; }
    public void setValue(long value) { this.value = value; }

    public ConditionImmunity[] getArmor() { return armor; }
    public void setArmor(ConditionImmunity[] value) { this.armor = value; }
}

