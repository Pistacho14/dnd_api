package org.iesteis.model.species;


import com.fasterxml.jackson.annotation.JsonProperty;
/**
 * Referencia a un rasgo o subespecie asociado a una especie.
 */
public class Trait {
    @JsonProperty("index")
    private String index;
    @JsonProperty("url")
    private String url;
    @JsonProperty("name")
    private String name;
    public Trait() {}

    public Trait(String index, String url, String name) {
        this.index = index;
        this.url = url;
        this.name = name;
    }

    public String getIndex() { return index; }
    public void setIndex(String value) { this.index = value; }

    public String getUrl() { return url; }
    public void setUrl(String value) { this.url = value; }

    public String getName() { return name; }
    public void setName(String value) { this.name = value; }
}
