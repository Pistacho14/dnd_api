package org.iesteis.model.poisons;


import com.fasterxml.jackson.annotation.JsonProperty;
public class Poisons {
    @JsonProperty("index")
    private String index;
    @JsonProperty("name")
    private String name;
    @JsonProperty("url")
    private String url;
    @JsonProperty("cost")
    private long cost;
    @JsonProperty("type")
    private String type;
    @JsonProperty("description")
    private String description;
    public Poisons() {}

    public Poisons(String index, String name, String url, long cost, String type, String description) {
        this.index = index;
        this.name = name;
        this.url = url;
        this.cost = cost;
        this.type = type;
        this.description = description;
    }

    public String getIndex() { return index; }
    public void setIndex(String value) { this.index = value; }

    public String getName() { return name; }
    public void setName(String value) { this.name = value; }

    public String getUrl() { return url; }
    public void setUrl(String value) { this.url = value; }

    public long getCost() { return cost; }
    public void setCost(long value) { this.cost = value; }

    public String getType() { return type; }
    public void setType(String value) { this.type = value; }

    public String getDescription() { return description; }
    public void setDescription(String value) { this.description = value; }
}
