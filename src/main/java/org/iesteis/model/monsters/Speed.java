// Speed.java

package org.iesteis.model.monsters;


import com.fasterxml.jackson.annotation.JsonProperty;
public class Speed {
    @JsonProperty("walk")
    private Walk walk;
    @JsonProperty("swim")
    private Walk swim;
    @JsonProperty("fly")
    private Walk fly;
    @JsonProperty("hover")
    private Boolean hover;
    @JsonProperty("burrow")
    private Walk burrow;
    @JsonProperty("climb")
    private Walk climb;
    public Speed() {}

    public Speed(Walk walk, Walk swim, Walk fly, Boolean hover, Walk burrow, Walk climb) {
        this.walk = walk;
        this.swim = swim;
        this.fly = fly;
        this.hover = hover;
        this.burrow = burrow;
        this.climb = climb;
    }

    public Walk getWalk() { return walk; }
    public void setWalk(Walk value) { this.walk = value; }

    public Walk getSwim() { return swim; }
    public void setSwim(Walk value) { this.swim = value; }

    public Walk getFly() { return fly; }
    public void setFly(Walk value) { this.fly = value; }

    public Boolean getHover() { return hover; }
    public void setHover(Boolean value) { this.hover = value; }

    public Walk getBurrow() { return burrow; }
    public void setBurrow(Walk value) { this.burrow = value; }

    public Walk getClimb() { return climb; }
    public void setClimb(Walk value) { this.climb = value; }
}

