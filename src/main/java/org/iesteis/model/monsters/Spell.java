// Spell.java

package org.iesteis.model.monsters;


import com.fasterxml.jackson.annotation.JsonProperty;
/**
 * Referencia a un conjuro de monstruo y sus notas de uso.
 */
public class Spell {
    @JsonProperty("index")
    private String index;
    @JsonProperty("name")
    private String name;
    @JsonProperty("level")
    private long level;
    @JsonProperty("url")
    private String url;
    @JsonProperty("usage")
    private SpellUsage usage;
    @JsonProperty("notes")
    private String notes;
    public Spell() {}

    public Spell(String index, String name, long level, String url, SpellUsage usage, String notes) {
        this.index = index;
        this.name = name;
        this.level = level;
        this.url = url;
        this.usage = usage;
        this.notes = notes;
    }

    public String getIndex() { return index; }
    public void setIndex(String value) { this.index = value; }

    public String getName() { return name; }
    public void setName(String value) { this.name = value; }

    public long getLevel() { return level; }
    public void setLevel(long value) { this.level = value; }

    public String getUrl() { return url; }
    public void setUrl(String value) { this.url = value; }

    public SpellUsage getUsage() { return usage; }
    public void setUsage(SpellUsage value) { this.usage = value; }

    public String getNotes() { return notes; }
    public void setNotes(String value) { this.notes = value; }
}

