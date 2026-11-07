package org.iesteis.model.levels;


import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Map;
/**
 * Datos de un nivel de clase, con rasgos, bonificaciones y progresión de conjuros.
 */
public class Levels {
    @JsonProperty("index")
    private String index;
    @JsonProperty("name")
    private String name;
    @JsonProperty("level")
    private long level;
    @JsonProperty("prof_bonus")
    private Long profBonus;
    @JsonProperty("features")
    private ClassClass[] features;
    @JsonProperty("class")
    private ClassClass levelClass;
    @JsonProperty("class_specific")
    private ClassSpecific classSpecific;
    @JsonProperty("url")
    private String url;
    @JsonProperty("subclass")
    private ClassClass subclass;
    @JsonProperty("spellcasting")
    private Map<String, Long> spellcasting;
    public Levels() {}

    public Levels(String index, String name, long level, Long profBonus, ClassClass[] features, ClassClass levelClass, ClassSpecific classSpecific, String url, ClassClass subclass, Map<String, Long> spellcasting) {
        this.index = index;
        this.name = name;
        this.level = level;
        this.profBonus = profBonus;
        this.features = features;
        this.levelClass = levelClass;
        this.classSpecific = classSpecific;
        this.url = url;
        this.subclass = subclass;
        this.spellcasting = spellcasting;
    }

    public String getIndex() { return index; }
    public void setIndex(String value) { this.index = value; }

    public String getName() { return name; }
    public void setName(String value) { this.name = value; }

    public long getLevel() { return level; }
    public void setLevel(long value) { this.level = value; }

    public Long getProfBonus() { return profBonus; }
    public void setProfBonus(Long value) { this.profBonus = value; }

    public ClassClass[] getFeatures() { return features; }
    public void setFeatures(ClassClass[] value) { this.features = value; }

    public ClassClass getLevelClass() { return levelClass; }
    public void setLevelClass(ClassClass value) { this.levelClass = value; }

    public ClassSpecific getClassSpecific() { return classSpecific; }
    public void setClassSpecific(ClassSpecific value) { this.classSpecific = value; }

    public String getUrl() { return url; }
    public void setUrl(String value) { this.url = value; }

    public ClassClass getSubclass() { return subclass; }
    public void setSubclass(ClassClass value) { this.subclass = value; }

    public Map<String, Long> getSpellcasting() { return spellcasting; }
    public void setSpellcasting(Map<String, Long> value) { this.spellcasting = value; }
}
