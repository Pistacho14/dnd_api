package org.iesteis.model.equipmentCategories;

import com.fasterxml.jackson.annotation.JsonProperty;
/**
 * Categoría de equipo con las referencias a los objetos incluidos.
 */
public class EquipmentCategories {
    @JsonProperty("index")
    private String index;
    @JsonProperty("name")
    private String name;
    @JsonProperty("equipment")
    private EquipmentCategories[] equipment;
    @JsonProperty("url")
    private String url;
    public EquipmentCategories() {}

    public EquipmentCategories(String index, String name, EquipmentCategories[] equipment, String url) {
        this.index = index;
        this.name = name;
        this.equipment = equipment;
        this.url = url;
    }

    public String getIndex() { return index; }
    public void setIndex(String value) { this.index = value; }

    public String getName() { return name; }
    public void setName(String value) { this.name = value; }

    public EquipmentCategories[] getEquipment() { return equipment; }
    public void setEquipment(EquipmentCategories[] value) { this.equipment = value; }

    public String getUrl() { return url; }
    public void setUrl(String value) { this.url = value; }
}
