package org.iesteis.model.spells;


import com.fasterxml.jackson.annotation.JsonProperty;
/**
 * Modelo de un conjuro con nivel, escuela, alcance, componentes y duración.
 */
public class Spells {
    @JsonProperty("index")
    private String index;
    @JsonProperty("url")
    private String url;
    @JsonProperty("name")
    private String name;
    @JsonProperty("level")
    private long level;
    @JsonProperty("school")
    private School school;
    @JsonProperty("classes")
    private School[] classes;
    @JsonProperty("casting_time")
    private String castingTime;
    @JsonProperty("ritual")
    private boolean ritual;
    @JsonProperty("range")
    private String range;
    @JsonProperty("components")
    private Component[] components;
    @JsonProperty("material")
    private String material;
    @JsonProperty("duration")
    private String duration;
    @JsonProperty("concentration")
    private boolean concentration;
    @JsonProperty("attack_type")
    private AttackType attackType;
    @JsonProperty("damage")
    private Damage damage;
    @JsonProperty("description")
    private String description;
    @JsonProperty("higher_level")
    private String higherLevel;
    public Spells() {}

    public Spells(String index, String url, String name, long level, School school, School[] classes, String castingTime, boolean ritual, String range, Component[] components, String material, String duration, boolean concentration, AttackType attackType, Damage damage, String description, String higherLevel) {
        this.index = index;
        this.url = url;
        this.name = name;
        this.level = level;
        this.school = school;
        this.classes = classes;
        this.castingTime = castingTime;
        this.ritual = ritual;
        this.range = range;
        this.components = components;
        this.material = material;
        this.duration = duration;
        this.concentration = concentration;
        this.attackType = attackType;
        this.damage = damage;
        this.description = description;
        this.higherLevel = higherLevel;
    }

    public String getIndex() { return index; }
    public void setIndex(String value) { this.index = value; }

    public String getUrl() { return url; }
    public void setUrl(String value) { this.url = value; }

    public String getName() { return name; }
    public void setName(String value) { this.name = value; }

    public long getLevel() { return level; }
    public void setLevel(long value) { this.level = value; }

    public School getSchool() { return school; }
    public void setSchool(School value) { this.school = value; }

    public School[] getClasses() { return classes; }
    public void setClasses(School[] value) { this.classes = value; }

    public String getCastingTime() { return castingTime; }
    public void setCastingTime(String value) { this.castingTime = value; }

    public boolean getRitual() { return ritual; }
    public void setRitual(boolean value) { this.ritual = value; }

    public String getRange() { return range; }
    public void setRange(String value) { this.range = value; }

    public Component[] getComponents() { return components; }
    public void setComponents(Component[] value) { this.components = value; }

    public String getMaterial() { return material; }
    public void setMaterial(String value) { this.material = value; }

    public String getDuration() { return duration; }
    public void setDuration(String value) { this.duration = value; }

    public boolean getConcentration() { return concentration; }
    public void setConcentration(boolean value) { this.concentration = value; }

    public AttackType getAttackType() { return attackType; }
    public void setAttackType(AttackType value) { this.attackType = value; }

    public Damage getDamage() { return damage; }
    public void setDamage(Damage value) { this.damage = value; }

    public String getDescription() { return description; }
    public void setDescription(String value) { this.description = value; }

    public String getHigherLevel() { return higherLevel; }
    public void setHigherLevel(String value) { this.higherLevel = value; }
}

