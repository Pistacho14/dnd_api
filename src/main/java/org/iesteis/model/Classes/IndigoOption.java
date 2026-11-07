package org.iesteis.model.classes;

import com.fasterxml.jackson.annotation.JsonProperty;
/**
 * Alternativa de una elección de clase, incluida una posible elección anidada.
 */
public class IndigoOption {
    @JsonProperty("option_type")
    private PurpleOptionType optionType;
    @JsonProperty("choice")
    private OptionChoice choice;
    public IndigoOption() {}

    public IndigoOption(PurpleOptionType optionType, OptionChoice choice) {
        this.optionType = optionType;
        this.choice = choice;
    }

    public PurpleOptionType getOptionType() { return optionType; }
    public void setOptionType(PurpleOptionType value) { this.optionType = value; }

    public OptionChoice getChoice() { return choice; }
    public void setChoice(OptionChoice value) { this.choice = value; }
}