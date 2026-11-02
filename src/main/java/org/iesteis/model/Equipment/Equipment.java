package org.iesteis.model.equipment;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Equipment {
    @JsonProperty("index")
    private String index;
    @JsonProperty("name")
    private String name;
    @JsonProperty("equipment_categories")
    private Ability[] equipmentCategories;
    @JsonProperty("cost")
    private Cost cost;
    @JsonProperty("weight")
    private Double weight;
    @JsonProperty("description")
    private String[] description;
    @JsonProperty("url")
    private String url;
    @JsonProperty("ability")
    private Ability ability;
    @JsonProperty("craft")
    private Ability[] craft;
    @JsonProperty("utilize")
    private Utilize[] utilize;
    @JsonProperty("quantity")
    private Long quantity;
    @JsonProperty("storage")
    private Ability storage;
    @JsonProperty("image")
    private String image;
    @JsonProperty("damage")
    private Damage damage;
    @JsonProperty("range")
    private Range range;
    @JsonProperty("properties")
    private Ability[] properties;
    @JsonProperty("mastery")
    private Ability mastery;
    @JsonProperty("two_handed_damage")
    private Damage twoHandedDamage;
    @JsonProperty("ammunition")
    private Ability ammunition;
    @JsonProperty("armor_class")
    private ArmorClass armorClass;
    @JsonProperty("don_time")
    private Time donTime;
    @JsonProperty("doff_time")
    private Time doffTime;
    @JsonProperty("stealth_disadvantage")
    private Boolean stealthDisadvantage;
    @JsonProperty("str_minimum")
    private Long strMinimum;
    @JsonProperty("contents")
    private Content[] contents;
    @JsonProperty("throw_range")
    private Range throwRange;
    @JsonProperty("notes")
    private String[] notes;
    public Equipment() {}

    public Equipment(String index, String name, Ability[] equipmentCategories, Cost cost, Double weight, String[] description, String url, Ability ability, Ability[] craft, Utilize[] utilize, Long quantity, Ability storage, String image, Damage damage, Range range, Ability[] properties, Ability mastery, Damage twoHandedDamage, Ability ammunition, ArmorClass armorClass, Time donTime, Time doffTime, Boolean stealthDisadvantage, Long strMinimum, Content[] contents, Range throwRange, String[] notes) {
        this.index = index;
        this.name = name;
        this.equipmentCategories = equipmentCategories;
        this.cost = cost;
        this.weight = weight;
        this.description = description;
        this.url = url;
        this.ability = ability;
        this.craft = craft;
        this.utilize = utilize;
        this.quantity = quantity;
        this.storage = storage;
        this.image = image;
        this.damage = damage;
        this.range = range;
        this.properties = properties;
        this.mastery = mastery;
        this.twoHandedDamage = twoHandedDamage;
        this.ammunition = ammunition;
        this.armorClass = armorClass;
        this.donTime = donTime;
        this.doffTime = doffTime;
        this.stealthDisadvantage = stealthDisadvantage;
        this.strMinimum = strMinimum;
        this.contents = contents;
        this.throwRange = throwRange;
        this.notes = notes;
    }

    public String getIndex() { return index; }
    public void setIndex(String value) { this.index = value; }

    public String getName() { return name; }
    public void setName(String value) { this.name = value; }

    public Ability[] getEquipmentCategories() { return equipmentCategories; }
    public void setEquipmentCategories(Ability[] value) { this.equipmentCategories = value; }

    public Cost getCost() { return cost; }
    public void setCost(Cost value) { this.cost = value; }

    public Double getWeight() { return weight; }
    public void setWeight(Double value) { this.weight = value; }

    public String[] getDescription() { return description; }
    public void setDescription(String[] value) { this.description = value; }

    public String getUrl() { return url; }
    public void setUrl(String value) { this.url = value; }

    public Ability getAbility() { return ability; }
    public void setAbility(Ability value) { this.ability = value; }

    public Ability[] getCraft() { return craft; }
    public void setCraft(Ability[] value) { this.craft = value; }

    public Utilize[] getUtilize() { return utilize; }
    public void setUtilize(Utilize[] value) { this.utilize = value; }

    public Long getQuantity() { return quantity; }
    public void setQuantity(Long value) { this.quantity = value; }

    public Ability getStorage() { return storage; }
    public void setStorage(Ability value) { this.storage = value; }

    public String getImage() { return image; }
    public void setImage(String value) { this.image = value; }

    public Damage getDamage() { return damage; }
    public void setDamage(Damage value) { this.damage = value; }

    public Range getRange() { return range; }
    public void setRange(Range value) { this.range = value; }

    public Ability[] getProperties() { return properties; }
    public void setProperties(Ability[] value) { this.properties = value; }

    public Ability getMastery() { return mastery; }
    public void setMastery(Ability value) { this.mastery = value; }

    public Damage getTwoHandedDamage() { return twoHandedDamage; }
    public void setTwoHandedDamage(Damage value) { this.twoHandedDamage = value; }

    public Ability getAmmunition() { return ammunition; }
    public void setAmmunition(Ability value) { this.ammunition = value; }

    public ArmorClass getArmorClass() { return armorClass; }
    public void setArmorClass(ArmorClass value) { this.armorClass = value; }

    public Time getDonTime() { return donTime; }
    public void setDonTime(Time value) { this.donTime = value; }

    public Time getDoffTime() { return doffTime; }
    public void setDoffTime(Time value) { this.doffTime = value; }

    public Boolean getStealthDisadvantage() { return stealthDisadvantage; }
    public void setStealthDisadvantage(Boolean value) { this.stealthDisadvantage = value; }

    public Long getStrMinimum() { return strMinimum; }
    public void setStrMinimum(Long value) { this.strMinimum = value; }

    public Content[] getContents() { return contents; }
    public void setContents(Content[] value) { this.contents = value; }

    public Range getThrowRange() { return throwRange; }
    public void setThrowRange(Range value) { this.throwRange = value; }

    public String[] getNotes() { return notes; }
    public void setNotes(String[] value) { this.notes = value; }
}