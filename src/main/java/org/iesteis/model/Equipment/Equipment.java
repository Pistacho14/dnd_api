package org.iesteis.model.equipment;

public class Equipment {
    private String index;
    private String name;
    private Ability[] equipmentCategories;
    private Cost cost;
    private Double weight;
    private String description;
    private String url;
    private Ability ability;
    private Ability[] craft;
    private Utilize[] utilize;
    private Long quantity;
    private Ability storage;
    private String image;
    private Damage damage;
    private Range range;
    private Ability[] properties;
    private Ability mastery;
    private Damage twoHandedDamage;
    private Ability ammunition;
    private ArmorClass armorClass;
    private Time donTime;
    private Time doffTime;
    private Boolean stealthDisadvantage;
    private Long strMinimum;
    private Content[] contents;
    private Range throwRange;
    private String[] notes;

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

    public String getDescription() { return description; }
    public void setDescription(String value) { this.description = value; }

    public String getURL() { return url; }
    public void setURL(String value) { this.url = value; }

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