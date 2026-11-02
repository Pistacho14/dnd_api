package org.iesteis.model.species;


import com.fasterxml.jackson.annotation.JsonProperty;
public class Option {
    @JsonProperty("option_type")
    private String optionType;
    @JsonProperty("size")
    private String size;
    public Option() {}

    public Option(String optionType, String size) {
        this.optionType = optionType;
        this.size = size;
    }

    public String getOptionType() { return optionType; }
    public void setOptionType(String value) { this.optionType = value; }

    public String getSize() { return size; }
    public void setSize(String value) { this.size = value; }
}
