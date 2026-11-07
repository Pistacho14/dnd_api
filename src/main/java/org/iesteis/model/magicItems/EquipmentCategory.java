package org.iesteis.model.magicItems;


import com.fasterxml.jackson.annotation.JsonProperty;
/**
 * Referencia a la categoría de equipo de un objeto mágico.
 */
public class EquipmentCategory {
    @JsonProperty("index")
    private String index;
    @JsonProperty("name")
    private String name;
    @JsonProperty("url")
    private String url;
    public EquipmentCategory() {}

    public EquipmentCategory(String index, String name, String url) {
        this.index = index;
        this.name = name;
        this.url = url;
    }

    public String getIndex() { return index; }
    public void setIndex(String value) { this.index = value; }

    public String getName() { return name; }
    public void setName(String value) { this.name = value; }

    public String getUrl() { return url; }
    public void setUrl(String value) { this.url = value; }
}
