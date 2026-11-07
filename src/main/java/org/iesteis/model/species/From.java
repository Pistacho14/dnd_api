package org.iesteis.model.species;


import com.fasterxml.jackson.annotation.JsonProperty;
/**
 * Conjunto de alternativas de tamaño para una especie.
 */
public class From {
    @JsonProperty("option_set_type")
    private String optionSetType;
    @JsonProperty("options")
    private Option[] options;
    public From() {}

    public From(String optionSetType, Option[] options) {
        this.optionSetType = optionSetType;
        this.options = options;
    }

    public String getOptionSetType() { return optionSetType; }
    public void setOptionSetType(String value) { this.optionSetType = value; }

    public Option[] getOptions() { return options; }
    public void setOptions(Option[] value) { this.options = value; }
}
