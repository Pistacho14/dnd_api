package org.iesteis.model.magicSchools;


import com.fasterxml.jackson.annotation.JsonProperty;
/**
 * Modelo de una escuela de magia con su nombre y descripción.
 */
public class MagicSchools {
    @JsonProperty("index")
    private String index;
    @JsonProperty("name")
    private String name;
    @JsonProperty("description")
    private String description;
    @JsonProperty("url")
    private String url;
    public MagicSchools() {}

    public MagicSchools(String index, String name, String description, String url) {
        this.index = index;
        this.name = name;
        this.description = description;
        this.url = url;
    }

    public String getIndex() { return index; }
    public void setIndex(String value) { this.index = value; }

    public String getName() { return name; }
    public void setName(String value) { this.name = value; }

    public String getDescription() { return description; }
    public void setDescription(String value) { this.description = value; }

    public String getUrl() { return url; }
    public void setUrl(String value) { this.url = value; }
}
