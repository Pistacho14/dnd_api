package org.iesteis.model.background;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Feat {
    @JsonProperty("index")
    private String index;
    @JsonProperty("name")
    private String name;
    @JsonProperty("url")
    private String url;
    @JsonProperty("note")
    private String note;
    public Feat() {}

    public Feat(String index, String name, String url, String note) {
        this.index = index;
        this.name = name;
        this.url = url;
        this.note = note;
    }

    public String getIndex() { return index; }
    public void setIndex(String value) { this.index = value; }

    public String getName() { return name; }
    public void setName(String value) { this.name = value; }

    public String getUrl() { return url; }
    public void setUrl(String value) { this.url = value; }

    public String getNote() { return note; }
    public void setNote(String value) { this.note = value; }
}