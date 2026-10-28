package org.iesteis.model.Classes;

public class PrimaryAbility {
    private String desc;
    private Proficiency[] abilityScores;
    private AbilityScoreOptions abilityScoreOptions;

    public String getDesc() { return desc; }
    public void setDesc(String value) { this.desc = value; }

    public Proficiency[] getAbilityScores() { return abilityScores; }
    public void setAbilityScores(Proficiency[] value) { this.abilityScores = value; }

    public AbilityScoreOptions getAbilityScoreOptions() { return abilityScoreOptions; }
    public void setAbilityScoreOptions(AbilityScoreOptions value) { this.abilityScoreOptions = value; }
}