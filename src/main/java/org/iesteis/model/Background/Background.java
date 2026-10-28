package org.iesteis.model.Background;

public class Background {
    private String index;
    private String name;
    private Feat[] abilityScores;
    private Feat feat;
    private Feat[] proficiencies;
    private EquipmentOption[] equipmentOptions;
    private String url;
    private ProficiencyChoice[] proficiencyChoices;

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

    public String getURL() { return url; }
    public void setURL(String value) { this.url = value; }

    public ProficiencyChoice[] getProficiencyChoices() { return proficiencyChoices; }
    public void setProficiencyChoices(ProficiencyChoice[] value) { this.proficiencyChoices = value; }
}