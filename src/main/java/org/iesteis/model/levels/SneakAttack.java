package org.iesteis.model.levels;


import com.fasterxml.jackson.annotation.JsonProperty;
/**
 * Progresión del ataque furtivo expresada en cantidad y valor de dados.
 */
public class SneakAttack {
    @JsonProperty("dice_count")
    private long diceCount;
    @JsonProperty("dice_value")
    private long diceValue;
    public SneakAttack() {}

    public SneakAttack(long diceCount, long diceValue) {
        this.diceCount = diceCount;
        this.diceValue = diceValue;
    }

    public long getDiceCount() { return diceCount; }
    public void setDiceCount(long value) { this.diceCount = value; }

    public long getDiceValue() { return diceValue; }
    public void setDiceValue(long value) { this.diceValue = value; }
}
