package org.iesteis.model.languages;


import com.fasterxml.jackson.annotation.JsonProperty;
public class Languages {
    @JsonProperty("index")
    private String index;
    @JsonProperty("name")
    private String name;
    @JsonProperty("is_rare")
    private boolean isRare;
    @JsonProperty("note")
    private String note;
    @JsonProperty("url")
    private String url;
    public Languages() {}

    public Languages(String index, String name, boolean isRare, String note, String url) {
        this.index = index;
        this.name = name;
        this.isRare = isRare;
        this.note = note;
        this.url = url;
    }

    public String getIndex() { return index; }
    public void setIndex(String value) { this.index = value; }

    public String getName() { return name; }
    public void setName(String value) { this.name = value; }

    public boolean getIsRare() { return isRare; }
    public void setIsRare(boolean value) { this.isRare = value; }

    public String getNote() { return note; }
    public void setNote(String value) { this.note = value; }

    public String getUrl() { return url; }
    public void setUrl(String value) { this.url = value; }
}
