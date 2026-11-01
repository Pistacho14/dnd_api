package org.iesteis.model.classes;

public class MultiClassing {
    private Prerequisite[] prerequisites;
    private Proficiency[] proficiencies;
    private AbilityScoreOptions[] proficiencyChoices;
    private PrerequisiteOptions prerequisiteOptions;

    public Prerequisite[] getPrerequisites() { return prerequisites; }
    public void setPrerequisites(Prerequisite[] value) { this.prerequisites = value; }

    public Proficiency[] getProficiencies() { return proficiencies; }
    public void setProficiencies(Proficiency[] value) { this.proficiencies = value; }

    public AbilityScoreOptions[] getProficiencyChoices() { return proficiencyChoices; }
    public void setProficiencyChoices(AbilityScoreOptions[] value) { this.proficiencyChoices = value; }

    public PrerequisiteOptions getPrerequisiteOptions() { return prerequisiteOptions; }
    public void setPrerequisiteOptions(PrerequisiteOptions value) { this.prerequisiteOptions = value; }
}