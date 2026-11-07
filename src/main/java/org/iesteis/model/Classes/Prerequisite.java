package org.iesteis.model.classes;

import com.fasterxml.jackson.annotation.JsonProperty;
/**
 * Requisito de multiclase basado en una característica y una puntuación mínima.
 */
public class Prerequisite {
    @JsonProperty("ability_score")
    private Proficiency abilityScore;
    @JsonProperty("minimum_score")
    private long minimumScore;
    public Prerequisite() {}

    public Prerequisite(Proficiency abilityScore, long minimumScore) {
        this.abilityScore = abilityScore;
        this.minimumScore = minimumScore;
    }

    public Proficiency getAbilityScore() { return abilityScore; }
    public void setAbilityScore(Proficiency value) { this.abilityScore = value; }

    public long getMinimumScore() { return minimumScore; }
    public void setMinimumScore(long value) { this.minimumScore = value; }
}