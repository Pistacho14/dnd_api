package org.iesteis.model.background;

import com.fasterxml.jackson.annotation.JsonProperty;
/**
 * Origen de una elección de equipo, identificado por su categoría.
 */
public class ChoiceFrom {
    @JsonProperty("option_set_type")
    private String optionSetType;
    @JsonProperty("equipment_category")
    private Feat equipmentCategory;
    public ChoiceFrom() {}

    public ChoiceFrom(String optionSetType, Feat equipmentCategory) {
        this.optionSetType = optionSetType;
        this.equipmentCategory = equipmentCategory;
    }

    public String getOptionSetType() { return optionSetType; }
    public void setOptionSetType(String value) { this.optionSetType = value; }

    public Feat getEquipmentCategory() { return equipmentCategory; }
    public void setEquipmentCategory(Feat value) { this.equipmentCategory = value; }
}