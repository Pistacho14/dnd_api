package org.iesteis.model.abilityScores;

import com.fasterxml.jackson.annotation.JsonProperty;
/**
 * Referencia a una habilidad vinculada a una característica.
 */
public class Skill {
    @JsonProperty("index")
    private String index;
    @JsonProperty("name")
    private String name;
    @JsonProperty("url")
    private String url;

    public Skill(String index, String name, String url) {
        this.index = index;
        this.name = name;
        this.url = url;
    }

    public Skill() {}
    public String getName() {
        return name;
    }

    public void setName(String value) {
        this.name = value;
    }

    public String getIndex() {
        return index;
    }

    public void setIndex(String value) {
        this.index = value;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String value) {
        this.url = value;
    }

    @Override
    public String toString() {
        return "Skill [index=" + index + "name=" + name + ", url=" + url + "]";
    }
}