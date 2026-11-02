package org.iesteis.model.proficiencies;


import com.fasterxml.jackson.annotation.JsonProperty;
public class Proficiencies {
    @JsonProperty("index")
    private String index;
    @JsonProperty("type")
    private Type type;
    @JsonProperty("name")
    private String name;
    @JsonProperty("classes")
    private Reference[] classes;
    @JsonProperty("backgrounds")
    private Reference[] backgrounds;
    @JsonProperty("url")
    private String url;
    @JsonProperty("reference")
    private Reference reference;
    public Proficiencies() {}

    public Proficiencies(String index, Type type, String name, Reference[] classes, Reference[] backgrounds, String url, Reference reference) {
        this.index = index;
        this.type = type;
        this.name = name;
        this.classes = classes;
        this.backgrounds = backgrounds;
        this.url = url;
        this.reference = reference;
    }

    public String getIndex() { return index; }
    public void setIndex(String value) { this.index = value; }

    public Type getType() { return type; }
    public void setType(Type value) { this.type = value; }

    public String getName() { return name; }
    public void setName(String value) { this.name = value; }

    public Reference[] getClasses() { return classes; }
    public void setClasses(Reference[] value) { this.classes = value; }

    public Reference[] getBackgrounds() { return backgrounds; }
    public void setBackgrounds(Reference[] value) { this.backgrounds = value; }

    public String getUrl() { return url; }
    public void setUrl(String value) { this.url = value; }

    public Reference getReference() { return reference; }
    public void setReference(Reference value) { this.reference = value; }
}
