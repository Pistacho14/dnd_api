package org.iesteis.model.species;


import com.fasterxml.jackson.annotation.JsonProperty;
public class Species {
    @JsonProperty("index")
    private String index;
    @JsonProperty("url")
    private String url;
    @JsonProperty("name")
    private String name;
    @JsonProperty("type")
    private String type;
    @JsonProperty("size")
    private String size;
    @JsonProperty("speed")
    private long speed;
    @JsonProperty("subspecies")
    private Trait[] subspecies;
    @JsonProperty("traits")
    private Trait[] traits;
    @JsonProperty("size_options")
    private SizeOptions sizeOptions;
    public Species() {}

    public Species(String index, String url, String name, String type, String size, long speed, Trait[] subspecies, Trait[] traits, SizeOptions sizeOptions) {
        this.index = index;
        this.url = url;
        this.name = name;
        this.type = type;
        this.size = size;
        this.speed = speed;
        this.subspecies = subspecies;
        this.traits = traits;
        this.sizeOptions = sizeOptions;
    }

    public String getIndex() { return index; }
    public void setIndex(String value) { this.index = value; }

    public String getUrl() { return url; }
    public void setUrl(String value) { this.url = value; }

    public String getName() { return name; }
    public void setName(String value) { this.name = value; }

    public String getType() { return type; }
    public void setType(String value) { this.type = value; }

    public String getSize() { return size; }
    public void setSize(String value) { this.size = value; }

    public long getSpeed() { return speed; }
    public void setSpeed(long value) { this.speed = value; }

    public Trait[] getSubspecies() { return subspecies; }
    public void setSubspecies(Trait[] value) { this.subspecies = value; }

    public Trait[] getTraits() { return traits; }
    public void setTraits(Trait[] value) { this.traits = value; }

    public SizeOptions getSizeOptions() { return sizeOptions; }
    public void setSizeOptions(SizeOptions value) { this.sizeOptions = value; }
}
