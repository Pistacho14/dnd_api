package org.iesteis.model.subspecies;


import com.fasterxml.jackson.annotation.JsonProperty;
/**
 * Referencia a la especie asociada a una subespecie o rasgo.
 */
public class Species {
    @JsonProperty("index")
    private String index;
    @JsonProperty("name")
    private String name;
    @JsonProperty("url")
    private String url;
    @JsonProperty("level")
    private Long level;
    public Species() {}

    public Species(String index, String name, String url, Long level) {
        this.index = index;
        this.name = name;
        this.url = url;
        this.level = level;
    }

    public String getIndex() { return index; }
    public void setIndex(String value) { this.index = value; }

    public String getName() { return name; }
    public void setName(String value) { this.name = value; }

    public String getUrl() { return url; }
    public void setUrl(String value) { this.url = value; }

    public Long getLevel() { return level; }
    public void setLevel(Long value) { this.level = value; }
}
