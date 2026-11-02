package org.iesteis.model.abilityScores;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AbilityScores {
    private String index;
    private String name;
    @JsonProperty("full_name")
    private String fullName;
    private String description;
    private Skill[] skills;
    private String url;

    

    public AbilityScores(String index, String name, String fullName, String description, Skill[] skills, String url) {
        this.index = index;
        this.name = name;
        this.fullName = fullName;
        this.description = description;
        this.skills = skills;
        this.url = url;
    }

    public AbilityScores() {}

    public String getIndex() { return index; }
    public void setIndex(String value) { this.index = value; }

    public String getName() { return name; }
    public void setName(String value) { this.name = value; }

    public String getFullName() { return fullName; }
    public void setFullName(String value) { this.fullName = value; }

    public String getDescription() { return description; }
    public void setDescription(String value) { this.description = value; }

    public Skill[] getSkills() { return skills; }
    public void setSkills(Skill[] value) { this.skills = value; }

    public String getUrl() { return url; }
    public void setUrl(String value) { this.url = value; }

}