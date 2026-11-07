// ActionSpellcasting.java

package org.iesteis.model.monsters;


import com.fasterxml.jackson.annotation.JsonProperty;
/**
 * Datos de lanzamiento de conjuros asociados a una acción de monstruo.
 */
public class ActionSpellcasting {
    @JsonProperty("ability")
    private ConditionImmunity ability;
    @JsonProperty("dc")
    private Long dc;
    @JsonProperty("modifier")
    private Long modifier;
    @JsonProperty("components_required")
    private ComponentsRequired[] componentsRequired;
    @JsonProperty("spells")
    private Spell[] spells;
    public ActionSpellcasting() {}

    public ActionSpellcasting(ConditionImmunity ability, Long dc, Long modifier, ComponentsRequired[] componentsRequired, Spell[] spells) {
        this.ability = ability;
        this.dc = dc;
        this.modifier = modifier;
        this.componentsRequired = componentsRequired;
        this.spells = spells;
    }

    public ConditionImmunity getAbility() { return ability; }
    public void setAbility(ConditionImmunity value) { this.ability = value; }

    public Long getDc() { return dc; }
    public void setDc(Long value) { this.dc = value; }

    public Long getModifier() { return modifier; }
    public void setModifier(Long value) { this.modifier = value; }

    public ComponentsRequired[] getComponentsRequired() { return componentsRequired; }
    public void setComponentsRequired(ComponentsRequired[] value) { this.componentsRequired = value; }

    public Spell[] getSpells() { return spells; }
    public void setSpells(Spell[] value) { this.spells = value; }
}

