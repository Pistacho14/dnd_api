package org.iesteis.model.classes;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Info {
    public Info(Name name, String[] desc) {
        this.name = name;
        this.desc = desc;
    }

    public Info() {}

    @JsonProperty("name")
    private Name name;
    @JsonProperty("desc")
    private String[] desc;

    public Name getName() { return name; }
    public void setName(Name value) { this.name = value; }

    public String[] getDesc() { return desc; }
    public void setDesc(String[] value) { this.desc = value; }
}