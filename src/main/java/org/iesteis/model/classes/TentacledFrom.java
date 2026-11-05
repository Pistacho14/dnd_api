package org.iesteis.model.classes;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TentacledFrom {
    @JsonProperty("option_set_type")
    private String optionSetType;
    @JsonProperty("equipment_category")
    private Proficiency equipmentCategory;
    public TentacledFrom() {}

    public TentacledFrom(String optionSetType, Proficiency equipmentCategory) {
        this.optionSetType = optionSetType;
        this.equipmentCategory = equipmentCategory;
    }

    public String getOptionSetType() { return optionSetType; }
    public void setOptionSetType(String value) { this.optionSetType = value; }

    public Proficiency getEquipmentCategory() { return equipmentCategory; }
    public void setEquipmentCategory(Proficiency value) { this.equipmentCategory = value; }
}