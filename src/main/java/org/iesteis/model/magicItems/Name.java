package org.iesteis.model.magicItems;


import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import java.io.IOException;

public enum Name {
    ARTIFACT, COMMON, LEGENDARY, RARE, RARE_1_VERY_RARE_2_OR_LEGENDARY_3, RARE_2, RARE_SILVER_OR_BRASS_VERY_RARE_BRONZE_OR_LEGENDARY_IRON, RARITY_VARIES, UNCOMMON, UNCOMMON_1, UNCOMMON_1_RARE_2_OR_VERY_RARE_3, VERY_RARE, VERY_RARE_3;

    @JsonValue

    public String toValue() {
        switch (this) {
            case ARTIFACT: return "Artifact";
            case COMMON: return "Common";
            case LEGENDARY: return "Legendary";
            case RARE: return "Rare";
            case RARE_1_VERY_RARE_2_OR_LEGENDARY_3: return "Rare (+1), Very Rare (+2), or Legendary (+3)";
            case RARE_2: return "Rare (+2)";
            case RARE_SILVER_OR_BRASS_VERY_RARE_BRONZE_OR_LEGENDARY_IRON: return "Rare (Silver or Brass), Very Rare (Bronze), or Legendary (Iron)";
            case RARITY_VARIES: return "Rarity Varies";
            case UNCOMMON: return "Uncommon";
            case UNCOMMON_1: return "Uncommon (+1)";
            case UNCOMMON_1_RARE_2_OR_VERY_RARE_3: return "Uncommon (+1), Rare (+2), or Very Rare (+3)";
            case VERY_RARE: return "Very Rare";
            case VERY_RARE_3: return "Very Rare (+3)";
        }
        return null;
    }

    @JsonCreator

    public static Name forValue(String value) throws IOException {
        if (value.equals("Artifact")) return ARTIFACT;
        if (value.equals("Common")) return COMMON;
        if (value.equals("Legendary")) return LEGENDARY;
        if (value.equals("Rare")) return RARE;
        if (value.equals("Rare (+1), Very Rare (+2), or Legendary (+3)")) return RARE_1_VERY_RARE_2_OR_LEGENDARY_3;
        if (value.equals("Rare (+2)")) return RARE_2;
        if (value.equals("Rare (Silver or Brass), Very Rare (Bronze), or Legendary (Iron)")) return RARE_SILVER_OR_BRASS_VERY_RARE_BRONZE_OR_LEGENDARY_IRON;
        if (value.equals("Rarity Varies")) return RARITY_VARIES;
        if (value.equals("Uncommon")) return UNCOMMON;
        if (value.equals("Uncommon (+1)")) return UNCOMMON_1;
        if (value.equals("Uncommon (+1), Rare (+2), or Very Rare (+3)")) return UNCOMMON_1_RARE_2_OR_VERY_RARE_3;
        if (value.equals("Very Rare")) return VERY_RARE;
        if (value.equals("Very Rare (+3)")) return VERY_RARE_3;
        throw new IOException("Cannot deserialize Name");
    }
}
