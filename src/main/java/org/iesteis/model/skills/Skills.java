package org.iesteis.model.skills;

public class Skills {
    private String index;
    private String name;
    private String description;
    private AbilityScore abilityScore;
    private String url;

    public String getIndex() { return index; }
    public void setIndex(String value) { this.index = value; }

    public String getName() { return name; }
    public void setName(String value) { this.name = value; }

    public String getDescription() { return description; }
    public void setDescription(String value) { this.description = value; }

    public AbilityScore getAbilityScore() { return abilityScore; }
    public void setAbilityScore(AbilityScore value) { this.abilityScore = value; }

    public String getURL() { return url; }
    public void setURL(String value) { this.url = value; }
}