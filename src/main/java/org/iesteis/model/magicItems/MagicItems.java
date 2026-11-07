package org.iesteis.model.magicItems;


import com.fasterxml.jackson.annotation.JsonProperty;
/**
 * Modelo de un objeto mágico con categoría, rareza, sintonización y descripción.
 */
public class MagicItems {
    @JsonProperty("index")
    private String index;
    @JsonProperty("url")
    private String url;
    @JsonProperty("image")
    private String image;
    @JsonProperty("name")
    private String name;
    @JsonProperty("equipment_category")
    private EquipmentCategory equipmentCategory;
    @JsonProperty("variants")
    private EquipmentCategory[] variants;
    @JsonProperty("variant")
    private boolean variant;
    @JsonProperty("attunement")
    private boolean attunement;
    @JsonProperty("rarity")
    private Rarity rarity;
    @JsonProperty("desc")
    private String[] desc;
    @JsonProperty("limited-to")
    private String limitedTo;
    public MagicItems() {}

    public MagicItems(String index, String url, String image, String name, EquipmentCategory equipmentCategory, EquipmentCategory[] variants, boolean variant, boolean attunement, Rarity rarity, String[] desc, String limitedTo) {
        this.index = index;
        this.url = url;
        this.image = image;
        this.name = name;
        this.equipmentCategory = equipmentCategory;
        this.variants = variants;
        this.variant = variant;
        this.attunement = attunement;
        this.rarity = rarity;
        this.desc = desc;
        this.limitedTo = limitedTo;
    }

    public String getIndex() { return index; }
    public void setIndex(String value) { this.index = value; }

    public String getUrl() { return url; }
    public void setUrl(String value) { this.url = value; }

    public String getImage() { return image; }
    public void setImage(String value) { this.image = value; }

    public String getName() { return name; }
    public void setName(String value) { this.name = value; }

    public EquipmentCategory getEquipmentCategory() { return equipmentCategory; }
    public void setEquipmentCategory(EquipmentCategory value) { this.equipmentCategory = value; }

    public EquipmentCategory[] getVariants() { return variants; }
    public void setVariants(EquipmentCategory[] value) { this.variants = value; }

    public boolean getVariant() { return variant; }
    public void setVariant(boolean value) { this.variant = value; }

    public boolean getAttunement() { return attunement; }
    public void setAttunement(boolean value) { this.attunement = value; }

    public Rarity getRarity() { return rarity; }
    public void setRarity(Rarity value) { this.rarity = value; }

    public String[] getDesc() { return desc; }
    public void setDesc(String[] value) { this.desc = value; }

    public String getLimitedTo() { return limitedTo; }
    public void setLimitedTo(String value) { this.limitedTo = value; }
}
