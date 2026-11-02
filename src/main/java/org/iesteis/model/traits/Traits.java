package org.iesteis.model.traits;


import com.fasterxml.jackson.annotation.JsonProperty;
public class Traits {
    @JsonProperty("index")
    private String index;
    @JsonProperty("url")
    private String url;
    @JsonProperty("name")
    private String name;
    @JsonProperty("description")
    private String description;
    @JsonProperty("species")
    private Species[] species;
    @JsonProperty("subspecies")
    private Species[] subspecies;
    @JsonProperty("spells")
    private Spell[] spells;
    @JsonProperty("proficiency_choices")
    private ProficiencyChoices proficiencyChoices;
    @JsonProperty("speed")
    private Long speed;
    public Traits() {}

    public Traits(String index, String url, String name, String description, Species[] species, Species[] subspecies, Spell[] spells, ProficiencyChoices proficiencyChoices, Long speed) {
        this.index = index;
        this.url = url;
        this.name = name;
        this.description = description;
        this.species = species;
        this.subspecies = subspecies;
        this.spells = spells;
        this.proficiencyChoices = proficiencyChoices;
        this.speed = speed;
    }

    public String getIndex() { return index; }
    public void setIndex(String value) { this.index = value; }

    public String getUrl() { return url; }
    public void setUrl(String value) { this.url = value; }

    public String getName() { return name; }
    public void setName(String value) { this.name = value; }

    public String getDescription() { return description; }
    public void setDescription(String value) { this.description = value; }

    public Species[] getSpecies() { return species; }
    public void setSpecies(Species[] value) { this.species = value; }

    public Species[] getSubspecies() { return subspecies; }
    public void setSubspecies(Species[] value) { this.subspecies = value; }

    public Spell[] getSpells() { return spells; }
    public void setSpells(Spell[] value) { this.spells = value; }

    public ProficiencyChoices getProficiencyChoices() { return proficiencyChoices; }
    public void setProficiencyChoices(ProficiencyChoices value) { this.proficiencyChoices = value; }

    public Long getSpeed() { return speed; }
    public void setSpeed(Long value) { this.speed = value; }
}
