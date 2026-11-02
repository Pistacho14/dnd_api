-- Tabla de puntuaciones de caracteristica (Ability Scores).
CREATE TABLE IF NOT EXISTS ability_scores (
    `index` VARCHAR(100) NOT NULL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    full_name VARCHAR(255) NOT NULL,
    description TEXT NOT NULL,
    url VARCHAR(255) NOT NULL
);

-- Tabla de alineamientos (Alignments).
CREATE TABLE IF NOT EXISTS alignments (
    `index` VARCHAR(100) NOT NULL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    abbreviation VARCHAR(20) NOT NULL,
    description TEXT NOT NULL,
    url VARCHAR(255) NOT NULL
);

-- Tabla de trasfondos (Backgrounds).
CREATE TABLE IF NOT EXISTS backgrounds (
    `index` VARCHAR(100) NOT NULL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    feat_index VARCHAR(100) NOT NULL,
    feat_note TEXT,
    proficiency_choices JSON,
    equipment_options JSON,
    url VARCHAR(255) NOT NULL
);

-- Tabla de clases (Classes).
CREATE TABLE IF NOT EXISTS classes (
    `index` VARCHAR(100) NOT NULL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    primary_ability JSON NOT NULL,
    hit_die INT NOT NULL,
    class_levels VARCHAR(255) NOT NULL,
    multi_classing JSON,
    proficiency_choices JSON NOT NULL,
    starting_equipment_options JSON NOT NULL,
    spellcasting JSON,
    spells VARCHAR(255),
    url VARCHAR(255) NOT NULL
);

-- Tabla de estados y condiciones (Conditions).
CREATE TABLE IF NOT EXISTS conditions (
    `index` VARCHAR(100) NOT NULL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    description TEXT NOT NULL,
    url VARCHAR(255) NOT NULL
);

-- Tabla de tipos de daño (Damage Types).
CREATE TABLE IF NOT EXISTS damage_types (
    `index` VARCHAR(100) NOT NULL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    description TEXT NOT NULL,
    url VARCHAR(255) NOT NULL
);

-- Tabla de categorias de equipo (Equipment Categories).
CREATE TABLE IF NOT EXISTS equipment_categories (
    `index` VARCHAR(100) NOT NULL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    equipment JSON NOT NULL,
    url VARCHAR(255) NOT NULL
);

-- Tabla de equipo (Equipment).
CREATE TABLE IF NOT EXISTS equipment (
    `index` VARCHAR(100) NOT NULL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    cost JSON NOT NULL,
    url VARCHAR(255) NOT NULL,
    description TEXT,
    weight DECIMAL(10, 2),
    ammunition_index VARCHAR(100),
    armor_class JSON,
    contents JSON,
    ability_score_index VARCHAR(100),
    craft JSON,
    damage JSON,
    doff_time VARCHAR(100),
    don_time VARCHAR(100),
    image VARCHAR(500),
    mastery_index VARCHAR(100),
    notes JSON,
    quantity INT,
    storage JSON,
    `range` JSON,
    stealth_disadvantage BOOLEAN,
    str_minimum INT,
    throw_range JSON,
    two_handed_damage JSON,
    utilize JSON
);

-- Tabla de dotes (Feats).
CREATE TABLE IF NOT EXISTS feats (
    `index` VARCHAR(100) NOT NULL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    description TEXT NOT NULL,
    type VARCHAR(100) NOT NULL,
    repeatable VARCHAR(100),
    prerequisites JSON,
    prerequisite_options JSON,
    url VARCHAR(255) NOT NULL
);

-- Tabla de rasgos de clase y subclase (Features).
CREATE TABLE IF NOT EXISTS features (
    `index` VARCHAR(100) NOT NULL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    description TEXT NOT NULL,
    level_index VARCHAR(100) NOT NULL,
    class_index VARCHAR(100) NOT NULL,
    subclass_index VARCHAR(100),
    url VARCHAR(255) NOT NULL
);

-- Tabla de idiomas (Languages).
CREATE TABLE IF NOT EXISTS languages (
    `index` VARCHAR(100) NOT NULL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    is_rare BOOLEAN NOT NULL,
    note TEXT NOT NULL,
    url VARCHAR(255) NOT NULL
);

-- Tabla de niveles de clase y subclase (Levels).
CREATE TABLE IF NOT EXISTS levels (
    `index` VARCHAR(100) NOT NULL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    level INT NOT NULL,
    prof_bonus INT,
    class_index VARCHAR(100) NOT NULL,
    subclass_index VARCHAR(100),
    class_specific JSON,
    spellcasting JSON,
    url VARCHAR(255) NOT NULL
);

-- Tabla de objetos magicos (Magic Items).
CREATE TABLE IF NOT EXISTS magic_items (
    `index` VARCHAR(100) NOT NULL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    url VARCHAR(255) NOT NULL,
    image VARCHAR(500) NOT NULL,
    equipment_category_index VARCHAR(100) NOT NULL,
    variant BOOLEAN NOT NULL,
    attunement BOOLEAN NOT NULL,
    rarity JSON NOT NULL,
    `desc` JSON NOT NULL,
    `limited-to` VARCHAR(255)
);

-- Tabla de escuelas de magia (Magic Schools).
CREATE TABLE IF NOT EXISTS magic_schools (
    `index` VARCHAR(100) NOT NULL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    description TEXT NOT NULL,
    url VARCHAR(255) NOT NULL
);

-- Tabla de monstruos (Monsters).
CREATE TABLE IF NOT EXISTS monsters (
    `index` VARCHAR(100) NOT NULL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    size VARCHAR(100) NOT NULL,
    type VARCHAR(100) NOT NULL,
    subtype VARCHAR(255),
    alignment VARCHAR(255) NOT NULL,
    armor_class JSON NOT NULL,
    hit_points INT NOT NULL,
    hit_dice VARCHAR(100) NOT NULL,
    hit_points_roll VARCHAR(100) NOT NULL,
    speed JSON NOT NULL,
    strength INT NOT NULL,
    dexterity INT NOT NULL,
    constitution INT NOT NULL,
    intelligence INT NOT NULL,
    wisdom INT NOT NULL,
    charisma INT NOT NULL,
    damage_vulnerabilities JSON NOT NULL,
    damage_resistances JSON NOT NULL,
    damage_immunities JSON NOT NULL,
    senses JSON NOT NULL,
    languages TEXT NOT NULL,
    challenge_rating DECIMAL(5, 2) NOT NULL,
    gear TEXT,
    proficiency_bonus INT,
    xp INT NOT NULL,
    xp_in_lair INT,
    special_abilities JSON,
    actions JSON,
    bonus_actions JSON,
    legendary_actions JSON,
    reactions JSON,
    image VARCHAR(500),
    url VARCHAR(255) NOT NULL
);

-- Tabla de venenos (Poisons).
CREATE TABLE IF NOT EXISTS poisons (
    `index` VARCHAR(100) NOT NULL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    cost DECIMAL(10, 2) NOT NULL,
    type VARCHAR(100) NOT NULL,
    description TEXT NOT NULL,
    url VARCHAR(255) NOT NULL
);

-- Tabla de competencias (Proficiencies).
CREATE TABLE IF NOT EXISTS proficiencies (
    `index` VARCHAR(100) NOT NULL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    type VARCHAR(100) NOT NULL,
    reference JSON,
    url VARCHAR(255) NOT NULL
);

-- Tabla de habilidades (Skills).
CREATE TABLE IF NOT EXISTS skills (
    `index` VARCHAR(100) NOT NULL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    description TEXT NOT NULL,
    ability_score_index VARCHAR(100) NOT NULL,
    url VARCHAR(255) NOT NULL
);

-- Tabla de especies (Species).
CREATE TABLE IF NOT EXISTS species (
    `index` VARCHAR(100) NOT NULL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    url VARCHAR(255) NOT NULL,
    type VARCHAR(100) NOT NULL,
    size VARCHAR(100),
    size_options JSON,
    speed DECIMAL(8, 2) NOT NULL,
    traits JSON,
    subspecies JSON
);

-- Tabla de conjuros (Spells).
CREATE TABLE IF NOT EXISTS spells (
    `index` VARCHAR(100) NOT NULL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    description TEXT NOT NULL,
    higher_level TEXT,
    `range` VARCHAR(100) NOT NULL,
    components JSON NOT NULL,
    material TEXT,
    ritual BOOLEAN NOT NULL,
    duration VARCHAR(100) NOT NULL,
    concentration BOOLEAN NOT NULL,
    casting_time VARCHAR(100) NOT NULL,
    level INT NOT NULL,
    attack_type VARCHAR(100),
    damage JSON,
    dc JSON,
    area_of_effect JSON,
    heal_at_slot_level JSON,
    school_index VARCHAR(100) NOT NULL,
    url VARCHAR(255) NOT NULL
);

-- Tabla de subclases (Subclasses).
CREATE TABLE IF NOT EXISTS subclasses (
    `index` VARCHAR(100) NOT NULL PRIMARY KEY,
    url VARCHAR(255) NOT NULL,
    name VARCHAR(255) NOT NULL,
    class_index VARCHAR(100) NOT NULL,
    summary TEXT NOT NULL,
    description TEXT NOT NULL,
    features JSON NOT NULL
);

-- Tabla de subespecies (Subspecies).
CREATE TABLE IF NOT EXISTS subspecies (
    `index` VARCHAR(100) NOT NULL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    url VARCHAR(255) NOT NULL,
    species_index VARCHAR(100) NOT NULL,
    damage_type_index VARCHAR(100)
);

-- Tabla de rasgos de especie y subespecie (Traits).
CREATE TABLE IF NOT EXISTS traits (
    `index` VARCHAR(100) NOT NULL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    url VARCHAR(255) NOT NULL,
    description TEXT NOT NULL,
    proficiency_choices JSON,
    speed DECIMAL(8, 2)
);

-- Tabla de propiedades de maestria de armas (Weapon Mastery Properties).
CREATE TABLE IF NOT EXISTS weapon_mastery_properties (
    `index` VARCHAR(100) NOT NULL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    description TEXT NOT NULL,
    url VARCHAR(255) NOT NULL
);

-- Tabla de propiedades de armas (Weapon Properties).
CREATE TABLE IF NOT EXISTS weapon_properties (
    `index` VARCHAR(100) NOT NULL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    description TEXT NOT NULL,
    url VARCHAR(255) NOT NULL
);

-- Tabla puente de habilidades asociadas a puntuaciones de caracteristica.
CREATE TABLE IF NOT EXISTS ability_score_skills (
    ability_score_index VARCHAR(100) NOT NULL,
    skill_index VARCHAR(100) NOT NULL,
    position INT NOT NULL,
    PRIMARY KEY (ability_score_index, position)
);

-- Tabla puente de puntuaciones de caracteristica asociadas a trasfondos.
CREATE TABLE IF NOT EXISTS background_ability_scores (
    background_index VARCHAR(100) NOT NULL,
    ability_score_index VARCHAR(100) NOT NULL,
    position INT NOT NULL,
    PRIMARY KEY (background_index, position)
);

-- Tabla puente de competencias asociadas a trasfondos.
CREATE TABLE IF NOT EXISTS background_proficiencies (
    background_index VARCHAR(100) NOT NULL,
    proficiency_index VARCHAR(100) NOT NULL,
    position INT NOT NULL,
    PRIMARY KEY (background_index, position)
);

-- Tabla puente de competencias asociadas a clases.
CREATE TABLE IF NOT EXISTS class_proficiencies (
    class_index VARCHAR(100) NOT NULL,
    proficiency_index VARCHAR(100) NOT NULL,
    position INT NOT NULL,
    PRIMARY KEY (class_index, position)
);

-- Tabla puente de tiradas de salvacion asociadas a clases.
CREATE TABLE IF NOT EXISTS class_saving_throws (
    class_index VARCHAR(100) NOT NULL,
    ability_score_index VARCHAR(100) NOT NULL,
    position INT NOT NULL,
    PRIMARY KEY (class_index, position)
);

-- Tabla puente de subclases asociadas a clases.
CREATE TABLE IF NOT EXISTS class_subclasses (
    class_index VARCHAR(100) NOT NULL,
    subclass_index VARCHAR(100) NOT NULL,
    position INT NOT NULL,
    PRIMARY KEY (class_index, position)
);

-- Tabla puente de equipo perteneciente a categorias de equipo.
CREATE TABLE IF NOT EXISTS equipment_category_items (
    equipment_category_index VARCHAR(100) NOT NULL,
    equipment_index VARCHAR(100) NOT NULL,
    position INT NOT NULL,
    PRIMARY KEY (equipment_category_index, position)
);

-- Tabla puente de categorias asociadas a equipo.
CREATE TABLE IF NOT EXISTS equipment_equipment_categories (
    equipment_index VARCHAR(100) NOT NULL,
    equipment_category_index VARCHAR(100) NOT NULL,
    position INT NOT NULL,
    PRIMARY KEY (equipment_index, position)
);

-- Tabla puente de propiedades asociadas a equipo.
CREATE TABLE IF NOT EXISTS equipment_properties (
    equipment_index VARCHAR(100) NOT NULL,
    weapon_property_index VARCHAR(100) NOT NULL,
    position INT NOT NULL,
    PRIMARY KEY (equipment_index, position)
);

-- Tabla puente de rasgos desbloqueados por nivel.
CREATE TABLE IF NOT EXISTS level_features (
    level_index VARCHAR(100) NOT NULL,
    feature_index VARCHAR(100) NOT NULL,
    position INT NOT NULL,
    PRIMARY KEY (level_index, position)
);

-- Tabla puente de variantes de objetos magicos.
CREATE TABLE IF NOT EXISTS magic_item_variants (
    magic_item_index VARCHAR(100) NOT NULL,
    variant_index VARCHAR(100) NOT NULL,
    position INT NOT NULL,
    PRIMARY KEY (magic_item_index, position)
);

-- Tabla puente de competencias asociadas a monstruos y su valor.
CREATE TABLE IF NOT EXISTS monster_proficiencies (
    monster_index VARCHAR(100) NOT NULL,
    proficiency_index VARCHAR(100) NOT NULL,
    value INT NOT NULL,
    position INT NOT NULL,
    PRIMARY KEY (monster_index, position)
);

-- Tabla puente de inmunidades a condiciones de monstruos.
CREATE TABLE IF NOT EXISTS monster_condition_immunities (
    monster_index VARCHAR(100) NOT NULL,
    condition_index VARCHAR(100) NOT NULL,
    position INT NOT NULL,
    PRIMARY KEY (monster_index, position)
);

-- Tabla puente de formas alternativas de monstruos.
CREATE TABLE IF NOT EXISTS monster_forms (
    monster_index VARCHAR(100) NOT NULL,
    form_index VARCHAR(100) NOT NULL,
    position INT NOT NULL,
    PRIMARY KEY (monster_index, position)
);

-- Tabla puente de trasfondos que otorgan competencias.
CREATE TABLE IF NOT EXISTS proficiency_backgrounds (
    proficiency_index VARCHAR(100) NOT NULL,
    background_index VARCHAR(100) NOT NULL,
    position INT NOT NULL,
    PRIMARY KEY (proficiency_index, position)
);

-- Tabla puente de clases que otorgan competencias.
CREATE TABLE IF NOT EXISTS proficiency_classes (
    proficiency_index VARCHAR(100) NOT NULL,
    class_index VARCHAR(100) NOT NULL,
    position INT NOT NULL,
    PRIMARY KEY (proficiency_index, position)
);

-- Tabla puente de rasgos asociados a especies.
CREATE TABLE IF NOT EXISTS species_traits (
    species_index VARCHAR(100) NOT NULL,
    trait_index VARCHAR(100) NOT NULL,
    position INT NOT NULL,
    PRIMARY KEY (species_index, position)
);

-- Tabla puente de subespecies pertenecientes a especies.
CREATE TABLE IF NOT EXISTS species_subspecies (
    species_index VARCHAR(100) NOT NULL,
    subspecies_index VARCHAR(100) NOT NULL,
    position INT NOT NULL,
    PRIMARY KEY (species_index, position)
);

-- Tabla puente de clases que pueden aprender conjuros.
CREATE TABLE IF NOT EXISTS spell_classes (
    spell_index VARCHAR(100) NOT NULL,
    class_index VARCHAR(100) NOT NULL,
    position INT NOT NULL,
    PRIMARY KEY (spell_index, position)
);

-- Tabla puente de subclases que pueden aprender conjuros.
CREATE TABLE IF NOT EXISTS spell_subclasses (
    spell_index VARCHAR(100) NOT NULL,
    subclass_index VARCHAR(100) NOT NULL,
    position INT NOT NULL,
    PRIMARY KEY (spell_index, position)
);

-- Tabla puente de rasgos asociados a subespecies, con nivel requerido.
CREATE TABLE IF NOT EXISTS subspecies_traits (
    subspecies_index VARCHAR(100) NOT NULL,
    trait_index VARCHAR(100) NOT NULL,
    level INT NOT NULL,
    position INT NOT NULL,
    PRIMARY KEY (subspecies_index, position)
);

-- Tabla puente de especies asociadas a rasgos.
CREATE TABLE IF NOT EXISTS trait_species (
    trait_index VARCHAR(100) NOT NULL,
    species_index VARCHAR(100) NOT NULL,
    position INT NOT NULL,
    PRIMARY KEY (trait_index, position)
);

-- Tabla puente de subespecies asociadas a rasgos.
CREATE TABLE IF NOT EXISTS trait_subspecies (
    trait_index VARCHAR(100) NOT NULL,
    subspecies_index VARCHAR(100) NOT NULL,
    position INT NOT NULL,
    PRIMARY KEY (trait_index, position)
);

-- Tabla puente de conjuros otorgados por rasgos, con usos y recuperacion.
CREATE TABLE IF NOT EXISTS trait_spells (
    trait_index VARCHAR(100) NOT NULL,
    spell_index VARCHAR(100) NOT NULL,
    uses VARCHAR(100),
    recovery VARCHAR(100),
    position INT NOT NULL,
    PRIMARY KEY (trait_index, position)
);

-- Restricciones de clave foranea para referencias de una sola entidad.
ALTER TABLE backgrounds
    ADD CONSTRAINT fk_backgrounds_feat
    FOREIGN KEY (feat_index) REFERENCES feats (`index`);

ALTER TABLE equipment
    ADD CONSTRAINT fk_equipment_ammunition
        FOREIGN KEY (ammunition_index) REFERENCES equipment (`index`),
    ADD CONSTRAINT fk_equipment_ability_score
        FOREIGN KEY (ability_score_index) REFERENCES ability_scores (`index`),
    ADD CONSTRAINT fk_equipment_mastery
        FOREIGN KEY (mastery_index) REFERENCES weapon_mastery_properties (`index`);

ALTER TABLE features
    ADD CONSTRAINT fk_features_level
        FOREIGN KEY (level_index) REFERENCES levels (`index`),
    ADD CONSTRAINT fk_features_class
        FOREIGN KEY (class_index) REFERENCES classes (`index`),
    ADD CONSTRAINT fk_features_subclass
        FOREIGN KEY (subclass_index) REFERENCES subclasses (`index`);

ALTER TABLE levels
    ADD CONSTRAINT fk_levels_class
        FOREIGN KEY (class_index) REFERENCES classes (`index`),
    ADD CONSTRAINT fk_levels_subclass
        FOREIGN KEY (subclass_index) REFERENCES subclasses (`index`);

ALTER TABLE magic_items
    ADD CONSTRAINT fk_magic_items_equipment_category
    FOREIGN KEY (equipment_category_index) REFERENCES equipment_categories (`index`);

ALTER TABLE skills
    ADD CONSTRAINT fk_skills_ability_score
    FOREIGN KEY (ability_score_index) REFERENCES ability_scores (`index`);

ALTER TABLE spells
    ADD CONSTRAINT fk_spells_school
    FOREIGN KEY (school_index) REFERENCES magic_schools (`index`);

ALTER TABLE subclasses
    ADD CONSTRAINT fk_subclasses_class
    FOREIGN KEY (class_index) REFERENCES classes (`index`);

ALTER TABLE subspecies
    ADD CONSTRAINT fk_subspecies_species
        FOREIGN KEY (species_index) REFERENCES species (`index`),
    ADD CONSTRAINT fk_subspecies_damage_type
        FOREIGN KEY (damage_type_index) REFERENCES damage_types (`index`);

-- Restricciones de clave foranea para relaciones de varios a varios.
ALTER TABLE ability_score_skills
    ADD FOREIGN KEY (ability_score_index) REFERENCES ability_scores (`index`),
    ADD FOREIGN KEY (skill_index) REFERENCES skills (`index`);

ALTER TABLE background_ability_scores
    ADD FOREIGN KEY (background_index) REFERENCES backgrounds (`index`),
    ADD FOREIGN KEY (ability_score_index) REFERENCES ability_scores (`index`);

ALTER TABLE background_proficiencies
    ADD FOREIGN KEY (background_index) REFERENCES backgrounds (`index`),
    ADD FOREIGN KEY (proficiency_index) REFERENCES proficiencies (`index`);

ALTER TABLE class_proficiencies
    ADD FOREIGN KEY (class_index) REFERENCES classes (`index`),
    ADD FOREIGN KEY (proficiency_index) REFERENCES proficiencies (`index`);

ALTER TABLE class_saving_throws
    ADD FOREIGN KEY (class_index) REFERENCES classes (`index`),
    ADD FOREIGN KEY (ability_score_index) REFERENCES ability_scores (`index`);

ALTER TABLE class_subclasses
    ADD FOREIGN KEY (class_index) REFERENCES classes (`index`),
    ADD FOREIGN KEY (subclass_index) REFERENCES subclasses (`index`);

ALTER TABLE equipment_category_items
    ADD FOREIGN KEY (equipment_category_index) REFERENCES equipment_categories (`index`),
    ADD FOREIGN KEY (equipment_index) REFERENCES equipment (`index`);

ALTER TABLE equipment_equipment_categories
    ADD FOREIGN KEY (equipment_index) REFERENCES equipment (`index`),
    ADD FOREIGN KEY (equipment_category_index) REFERENCES equipment_categories (`index`);

ALTER TABLE equipment_properties
    ADD FOREIGN KEY (equipment_index) REFERENCES equipment (`index`),
    ADD FOREIGN KEY (weapon_property_index) REFERENCES weapon_properties (`index`);

ALTER TABLE level_features
    ADD FOREIGN KEY (level_index) REFERENCES levels (`index`),
    ADD FOREIGN KEY (feature_index) REFERENCES features (`index`);

ALTER TABLE magic_item_variants
    ADD FOREIGN KEY (magic_item_index) REFERENCES magic_items (`index`),
    ADD FOREIGN KEY (variant_index) REFERENCES magic_items (`index`);

ALTER TABLE monster_proficiencies
    ADD FOREIGN KEY (monster_index) REFERENCES monsters (`index`),
    ADD FOREIGN KEY (proficiency_index) REFERENCES proficiencies (`index`);

ALTER TABLE monster_condition_immunities
    ADD FOREIGN KEY (monster_index) REFERENCES monsters (`index`),
    ADD FOREIGN KEY (condition_index) REFERENCES conditions (`index`);

ALTER TABLE monster_forms
    ADD FOREIGN KEY (monster_index) REFERENCES monsters (`index`),
    ADD FOREIGN KEY (form_index) REFERENCES monsters (`index`);

ALTER TABLE proficiency_backgrounds
    ADD FOREIGN KEY (proficiency_index) REFERENCES proficiencies (`index`),
    ADD FOREIGN KEY (background_index) REFERENCES backgrounds (`index`);

ALTER TABLE proficiency_classes
    ADD FOREIGN KEY (proficiency_index) REFERENCES proficiencies (`index`),
    ADD FOREIGN KEY (class_index) REFERENCES classes (`index`);

ALTER TABLE species_traits
    ADD FOREIGN KEY (species_index) REFERENCES species (`index`),
    ADD FOREIGN KEY (trait_index) REFERENCES traits (`index`);

ALTER TABLE species_subspecies
    ADD FOREIGN KEY (species_index) REFERENCES species (`index`),
    ADD FOREIGN KEY (subspecies_index) REFERENCES subspecies (`index`);

ALTER TABLE spell_classes
    ADD FOREIGN KEY (spell_index) REFERENCES spells (`index`),
    ADD FOREIGN KEY (class_index) REFERENCES classes (`index`);

ALTER TABLE spell_subclasses
    ADD FOREIGN KEY (spell_index) REFERENCES spells (`index`),
    ADD FOREIGN KEY (subclass_index) REFERENCES subclasses (`index`);

ALTER TABLE subspecies_traits
    ADD FOREIGN KEY (subspecies_index) REFERENCES subspecies (`index`),
    ADD FOREIGN KEY (trait_index) REFERENCES traits (`index`);

ALTER TABLE trait_species
    ADD FOREIGN KEY (trait_index) REFERENCES traits (`index`),
    ADD FOREIGN KEY (species_index) REFERENCES species (`index`);

ALTER TABLE trait_subspecies
    ADD FOREIGN KEY (trait_index) REFERENCES traits (`index`),
    ADD FOREIGN KEY (subspecies_index) REFERENCES subspecies (`index`);

ALTER TABLE trait_spells
    ADD FOREIGN KEY (trait_index) REFERENCES traits (`index`),
    ADD FOREIGN KEY (spell_index) REFERENCES spells (`index`);
