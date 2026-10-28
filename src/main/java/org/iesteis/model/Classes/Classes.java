package org.iesteis.model.Classes;

public class Classes {
    private String index;
    private String name;
    private PrimaryAbility primaryAbility;
    private long hitDie;
    private ProficiencyChoice[] proficiencyChoices;
    private Proficiency[] proficiencies;
    private Proficiency[] savingThrows;
    private StartingEquipmentOption[] startingEquipmentOptions;
    private String classLevels;
    private MultiClassing multiClassing;
    private Proficiency[] subclasses;
    private String url;
    private Spellcasting spellcasting;
    private String spells;

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

    public String getURL() { return url; }
    public void setURL(String value) { this.url = value; }

    public Spellcasting getSpellcasting() { return spellcasting; }
    public void setSpellcasting(Spellcasting value) { this.spellcasting = value; }

    public String getSpells() { return spells; }
    public void setSpells(String value) { this.spells = value; }
}