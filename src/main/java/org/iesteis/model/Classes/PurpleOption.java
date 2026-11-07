package org.iesteis.model.classes;

import com.fasterxml.jackson.annotation.JsonProperty;
/**
 * Alternativa de competencia o requisito con su puntuación mínima.
 */
public class PurpleOption {
    @JsonProperty("option_type")
    private String optionType;
    @JsonProperty("ability_score")
    private Proficiency abilityScore;
    @JsonProperty("minimum_score")
    private long minimumScore;
    public PurpleOption() {}

    public PurpleOption(String optionType, Proficiency abilityScore, long minimumScore) {
        this.optionType = optionType;
        this.abilityScore = abilityScore;
        this.minimumScore = minimumScore;
    }

    public String getOptionType() { return optionType; }
    public void setOptionType(String value) { this.optionType = value; }

    public Proficiency getAbilityScore() { return abilityScore; }
    public void setAbilityScore(Proficiency value) { this.abilityScore = value; }

    public long getMinimumScore() { return minimumScore; }
    public void setMinimumScore(long value) { this.minimumScore = value; }
}