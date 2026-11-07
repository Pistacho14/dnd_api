package org.iesteis.model.classes;

import com.fasterxml.jackson.annotation.JsonProperty;
/**
 * Características principales de una clase y las opciones para seleccionarlas.
 */
public class PrimaryAbility {
    @JsonProperty("desc")
    private String desc;
    @JsonProperty("ability_scores")
    private Proficiency[] abilityScores;
    @JsonProperty("ability_score_options")
    private AbilityScoreOptions abilityScoreOptions;
    public PrimaryAbility() {}

    public PrimaryAbility(String desc, Proficiency[] abilityScores, AbilityScoreOptions abilityScoreOptions) {
        this.desc = desc;
        this.abilityScores = abilityScores;
        this.abilityScoreOptions = abilityScoreOptions;
    }

    public String getDesc() { return desc; }
    public void setDesc(String value) { this.desc = value; }

    public Proficiency[] getAbilityScores() { return abilityScores; }
    public void setAbilityScores(Proficiency[] value) { this.abilityScores = value; }

    public AbilityScoreOptions getAbilityScoreOptions() { return abilityScoreOptions; }
    public void setAbilityScoreOptions(AbilityScoreOptions value) { this.abilityScoreOptions = value; }
}