package org.iesteis.model.subclasses;


import com.fasterxml.jackson.annotation.JsonProperty;
public class Subclasses {
    @JsonProperty("index")
    private String index;
    @JsonProperty("url")
    private String url;
    @JsonProperty("name")
    private String name;
    @JsonProperty("class")
    private ClassClass subclassClass;
    @JsonProperty("summary")
    private String summary;
    @JsonProperty("description")
    private String description;
    @JsonProperty("features")
    private Feature[] features;
    public Subclasses() {}

    public Subclasses(String index, String url, String name, ClassClass subclassClass, String summary, String description, Feature[] features) {
        this.index = index;
        this.url = url;
        this.name = name;
        this.subclassClass = subclassClass;
        this.summary = summary;
        this.description = description;
        this.features = features;
    }

    public String getIndex() { return index; }
    public void setIndex(String value) { this.index = value; }

    public String getUrl() { return url; }
    public void setUrl(String value) { this.url = value; }

    public String getName() { return name; }
    public void setName(String value) { this.name = value; }

    public ClassClass getSubclassClass() { return subclassClass; }
    public void setSubclassClass(ClassClass value) { this.subclassClass = value; }

    public String getSummary() { return summary; }
    public void setSummary(String value) { this.summary = value; }

    public String getDescription() { return description; }
    public void setDescription(String value) { this.description = value; }

    public Feature[] getFeatures() { return features; }
    public void setFeatures(Feature[] value) { this.features = value; }
}
