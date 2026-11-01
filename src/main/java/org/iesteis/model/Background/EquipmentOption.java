
package org.iesteis.model.background;

public class EquipmentOption {
    private String desc;
    private long choose;
    private String type;
    private EquipmentOptionFrom from;

    public String getDesc() { return desc; }
    public void setDesc(String value) { this.desc = value; }

    public long getChoose() { return choose; }
    public void setChoose(long value) { this.choose = value; }

    public String getType() { return type; }
    public void setType(String value) { this.type = value; }

    public EquipmentOptionFrom getFrom() { return from; }
    public void setFrom(EquipmentOptionFrom value) { this.from = value; }
}