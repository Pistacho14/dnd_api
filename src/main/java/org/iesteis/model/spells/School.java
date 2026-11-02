package org.iesteis.model.spells;


import com.fasterxml.jackson.annotation.JsonProperty;
public class School {
    @JsonProperty("index")
    private Index index;
    @JsonProperty("name")
    private Name name;
    @JsonProperty("url")
    private URL url;
    public School() {}

    public School(Index index, Name name, URL url) {
        this.index = index;
        this.name = name;
        this.url = url;
    }

    public Index getIndex() { return index; }
    public void setIndex(Index value) { this.index = value; }

    public Name getName() { return name; }
    public void setName(Name value) { this.name = value; }

    public URL getUrl() { return url; }
    public void setUrl(URL value) { this.url = value; }
}

