package org.iesteis.model.background;

import com.fasterxml.jackson.annotation.JsonProperty;
/**
 * Modelo de un trasfondo y de las elecciones y competencias que concede.
 */
public class Background {
    @JsonProperty("index")
    private String index;
    @JsonProperty("name")
    private String name;
    @JsonProperty("ability_scores")
    private Feat[] abilityScores;
    @JsonProperty("feat")
    private Feat feat;
    @JsonProperty("proficiencies")
    private Feat[] proficiencies;
    @JsonProperty("equipment_options")
    private EquipmentOption[] equipmentOptions;
    @JsonProperty("url")
    private String url;
    @JsonProperty("proficiency_choices")
    private ProficiencyChoice[] proficiencyChoices;
    public Background() {}

    public Background(String index, String name, Feat[] abilityScores, Feat feat, Feat[] proficiencies, EquipmentOption[] equipmentOptions, String url, ProficiencyChoice[] proficiencyChoices) {
        this.index = index;
        this.name = name;
        this.abilityScores = abilityScores;
        this.feat = feat;
        this.proficiencies = proficiencies;
        this.equipmentOptions = equipmentOptions;
        this.url = url;
        this.proficiencyChoices = proficiencyChoices;
    }

    public String getIndex() { return index; }
    public void setIndex(String value) { this.index = value; }

    public String getName() { return name; }
    public void setName(String value) { this.name = value; }

    public Feat[] getAbilityScores() { return abilityScores; }
    public void setAbilityScores(Feat[] value) { this.abilityScores = value; }

    public Feat getFeat() { return feat; }
    public void setFeat(Feat value) { this.feat = value; }

    public Feat[] getProficiencies() { return proficiencies; }
    public void setProficiencies(Feat[] value) { this.proficiencies = value; }

    public EquipmentOption[] getEquipmentOptions() { return equipmentOptions; }
    public void setEquipmentOptions(EquipmentOption[] value) { this.equipmentOptions = value; }

    public String getUrl() { return url; }
    public void setUrl(String value) { this.url = value; }

    public ProficiencyChoice[] getProficiencyChoices() { return proficiencyChoices; }
    public void setProficiencyChoices(ProficiencyChoice[] value) { this.proficiencyChoices = value; }
}