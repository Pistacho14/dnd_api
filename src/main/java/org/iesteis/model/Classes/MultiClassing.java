package org.iesteis.model.classes;

import com.fasterxml.jackson.annotation.JsonProperty;

public class MultiClassing {
    @JsonProperty("prerequisites")
    private Prerequisite[] prerequisites;
    @JsonProperty("proficiencies")
    private Proficiency[] proficiencies;
    @JsonProperty("proficiency_choices")
    private AbilityScoreOptions[] proficiencyChoices;
    @JsonProperty("prerequisite_options")
    private PrerequisiteOptions prerequisiteOptions;
    public MultiClassing() {}

    public MultiClassing(Prerequisite[] prerequisites, Proficiency[] proficiencies, AbilityScoreOptions[] proficiencyChoices, PrerequisiteOptions prerequisiteOptions) {
        this.prerequisites = prerequisites;
        this.proficiencies = proficiencies;
        this.proficiencyChoices = proficiencyChoices;
        this.prerequisiteOptions = prerequisiteOptions;
    }

    public Prerequisite[] getPrerequisites() { return prerequisites; }
    public void setPrerequisites(Prerequisite[] value) { this.prerequisites = value; }

    public Proficiency[] getProficiencies() { return proficiencies; }
    public void setProficiencies(Proficiency[] value) { this.proficiencies = value; }

    public AbilityScoreOptions[] getProficiencyChoices() { return proficiencyChoices; }
    public void setProficiencyChoices(AbilityScoreOptions[] value) { this.proficiencyChoices = value; }

    public PrerequisiteOptions getPrerequisiteOptions() { return prerequisiteOptions; }
    public void setPrerequisiteOptions(PrerequisiteOptions value) { this.prerequisiteOptions = value; }
}