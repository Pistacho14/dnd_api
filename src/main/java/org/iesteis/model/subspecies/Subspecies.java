package org.iesteis.model.subspecies;


import com.fasterxml.jackson.annotation.JsonProperty;
public class Subspecies {
    @JsonProperty("index")
    private String index;
    @JsonProperty("url")
    private String url;
    @JsonProperty("name")
    private String name;
    @JsonProperty("damage_type")
    private Species damageType;
    @JsonProperty("species")
    private Species species;
    @JsonProperty("traits")
    private Species[] traits;
    public Subspecies() {}

    public Subspecies(String index, String url, String name, Species damageType, Species species, Species[] traits) {
        this.index = index;
        this.url = url;
        this.name = name;
        this.damageType = damageType;
        this.species = species;
        this.traits = traits;
    }

    public String getIndex() { return index; }
    public void setIndex(String value) { this.index = value; }

    public String getUrl() { return url; }
    public void setUrl(String value) { this.url = value; }

    public String getName() { return name; }
    public void setName(String value) { this.name = value; }

    public Species getDamageType() { return damageType; }
    public void setDamageType(Species value) { this.damageType = value; }

    public Species getSpecies() { return species; }
    public void setSpecies(Species value) { this.species = value; }

    public Species[] getTraits() { return traits; }
    public void setTraits(Species[] value) { this.traits = value; }
}
