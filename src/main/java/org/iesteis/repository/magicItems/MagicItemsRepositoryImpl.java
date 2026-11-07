package org.iesteis.repository.magicItems;


import org.iesteis.model.magicItems.EquipmentCategory;
import org.iesteis.model.magicItems.Rarity;
import java.util.List;
import java.util.Map;

import org.iesteis.database.DatabaseManager;
import org.iesteis.model.magicItems.MagicItems;
import org.iesteis.repository.BaseRepository;
import tools.jackson.databind.ObjectMapper;

/**
 * Persiste y reconstruye objetos mágicos en la tabla {@code magic_items}.
 */
public class MagicItemsRepositoryImpl extends BaseRepository<MagicItems> implements MagicItemsRepository {

    private static final ObjectMapper JSON_MAPPER = new ObjectMapper();

    public MagicItemsRepositoryImpl() { super(); }
    public MagicItemsRepositoryImpl(DatabaseManager db) { super(db); }

    @Override protected String tableName() { return "magic_items"; }

    @Override
    public MagicItems save(MagicItems item) {
        int result = db.insert(
                "INSERT INTO magic_items (`index`, `name`, `url`, `image`, `equipment_category`, `variant`, `variants`, `attunement`, `rarity`, `desc`, `limited-to`) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)",
                item.getIndex(), item.getName(), item.getUrl(), item.getImage(), json(item.getEquipmentCategory()), item.getVariant(), json(item.getVariants()), item.getAttunement(), json(item.getRarity()), json(item.getDesc()), item.getLimitedTo());
        return result <= 0 ? null : copy(item);
    }

    @Override
    protected MagicItems updateItem(String index, MagicItems item) {
        int result = db.update(
                "UPDATE magic_items SET `index` = ?, `name` = ?, `url` = ?, `image` = ?, `equipment_category` = ?, `variant` = ?, `variants` = ?, `attunement` = ?, `rarity` = ?, `desc` = ?, `limited-to` = ? WHERE `index` = ?",
                item.getIndex(), item.getName(), item.getUrl(), item.getImage(), json(item.getEquipmentCategory()), item.getVariant(), json(item.getVariants()), item.getAttunement(), json(item.getRarity()), json(item.getDesc()), item.getLimitedTo(), index);
        return result <= 0 ? null : copy(item);
    }

    @Override public List<MagicItems> findByName(String value) {
        return findMany("SELECT * FROM magic_items WHERE LOWER(name) LIKE LOWER(?)", "%" + value + "%");
    }
    @Override public List<MagicItems> findByIndex(String value) {
        return findMany("SELECT * FROM magic_items WHERE `index` = ?", value);
    }
    @Override public List<MagicItems> findByUrl(String value) {
        return findMany("SELECT * FROM magic_items WHERE url = ?", value);
    }

    private String json(Object value) {
        return value == null ? null : JSON_MAPPER.writeValueAsString(value);
    }

    private <V> V read(Object value, Class<V> type) {
        if (value == null) return null;
        if (!(value instanceof String)) {
            throw new IllegalStateException("Los campos JSON de magic_items deben recibirse como texto");
        }
        return JSON_MAPPER.readValue((String) value, type);
    }

    private Long number(Object value) {
        return value == null ? null : ((Number) value).longValue();
    }

    private <E extends Enum<E>> E enumValue(Object value, Class<E> type) {
        if (value == null) return null;
        String enumName = ((String) value).toUpperCase(java.util.Locale.ROOT).replaceAll("[^A-Z0-9]+", "_");
        return Enum.valueOf(type, enumName);
    }

    @Override
    protected MagicItems toModel(Map<String, Object> entity) {
        return new MagicItems(
                (String) entity.get("index"),
                (String) entity.get("url"),
                (String) entity.get("image"),
                (String) entity.get("name"),
                read(entity.get("equipment_category"), EquipmentCategory.class),
                read(entity.get("variants"), EquipmentCategory[].class),
                (Boolean) entity.get("variant"),
                (Boolean) entity.get("attunement"),
                read(entity.get("rarity"), Rarity.class),
                read(entity.get("desc"), String[].class),
                (String) entity.get("limited-to")
        );
    }

    @Override
    protected MagicItems copy(MagicItems source) {
        return new MagicItems(
                source.getIndex(),
                source.getUrl(),
                source.getImage(),
                source.getName(),
                source.getEquipmentCategory(),
                source.getVariants(),
                source.getVariant(),
                source.getAttunement(),
                source.getRarity(),
                source.getDesc(),
                source.getLimitedTo()
        );
    }
}
