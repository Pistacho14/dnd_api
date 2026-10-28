package org.iesteis.model.Classes;

public class PurpleOption {
    private String optionType;
    private Proficiency abilityScore;
    private long minimumScore;

    public String getOptionType() { return optionType; }
    public void setOptionType(String value) { this.optionType = value; }

    public Proficiency getAbilityScore() { return abilityScore; }
    public void setAbilityScore(Proficiency value) { this.abilityScore = value; }

    public long getMinimumScore() { return minimumScore; }
    public void setMinimumScore(long value) { this.minimumScore = value; }
}