package org.iesteis.model.skills;

import com.fasterxml.jackson.annotation.JsonProperty;
/**
 * Modelo de una habilidad con su descripción y característica asociada.
 */
public class Skills {
    @JsonProperty("index")
    private String index;
    @JsonProperty("name")
    private String name;
    @JsonProperty("description")
    private String description;
    @JsonProperty("ability_score")
    private AbilityScore abilityScore;
    @JsonProperty("url")
    private String url;

    public Skills(String index, String name, String description, AbilityScore abilityScore, String url) {
        this.index = index;
        this.name = name;
        this.description = description;
        this.abilityScore = abilityScore;
        this.url = url;
    }

    public Skills() {}
    public String getIndex() {
        return index;
    }

    public void setIndex(String value) {
        this.index = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String value) {
        this.name = value;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String value) {
        this.description = value;
    }

    public AbilityScore getAbilityScore() {
        return abilityScore;
    }

    public void setAbilityScore(AbilityScore value) {
        this.abilityScore = value;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String value) {
        this.url = value;
    }
}