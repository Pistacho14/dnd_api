package org.iesteis.model.EquipmentCategories;

public class EquipmentCategories {
    private String index;
    private String name;
    private EquipmentCategories[] equipment;
    private String url;

    public String getIndex() { return index; }
    public void setIndex(String value) { this.index = value; }

    public String getName() { return name; }
    public void setName(String value) { this.name = value; }

    public EquipmentCategories[] getEquipment() { return equipment; }
    public void setEquipment(EquipmentCategories[] value) { this.equipment = value; }

    public String getURL() { return url; }
    public void setURL(String value) { this.url = value; }
}
