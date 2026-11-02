// OptionElement.java

package org.iesteis.model.monsters;


import com.fasterxml.jackson.annotation.JsonProperty;
public class OptionElement {
    @JsonProperty("option_type")
    private ActionOptionType optionType;
    @JsonProperty("action_name")
    private String actionName;
    @JsonProperty("count")
    private String count;
    @JsonProperty("type")
    private PurpleType type;
    @JsonProperty("items")
    private OptionElement[] items;
    public OptionElement() {}

    public OptionElement(ActionOptionType optionType, String actionName, String count, PurpleType type, OptionElement[] items) {
        this.optionType = optionType;
        this.actionName = actionName;
        this.count = count;
        this.type = type;
        this.items = items;
    }

    public ActionOptionType getOptionType() { return optionType; }
    public void setOptionType(ActionOptionType value) { this.optionType = value; }

    public String getActionName() { return actionName; }
    public void setActionName(String value) { this.actionName = value; }

    public String getCount() { return count; }
    public void setCount(String value) { this.count = value; }

    public PurpleType getType() { return type; }
    public void setType(PurpleType value) { this.type = value; }

    public OptionElement[] getItems() { return items; }
    public void setItems(OptionElement[] value) { this.items = value; }
}

