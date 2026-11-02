package org.iesteis.model.features;


import com.fasterxml.jackson.annotation.JsonProperty;
public class Features {
    @JsonProperty("index")
    private String index;
    @JsonProperty("url")
    private String url;
    @JsonProperty("name")
    private String name;
    @JsonProperty("class")
    private ClassClass featureClass;
    @JsonProperty("level")
    private ClassClass level;
    @JsonProperty("description")
    private String description;
    @JsonProperty("subclass")
    private ClassClass subclass;
    public Features() {}

    public Features(String index, String url, String name, ClassClass featureClass, ClassClass level, String description, ClassClass subclass) {
        this.index = index;
        this.url = url;
        this.name = name;
        this.featureClass = featureClass;
        this.level = level;
        this.description = description;
        this.subclass = subclass;
    }

    public String getIndex() { return index; }
    public void setIndex(String value) { this.index = value; }

    public String getUrl() { return url; }
    public void setUrl(String value) { this.url = value; }

    public String getName() { return name; }
    public void setName(String value) { this.name = value; }

    public ClassClass getFeatureClass() { return featureClass; }
    public void setFeatureClass(ClassClass value) { this.featureClass = value; }

    public ClassClass getLevel() { return level; }
    public void setLevel(ClassClass value) { this.level = value; }

    public String getDescription() { return description; }
    public void setDescription(String value) { this.description = value; }

    public ClassClass getSubclass() { return subclass; }
    public void setSubclass(ClassClass value) { this.subclass = value; }
}
