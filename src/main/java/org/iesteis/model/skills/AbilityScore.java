package org.iesteis.model.skills;

public class AbilityScore {
    private String index;
    private String name;
    private String url;

    public AbilityScore(String index, String name, String url) {
        this.index = index;
        this.name = name;
        this.url = url;
    }

    public AbilityScore() {
    }

    public String getIndex() {
        return index;
    }

    public void setIndex(String value) {
        this.index = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String value) {
        this.name = value;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String value) {
        this.url = value;
    }
}