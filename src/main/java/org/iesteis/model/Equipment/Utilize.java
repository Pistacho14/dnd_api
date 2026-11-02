package org.iesteis.model.equipment;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Utilize {
    public Utilize(String name, Dc dc) {
        this.name = name;
        this.dc = dc;
    }

    public Utilize() {}

    @JsonProperty("name")
    private String name;
    @JsonProperty("dc")
    private Dc dc;

    public String getName() { return name; }
    public void setName(String value) { this.name = value; }

    public Dc getDc() { return dc; }
    public void setDc(Dc value) { this.dc = value; }
}