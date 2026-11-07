// LegendaryActionSpellcasting.java

package org.iesteis.model.monsters;


import com.fasterxml.jackson.annotation.JsonProperty;
/**
 * Información de lanzamiento de conjuros asociada a una acción legendaria.
 */
public class LegendaryActionSpellcasting {
    @JsonProperty("ability")
    private ConditionImmunity ability;
    @JsonProperty("dc")
    private long dc;
    @JsonProperty("components_required")
    private ComponentsRequired[] componentsRequired;
    @JsonProperty("spells")
    private ConditionImmunity[] spells;
    @JsonProperty("modifier")
    private Long modifier;
    public LegendaryActionSpellcasting() {}

    public LegendaryActionSpellcasting(ConditionImmunity ability, long dc, ComponentsRequired[] componentsRequired, ConditionImmunity[] spells, Long modifier) {
        this.ability = ability;
        this.dc = dc;
        this.componentsRequired = componentsRequired;
        this.spells = spells;
        this.modifier = modifier;
    }

    public ConditionImmunity getAbility() { return ability; }
    public void setAbility(ConditionImmunity value) { this.ability = value; }

    public long getDc() { return dc; }
    public void setDc(long value) { this.dc = value; }

    public ComponentsRequired[] getComponentsRequired() { return componentsRequired; }
    public void setComponentsRequired(ComponentsRequired[] value) { this.componentsRequired = value; }

    public ConditionImmunity[] getSpells() { return spells; }
    public void setSpells(ConditionImmunity[] value) { this.spells = value; }

    public Long getModifier() { return modifier; }
    public void setModifier(Long value) { this.modifier = value; }
}

