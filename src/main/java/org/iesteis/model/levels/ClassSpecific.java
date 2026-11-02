package org.iesteis.model.levels;


import com.fasterxml.jackson.annotation.JsonProperty;
public class ClassSpecific {
    @JsonProperty("rage_count")
    private Long rageCount;
    @JsonProperty("rage_damage_bonus")
    private Long rageDamageBonus;
    @JsonProperty("weapon_mastery")
    private Long weaponMastery;
    @JsonProperty("bardic_inspiration_die")
    private Long bardicInspirationDie;
    @JsonProperty("channel_divinity_charges")
    private Long channelDivinityCharges;
    @JsonProperty("wild_shape_uses")
    private Long wildShapeUses;
    @JsonProperty("second_wind_uses")
    private Long secondWindUses;
    @JsonProperty("martial_arts_die")
    private Long martialArtsDie;
    @JsonProperty("focus_points")
    private Long focusPoints;
    @JsonProperty("unarmored_movement_bonus")
    private Long unarmoredMovementBonus;
    @JsonProperty("favored_enemies")
    private Long favoredEnemies;
    @JsonProperty("sneak_attack")
    private SneakAttack sneakAttack;
    @JsonProperty("sorcery_points")
    private Long sorceryPoints;
    @JsonProperty("eldritch_invocations")
    private Long eldritchInvocations;
    public ClassSpecific() {}

    public ClassSpecific(Long rageCount, Long rageDamageBonus, Long weaponMastery, Long bardicInspirationDie, Long channelDivinityCharges, Long wildShapeUses, Long secondWindUses, Long martialArtsDie, Long focusPoints, Long unarmoredMovementBonus, Long favoredEnemies, SneakAttack sneakAttack, Long sorceryPoints, Long eldritchInvocations) {
        this.rageCount = rageCount;
        this.rageDamageBonus = rageDamageBonus;
        this.weaponMastery = weaponMastery;
        this.bardicInspirationDie = bardicInspirationDie;
        this.channelDivinityCharges = channelDivinityCharges;
        this.wildShapeUses = wildShapeUses;
        this.secondWindUses = secondWindUses;
        this.martialArtsDie = martialArtsDie;
        this.focusPoints = focusPoints;
        this.unarmoredMovementBonus = unarmoredMovementBonus;
        this.favoredEnemies = favoredEnemies;
        this.sneakAttack = sneakAttack;
        this.sorceryPoints = sorceryPoints;
        this.eldritchInvocations = eldritchInvocations;
    }

    public Long getRageCount() { return rageCount; }
    public void setRageCount(Long value) { this.rageCount = value; }

    public Long getRageDamageBonus() { return rageDamageBonus; }
    public void setRageDamageBonus(Long value) { this.rageDamageBonus = value; }

    public Long getWeaponMastery() { return weaponMastery; }
    public void setWeaponMastery(Long value) { this.weaponMastery = value; }

    public Long getBardicInspirationDie() { return bardicInspirationDie; }
    public void setBardicInspirationDie(Long value) { this.bardicInspirationDie = value; }

    public Long getChannelDivinityCharges() { return channelDivinityCharges; }
    public void setChannelDivinityCharges(Long value) { this.channelDivinityCharges = value; }

    public Long getWildShapeUses() { return wildShapeUses; }
    public void setWildShapeUses(Long value) { this.wildShapeUses = value; }

    public Long getSecondWindUses() { return secondWindUses; }
    public void setSecondWindUses(Long value) { this.secondWindUses = value; }

    public Long getMartialArtsDie() { return martialArtsDie; }
    public void setMartialArtsDie(Long value) { this.martialArtsDie = value; }

    public Long getFocusPoints() { return focusPoints; }
    public void setFocusPoints(Long value) { this.focusPoints = value; }

    public Long getUnarmoredMovementBonus() { return unarmoredMovementBonus; }
    public void setUnarmoredMovementBonus(Long value) { this.unarmoredMovementBonus = value; }

    public Long getFavoredEnemies() { return favoredEnemies; }
    public void setFavoredEnemies(Long value) { this.favoredEnemies = value; }

    public SneakAttack getSneakAttack() { return sneakAttack; }
    public void setSneakAttack(SneakAttack value) { this.sneakAttack = value; }

    public Long getSorceryPoints() { return sorceryPoints; }
    public void setSorceryPoints(Long value) { this.sorceryPoints = value; }

    public Long getEldritchInvocations() { return eldritchInvocations; }
    public void setEldritchInvocations(Long value) { this.eldritchInvocations = value; }
}
