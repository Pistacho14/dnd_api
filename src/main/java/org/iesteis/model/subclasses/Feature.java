package org.iesteis.model.subclasses;


import com.fasterxml.jackson.annotation.JsonProperty;
public class Feature {
    @JsonProperty("name")
    private String name;
    @JsonProperty("level")
    private long level;
    @JsonProperty("description")
    private String description;
    public Feature() {}

    public Feature(String name, long level, String description) {
        this.name = name;
        this.level = level;
        this.description = description;
    }

    public String getName() { return name; }
    public void setName(String value) { this.name = value; }

    public long getLevel() { return level; }
    public void setLevel(long value) { this.level = value; }

    public String getDescription() { return description; }
    public void setDescription(String value) { this.description = value; }
}
