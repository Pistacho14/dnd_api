package org.iesteis.model.classes;

import com.fasterxml.jackson.annotation.JsonProperty;
/**
 * Bloque informativo de lanzamiento de conjuros con título y descripción.
 */
public class Info {
    @JsonProperty("name")
    private Name name;
    @JsonProperty("desc")
    private String[] desc;
    public Info() {}

    public Info(Name name, String[] desc) {
        this.name = name;
        this.desc = desc;
    }

    public Name getName() { return name; }
    public void setName(Name value) { this.name = value; }

    public String[] getDesc() { return desc; }
    public void setDesc(String[] value) { this.desc = value; }
}