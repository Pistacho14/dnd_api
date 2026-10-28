package org.iesteis.model.Classes;

public class Spellcasting {
    private long level;
    private Proficiency spellcastingAbility;
    private Info[] info;

    public long getLevel() { return level; }
    public void setLevel(long value) { this.level = value; }

    public Proficiency getSpellcastingAbility() { return spellcastingAbility; }
    public void setSpellcastingAbility(Proficiency value) { this.spellcastingAbility = value; }

    public Info[] getInfo() { return info; }
    public void setInfo(Info[] value) { this.info = value; }
}