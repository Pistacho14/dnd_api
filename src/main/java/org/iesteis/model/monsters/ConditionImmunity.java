// ConditionImmunity.java

package org.iesteis.model.monsters;


import com.fasterxml.jackson.annotation.JsonProperty;
public class ConditionImmunity {
    @JsonProperty("index")
    private String index;
    @JsonProperty("name")
    private String name;
    @JsonProperty("url")
    private String url;
    @JsonProperty("note")
    private String note;
    @JsonProperty("level")
    private Long level;
    public ConditionImmunity() {}

    public ConditionImmunity(String index, String name, String url, String note, Long level) {
        this.index = index;
        this.name = name;
        this.url = url;
        this.note = note;
        this.level = level;
    }

    public String getIndex() { return index; }
    public void setIndex(String value) { this.index = value; }

    public String getName() { return name; }
    public void setName(String value) { this.name = value; }

    public String getUrl() { return url; }
    public void setUrl(String value) { this.url = value; }

    public String getNote() { return note; }
    public void setNote(String value) { this.note = value; }

    public Long getLevel() { return level; }
    public void setLevel(Long value) { this.level = value; }
}

