package org.iesteis.model.AbilityScore;

public class Skill {
    private String name;
    private String index;
    private String url;

    public Skill(String name, String index, String url) {
        this.name = name;
        this.index = index;
        this.url = url;
    }
    
    public String getName() { return name; }
    public void setName(String value) { this.name = value; }

    public String getIndex() { return index; }
    public void setIndex(String value) { this.index = value; }

    public String getURL() { return url; }
    public void setURL(String value) { this.url = value; }
}