package org.iesteis.model.AbilityScore;

public class AbilityScore {
    private String index;
    private String name;
    private String fullName;
    private String description;
    private Skill[] skills;
    private String url;

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

    public String getURL() { return url; }
    public void setURL(String value) { this.url = value; }
}