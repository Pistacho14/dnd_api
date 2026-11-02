// Monster.java

package org.iesteis.model.monsters;


import com.fasterxml.jackson.annotation.JsonProperty;
public class Monster {
    @JsonProperty("name")
    private String name;
    @JsonProperty("size")
    private Size size;
    @JsonProperty("type")
    private MonsterType type;
    @JsonProperty("alignment")
    private Alignment alignment;
    @JsonProperty("armor_class")
    private ArmorClass[] armorClass;
    @JsonProperty("hit_points")
    private long hitPoints;
    @JsonProperty("hit_dice")
    private String hitDice;
    @JsonProperty("speed")
    private Speed speed;
    @JsonProperty("strength")
    private long strength;
    @JsonProperty("dexterity")
    private long dexterity;
    @JsonProperty("constitution")
    private long constitution;
    @JsonProperty("intelligence")
    private long intelligence;
    @JsonProperty("wisdom")
    private long wisdom;
    @JsonProperty("charisma")
    private long charisma;
    @JsonProperty("damage_resistances")
    private DamageImmunityElement[] damageResistances;
    @JsonProperty("damage_vulnerabilities")
    private String[] damageVulnerabilities;
    @JsonProperty("damage_immunities")
    private DamageImmunityElement[] damageImmunities;
    @JsonProperty("condition_immunities")
    private ConditionImmunity[] conditionImmunities;
    @JsonProperty("senses")
    private Senses senses;
    @JsonProperty("languages")
    private String languages;
    @JsonProperty("challenge_rating")
    private double challengeRating;
    @JsonProperty("special_abilities")
    private SpecialAbility[] specialAbilities;
    @JsonProperty("actions")
    private MonsterAction[] actions;
    @JsonProperty("legendary_actions")
    private LegendaryAction[] legendaryActions;
    @JsonProperty("index")
    private String index;
    @JsonProperty("url")
    private String url;
    @JsonProperty("image")
    private String image;
    @JsonProperty("hit_points_roll")
    private String hitPointsRoll;
    @JsonProperty("proficiencies")
    private Proficiency[] proficiencies;
    @JsonProperty("proficiency_bonus")
    private long proficiencyBonus;
    @JsonProperty("xp")
    private long xp;
    @JsonProperty("xp_in_lair")
    private Long xpInLair;
    @JsonProperty("bonus_actions")
    private BonusAction[] bonusActions;
    @JsonProperty("gear")
    private String gear;
    @JsonProperty("reactions")
    private Reaction[] reactions;
    @JsonProperty("forms")
    private ConditionImmunity[] forms;
    public Monster() {}

    public Monster(String name, Size size, MonsterType type, Alignment alignment, ArmorClass[] armorClass, long hitPoints, String hitDice, Speed speed, long strength, long dexterity, long constitution, long intelligence, long wisdom, long charisma, DamageImmunityElement[] damageResistances, String[] damageVulnerabilities, DamageImmunityElement[] damageImmunities, ConditionImmunity[] conditionImmunities, Senses senses, String languages, double challengeRating, SpecialAbility[] specialAbilities, MonsterAction[] actions, LegendaryAction[] legendaryActions, String index, String url, String image, String hitPointsRoll, Proficiency[] proficiencies, long proficiencyBonus, long xp, Long xpInLair, BonusAction[] bonusActions, String gear, Reaction[] reactions, ConditionImmunity[] forms) {
        this.name = name;
        this.size = size;
        this.type = type;
        this.alignment = alignment;
        this.armorClass = armorClass;
        this.hitPoints = hitPoints;
        this.hitDice = hitDice;
        this.speed = speed;
        this.strength = strength;
        this.dexterity = dexterity;
        this.constitution = constitution;
        this.intelligence = intelligence;
        this.wisdom = wisdom;
        this.charisma = charisma;
        this.damageResistances = damageResistances;
        this.damageVulnerabilities = damageVulnerabilities;
        this.damageImmunities = damageImmunities;
        this.conditionImmunities = conditionImmunities;
        this.senses = senses;
        this.languages = languages;
        this.challengeRating = challengeRating;
        this.specialAbilities = specialAbilities;
        this.actions = actions;
        this.legendaryActions = legendaryActions;
        this.index = index;
        this.url = url;
        this.image = image;
        this.hitPointsRoll = hitPointsRoll;
        this.proficiencies = proficiencies;
        this.proficiencyBonus = proficiencyBonus;
        this.xp = xp;
        this.xpInLair = xpInLair;
        this.bonusActions = bonusActions;
        this.gear = gear;
        this.reactions = reactions;
        this.forms = forms;
    }

    public String getName() { return name; }
    public void setName(String value) { this.name = value; }

    public Size getSize() { return size; }
    public void setSize(Size value) { this.size = value; }

    public MonsterType getType() { return type; }
    public void setType(MonsterType value) { this.type = value; }

    public Alignment getAlignment() { return alignment; }
    public void setAlignment(Alignment value) { this.alignment = value; }

    public ArmorClass[] getArmorClass() { return armorClass; }
    public void setArmorClass(ArmorClass[] value) { this.armorClass = value; }

    public long getHitPoints() { return hitPoints; }
    public void setHitPoints(long value) { this.hitPoints = value; }

    public String getHitDice() { return hitDice; }
    public void setHitDice(String value) { this.hitDice = value; }

    public Speed getSpeed() { return speed; }
    public void setSpeed(Speed value) { this.speed = value; }

    public long getStrength() { return strength; }
    public void setStrength(long value) { this.strength = value; }

    public long getDexterity() { return dexterity; }
    public void setDexterity(long value) { this.dexterity = value; }

    public long getConstitution() { return constitution; }
    public void setConstitution(long value) { this.constitution = value; }

    public long getIntelligence() { return intelligence; }
    public void setIntelligence(long value) { this.intelligence = value; }

    public long getWisdom() { return wisdom; }
    public void setWisdom(long value) { this.wisdom = value; }

    public long getCharisma() { return charisma; }
    public void setCharisma(long value) { this.charisma = value; }

    public DamageImmunityElement[] getDamageResistances() { return damageResistances; }
    public void setDamageResistances(DamageImmunityElement[] value) { this.damageResistances = value; }

    public String[] getDamageVulnerabilities() { return damageVulnerabilities; }
    public void setDamageVulnerabilities(String[] value) { this.damageVulnerabilities = value; }

    public DamageImmunityElement[] getDamageImmunities() { return damageImmunities; }
    public void setDamageImmunities(DamageImmunityElement[] value) { this.damageImmunities = value; }

    public ConditionImmunity[] getConditionImmunities() { return conditionImmunities; }
    public void setConditionImmunities(ConditionImmunity[] value) { this.conditionImmunities = value; }

    public Senses getSenses() { return senses; }
    public void setSenses(Senses value) { this.senses = value; }

    public String getLanguages() { return languages; }
    public void setLanguages(String value) { this.languages = value; }

    public double getChallengeRating() { return challengeRating; }
    public void setChallengeRating(double value) { this.challengeRating = value; }

    public SpecialAbility[] getSpecialAbilities() { return specialAbilities; }
    public void setSpecialAbilities(SpecialAbility[] value) { this.specialAbilities = value; }

    public MonsterAction[] getActions() { return actions; }
    public void setActions(MonsterAction[] value) { this.actions = value; }

    public LegendaryAction[] getLegendaryActions() { return legendaryActions; }
    public void setLegendaryActions(LegendaryAction[] value) { this.legendaryActions = value; }

    public String getIndex() { return index; }
    public void setIndex(String value) { this.index = value; }

    public String getUrl() { return url; }
    public void setUrl(String value) { this.url = value; }

    public String getImage() { return image; }
    public void setImage(String value) { this.image = value; }

    public String getHitPointsRoll() { return hitPointsRoll; }
    public void setHitPointsRoll(String value) { this.hitPointsRoll = value; }

    public Proficiency[] getProficiencies() { return proficiencies; }
    public void setProficiencies(Proficiency[] value) { this.proficiencies = value; }

    public long getProficiencyBonus() { return proficiencyBonus; }
    public void setProficiencyBonus(long value) { this.proficiencyBonus = value; }

    public long getXP() { return xp; }
    public void setXP(long value) { this.xp = value; }

    public Long getXPInLair() { return xpInLair; }
    public void setXPInLair(Long value) { this.xpInLair = value; }

    public BonusAction[] getBonusActions() { return bonusActions; }
    public void setBonusActions(BonusAction[] value) { this.bonusActions = value; }

    public String getGear() { return gear; }
    public void setGear(String value) { this.gear = value; }

    public Reaction[] getReactions() { return reactions; }
    public void setReactions(Reaction[] value) { this.reactions = value; }

    public ConditionImmunity[] getForms() { return forms; }
    public void setForms(ConditionImmunity[] value) { this.forms = value; }
}
