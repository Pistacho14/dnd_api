package org.iesteis.model.alignments;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Alignments {
    @JsonProperty("index")
    private String index;
    @JsonProperty("name")
    private String name;
    @JsonProperty("abbreviation")
    private String abbreviation;
    @JsonProperty("description")
    private String description;
    @JsonProperty("url")
    private String url;
    public Alignments() {}

    public Alignments(String index, String name, String abbreviation, String description, String url) {
        this.index = index;
        this.name = name;
        this.abbreviation = abbreviation;
        this.description = description;
        this.url = url;
    }

    public String getIndex() { return index; }
    public void setIndex(String value) { this.index = value; }

    public String getName() { return name; }
    public void setName(String value) { this.name = value; }

    public String getAbbreviation() { return abbreviation; }
    public void setAbbreviation(String value) { this.abbreviation = value; }

    public String getDescription() { return description; }
    public void setDescription(String value) { this.description = value; }

    public String getUrl() { return url; }
    public void setUrl(String value) { this.url = value; }
}