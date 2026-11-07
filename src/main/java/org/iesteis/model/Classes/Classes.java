package org.iesteis.model.classes;

import com.fasterxml.jackson.annotation.JsonProperty;
/**
 * Modelo de una clase de personaje, con sus competencias, equipo, niveles y lanzamiento de conjuros.
 */
public class Classes {
    @JsonProperty("index")
    private String index;
    @JsonProperty("name")
    private String name;
    @JsonProperty("primary_ability")
    private PrimaryAbility primaryAbility;
    @JsonProperty("hit_die")
    private long hitDie;
    @JsonProperty("proficiency_choices")
    private ProficiencyChoice[] proficiencyChoices;
    @JsonProperty("proficiencies")
    private Proficiency[] proficiencies;
    @JsonProperty("saving_throws")
    private Proficiency[] savingThrows;
    @JsonProperty("starting_equipment_options")
    private StartingEquipmentOption[] startingEquipmentOptions;
    @JsonProperty("class_levels")
    private String classLevels;
    @JsonProperty("multi_classing")
    private MultiClassing multiClassing;
    @JsonProperty("subclasses")
    private Proficiency[] subclasses;
    @JsonProperty("url")
    private String url;
    @JsonProperty("spellcasting")
    private Spellcasting spellcasting;
    @JsonProperty("spells")
    private String spells;
    public Classes() {}

    public Classes(String index, String name, PrimaryAbility primaryAbility, long hitDie, ProficiencyChoice[] proficiencyChoices, Proficiency[] proficiencies, Proficiency[] savingThrows, StartingEquipmentOption[] startingEquipmentOptions, String classLevels, MultiClassing multiClassing, Proficiency[] subclasses, String url, Spellcasting spellcasting, String spells) {
        this.index = index;
        this.name = name;
        this.primaryAbility = primaryAbility;
        this.hitDie = hitDie;
        this.proficiencyChoices = proficiencyChoices;
        this.proficiencies = proficiencies;
        this.savingThrows = savingThrows;
        this.startingEquipmentOptions = startingEquipmentOptions;
        this.classLevels = classLevels;
        this.multiClassing = multiClassing;
        this.subclasses = subclasses;
        this.url = url;
        this.spellcasting = spellcasting;
        this.spells = spells;
    }

    public String getIndex() { return index; }
    public void setIndex(String value) { this.index = value; }

    public String getName() { return name; }
    public void setName(String value) { this.name = value; }

    public PrimaryAbility getPrimaryAbility() { return primaryAbility; }
    public void setPrimaryAbility(PrimaryAbility value) { this.primaryAbility = value; }

    public long getHitDie() { return hitDie; }
    public void setHitDie(long value) { this.hitDie = value; }

    public ProficiencyChoice[] getProficiencyChoices() { return proficiencyChoices; }
    public void setProficiencyChoices(ProficiencyChoice[] value) { this.proficiencyChoices = value; }

    public Proficiency[] getProficiencies() { return proficiencies; }
    public void setProficiencies(Proficiency[] value) { this.proficiencies = value; }

    public Proficiency[] getSavingThrows() { return savingThrows; }
    public void setSavingThrows(Proficiency[] value) { this.savingThrows = value; }

    public StartingEquipmentOption[] getStartingEquipmentOptions() { return startingEquipmentOptions; }
    public void setStartingEquipmentOptions(StartingEquipmentOption[] value) { this.startingEquipmentOptions = value; }

    public String getClassLevels() { return classLevels; }
    public void setClassLevels(String value) { this.classLevels = value; }

    public MultiClassing getMultiClassing() { return multiClassing; }
    public void setMultiClassing(MultiClassing value) { this.multiClassing = value; }

    public Proficiency[] getSubclasses() { return subclasses; }
    public void setSubclasses(Proficiency[] value) { this.subclasses = value; }

    public String getUrl() { return url; }
    public void setUrl(String value) { this.url = value; }

    public Spellcasting getSpellcasting() { return spellcasting; }
    public void setSpellcasting(Spellcasting value) { this.spellcasting = value; }

    public String getSpells() { return spells; }
    public void setSpells(String value) { this.spells = value; }
}