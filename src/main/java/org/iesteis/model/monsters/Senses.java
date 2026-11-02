// Senses.java

package org.iesteis.model.monsters;


import com.fasterxml.jackson.annotation.JsonProperty;
public class Senses {
    @JsonProperty("darkvision")
    private Blindsight darkvision;
    @JsonProperty("passive_perception")
    private long passivePerception;
    @JsonProperty("blindsight")
    private Blindsight blindsight;
    @JsonProperty("tremorsense")
    private Blindsight tremorsense;
    @JsonProperty("truesight")
    private Blindsight truesight;
    public Senses() {}

    public Senses(Blindsight darkvision, long passivePerception, Blindsight blindsight, Blindsight tremorsense, Blindsight truesight) {
        this.darkvision = darkvision;
        this.passivePerception = passivePerception;
        this.blindsight = blindsight;
        this.tremorsense = tremorsense;
        this.truesight = truesight;
    }

    public Blindsight getDarkvision() { return darkvision; }
    public void setDarkvision(Blindsight value) { this.darkvision = value; }

    public long getPassivePerception() { return passivePerception; }
    public void setPassivePerception(long value) { this.passivePerception = value; }

    public Blindsight getBlindsight() { return blindsight; }
    public void setBlindsight(Blindsight value) { this.blindsight = value; }

    public Blindsight getTremorsense() { return tremorsense; }
    public void setTremorsense(Blindsight value) { this.tremorsense = value; }

    public Blindsight getTruesight() { return truesight; }
    public void setTruesight(Blindsight value) { this.truesight = value; }
}

