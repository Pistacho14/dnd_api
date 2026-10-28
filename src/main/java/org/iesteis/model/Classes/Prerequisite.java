package org.iesteis.model.Classes;

public class Prerequisite {
    private Proficiency abilityScore;
    private long minimumScore;

    public Proficiency getAbilityScore() { return abilityScore; }
    public void setAbilityScore(Proficiency value) { this.abilityScore = value; }

    public long getMinimumScore() { return minimumScore; }
    public void setMinimumScore(long value) { this.minimumScore = value; }
}