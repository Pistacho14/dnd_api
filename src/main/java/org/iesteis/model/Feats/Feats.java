package org.iesteis.model.feats;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Feats {
    @JsonProperty("index")
    private String index;
    @JsonProperty("name")
    private String name;
    @JsonProperty("description")
    private String description;
    @JsonProperty("type")
    private String type;
    @JsonProperty("repeatable")
    private String repeatable;
    @JsonProperty("prerequisites")
    private Object prerequisites;
    @JsonProperty("prerequisite_options")
    private Object prerequisiteOptions;
    @JsonProperty("url")
    private String url;

    public Feats(String index, String name, String description, String type, String repeatable, Object prerequisites,
            Object prerequisiteOptions, String url) {
        this.index = index;
        this.name = name;
        this.description = description;
        this.type = type;
        this.repeatable = repeatable;
        this.prerequisites = prerequisites;
        this.prerequisiteOptions = prerequisiteOptions;
        this.url = url;
    }

    public Feats() {}
    public String getIndex() { return index; }
    public void setIndex(String value) { this.index = value; }

    public String getName() { return name; }
    public void setName(String value) { this.name = value; }

    public String getDescription() { return description; }
    public void setDescription(String value) { this.description = value; }

    public String getType() { return type; }
    public void setType(String value) { this.type = value; }

    public String getRepeatable() { return repeatable; }
    public void setRepeatable(String value) { this.repeatable = value; }

    public Object getPrerequisites() { return prerequisites; }
    public void setPrerequisites(Object value) { this.prerequisites = value; }

    public Object getPrerequisiteOptions() { return prerequisiteOptions; }
    public void setPrerequisiteOptions(Object value) { this.prerequisiteOptions = value; }

    public String getUrl() { return url; }
    public void setUrl(String value) { this.url = value; }

}