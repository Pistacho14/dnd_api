package org.iesteis.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Response {
    public Response(String abilityScores, String alignments, String backgrounds, String classes, String conditions, String damageTypes, String equipment, String equipmentCategories, String feats, String features, String languages, String magicItems, String magicSchools, String monsters, String poisons, String proficiencies, String skills, String species, String spells, String subclasses, String subspecies, String traits, String weaponMasteryProperties, String weaponProperties) {
        this.abilityScores = abilityScores;
        this.alignments = alignments;
        this.backgrounds = backgrounds;
        this.classes = classes;
        this.conditions = conditions;
        this.damageTypes = damageTypes;
        this.equipment = equipment;
        this.equipmentCategories = equipmentCategories;
        this.feats = feats;
        this.features = features;
        this.languages = languages;
        this.magicItems = magicItems;
        this.magicSchools = magicSchools;
        this.monsters = monsters;
        this.poisons = poisons;
        this.proficiencies = proficiencies;
        this.skills = skills;
        this.species = species;
        this.spells = spells;
        this.subclasses = subclasses;
        this.subspecies = subspecies;
        this.traits = traits;
        this.weaponMasteryProperties = weaponMasteryProperties;
        this.weaponProperties = weaponProperties;
    }

    public Response() {}

    @JsonProperty("ability-scores")
    private String abilityScores;
    @JsonProperty("alignments")
    private String alignments;
    @JsonProperty("backgrounds")
    private String backgrounds;
    @JsonProperty("classes")
    private String classes;
    @JsonProperty("conditions")
    private String conditions;
    @JsonProperty("damage-types")
    private String damageTypes;
    @JsonProperty("equipment")
    private String equipment;
    @JsonProperty("equipment-categories")
    private String equipmentCategories;
    @JsonProperty("feats")
    private String feats;
    @JsonProperty("features")
    private String features;
    @JsonProperty("languages")
    private String languages;
    @JsonProperty("magic-items")
    private String magicItems;
    @JsonProperty("magic-schools")
    private String magicSchools;
    @JsonProperty("monsters")
    private String monsters;
    @JsonProperty("poisons")
    private String poisons;
    @JsonProperty("proficiencies")
    private String proficiencies;
    @JsonProperty("skills")
    private String skills;
    @JsonProperty("species")
    private String species;
    @JsonProperty("spells")
    private String spells;
    @JsonProperty("subclasses")
    private String subclasses;
    @JsonProperty("subspecies")
    private String subspecies;
    @JsonProperty("traits")
    private String traits;
    @JsonProperty("weapon-mastery-properties")
    private String weaponMasteryProperties;
    @JsonProperty("weapon-properties")
    private String weaponProperties;

    public String getAbilityScores() { return abilityScores; }
    public void setAbilityScores(String value) { this.abilityScores = value; }

    public String getAlignments() { return alignments; }
    public void setAlignments(String value) { this.alignments = value; }

    public String getBackgrounds() { return backgrounds; }
    public void setBackgrounds(String value) { this.backgrounds = value; }

    public String getClasses() { return classes; }
    public void setClasses(String value) { this.classes = value; }

    public String getConditions() { return conditions; }
    public void setConditions(String value) { this.conditions = value; }

    public String getDamageTypes() { return damageTypes; }
    public void setDamageTypes(String value) { this.damageTypes = value; }

    public String getEquipment() { return equipment; }
    public void setEquipment(String value) { this.equipment = value; }

    public String getEquipmentCategories() { return equipmentCategories; }
    public void setEquipmentCategories(String value) { this.equipmentCategories = value; }

    public String getFeats() { return feats; }
    public void setFeats(String value) { this.feats = value; }

    public String getFeatures() { return features; }
    public void setFeatures(String value) { this.features = value; }

    public String getLanguages() { return languages; }
    public void setLanguages(String value) { this.languages = value; }

    public String getMagicItems() { return magicItems; }
    public void setMagicItems(String value) { this.magicItems = value; }

    public String getMagicSchools() { return magicSchools; }
    public void setMagicSchools(String value) { this.magicSchools = value; }

    public String getMonsters() { return monsters; }
    public void setMonsters(String value) { this.monsters = value; }

    public String getPoisons() { return poisons; }
    public void setPoisons(String value) { this.poisons = value; }

    public String getProficiencies() { return proficiencies; }
    public void setProficiencies(String value) { this.proficiencies = value; }

    public String getSkills() { return skills; }
    public void setSkills(String value) { this.skills = value; }

    public String getSpecies() { return species; }
    public void setSpecies(String value) { this.species = value; }

    public String getSpells() { return spells; }
    public void setSpells(String value) { this.spells = value; }

    public String getSubclasses() { return subclasses; }
    public void setSubclasses(String value) { this.subclasses = value; }

    public String getSubspecies() { return subspecies; }
    public void setSubspecies(String value) { this.subspecies = value; }

    public String getTraits() { return traits; }
    public void setTraits(String value) { this.traits = value; }

    public String getWeaponMasteryProperties() { return weaponMasteryProperties; }
    public void setWeaponMasteryProperties(String value) { this.weaponMasteryProperties = value; }

    public String getWeaponProperties() { return weaponProperties; }
    public void setWeaponProperties(String value) { this.weaponProperties = value; }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Response{");
        sb.append("abilityScores=").append(abilityScores);
        sb.append(", alignments=").append(alignments);
        sb.append(", backgrounds=").append(backgrounds);
        sb.append(", classes=").append(classes);
        sb.append(", conditions=").append(conditions);
        sb.append(", damageTypes=").append(damageTypes);
        sb.append(", equipment=").append(equipment);
        sb.append(", equipmentCategories=").append(equipmentCategories);
        sb.append(", feats=").append(feats);
        sb.append(", features=").append(features);
        sb.append(", languages=").append(languages);
        sb.append(", magicItems=").append(magicItems);
        sb.append(", magicSchools=").append(magicSchools);
        sb.append(", monsters=").append(monsters);
        sb.append(", poisons=").append(poisons);
        sb.append(", proficiencies=").append(proficiencies);
        sb.append(", skills=").append(skills);
        sb.append(", species=").append(species);
        sb.append(", spells=").append(spells);
        sb.append(", subclasses=").append(subclasses);
        sb.append(", subspecies=").append(subspecies);
        sb.append(", traits=").append(traits);
        sb.append(", weaponMasteryProperties=").append(weaponMasteryProperties);
        sb.append(", weaponProperties=").append(weaponProperties);
        sb.append('}');
        return sb.toString();
    }
}
