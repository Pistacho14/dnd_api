package org.iesteis.model.classes;

import com.fasterxml.jackson.annotation.JsonProperty;
/**
 * Datos de lanzamiento de conjuros de una clase para un nivel dado.
 */
public class Spellcasting {
    @JsonProperty("level")
    private long level;
    @JsonProperty("spellcasting_ability")
    private Proficiency spellcastingAbility;
    @JsonProperty("info")
    private Info[] info;
    public Spellcasting() {}

    public Spellcasting(long level, Proficiency spellcastingAbility, Info[] info) {
        this.level = level;
        this.spellcastingAbility = spellcastingAbility;
        this.info = info;
    }

    public long getLevel() { return level; }
    public void setLevel(long value) { this.level = value; }

    public Proficiency getSpellcastingAbility() { return spellcastingAbility; }
    public void setSpellcastingAbility(Proficiency value) { this.spellcastingAbility = value; }

    public Info[] getInfo() { return info; }
    public void setInfo(Info[] value) { this.info = value; }
}