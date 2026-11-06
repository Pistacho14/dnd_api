-- Tabla de puntuaciones de caracteristica (Ability Scores).
CREATE TABLE IF NOT EXISTS ability_scores (
    `index` VARCHAR(100) NOT NULL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    full_name VARCHAR(255) NOT NULL,
    description TEXT NOT NULL,
    skills JSON NULL,
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
    ability_scores JSON NOT NULL,
    feat JSON NOT NULL,
    proficiencies JSON NOT NULL,
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
    proficiencies JSON,
    proficiency_choices JSON NOT NULL,
    saving_throws JSON,
    starting_equipment_options JSON NOT NULL,
    subclasses JSON,
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
    equipment_categories JSON NOT NULL,
    cost JSON NOT NULL,
    url VARCHAR(255) NOT NULL,
    description TEXT,
    weight DECIMAL(10, 2),
    ammunition JSON,
    armor_class JSON,
    contents JSON,
    ability JSON,
    craft JSON,
    damage JSON,
    doff_time VARCHAR(100),
    don_time VARCHAR(100),
    image VARCHAR(500),
    mastery JSON,
    notes JSON,
    properties JSON,
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
    level JSON NOT NULL,
    class JSON NOT NULL,
    subclass JSON,
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
    features JSON,
    class JSON NOT NULL,
    subclass JSON,
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
    equipment_category JSON NOT NULL,
    variant BOOLEAN NOT NULL,
    variants JSON NOT NULL,
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
    proficiencies JSON NOT NULL,
    damage_vulnerabilities JSON NOT NULL,
    damage_resistances JSON NOT NULL,
    damage_immunities JSON NOT NULL,
    condition_immunities JSON NOT NULL,
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
    forms JSON,
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
    backgrounds JSON NOT NULL,
    classes JSON NOT NULL,
    reference JSON,
    url VARCHAR(255) NOT NULL
);

-- Tabla de habilidades (Skills).
CREATE TABLE IF NOT EXISTS skills (
    `index` VARCHAR(100) NOT NULL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    description TEXT NOT NULL,
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
    school JSON NOT NULL,
    classes JSON NOT NULL,
    subclasses JSON,
    url VARCHAR(255) NOT NULL
);

-- Tabla de subclases (Subclasses).
CREATE TABLE IF NOT EXISTS subclasses (
    `index` VARCHAR(100) NOT NULL PRIMARY KEY,
    url VARCHAR(255) NOT NULL,
    name VARCHAR(255) NOT NULL,
    class JSON NOT NULL,
    summary TEXT NOT NULL,
    description TEXT NOT NULL,
    features JSON NOT NULL
);

-- Tabla de subespecies (Subspecies).
CREATE TABLE IF NOT EXISTS subspecies (
    `index` VARCHAR(100) NOT NULL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    url VARCHAR(255) NOT NULL,
    species JSON NOT NULL,
    traits JSON NOT NULL,
    damage_type JSON
);

-- Tabla de rasgos de especie y subespecie (Traits).
CREATE TABLE IF NOT EXISTS traits (
    `index` VARCHAR(100) NOT NULL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    url VARCHAR(255) NOT NULL,
    description TEXT NOT NULL,
    species JSON NOT NULL,
    spells JSON,
    subspecies JSON,
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

ALTER TABLE skills
    ADD COLUMN ability_score_index VARCHAR(255) NOT NULL,

    ADD CONSTRAINT skills_ability_scores
    FOREIGN KEY (ability_score_index)
        REFERENCES ability_scores(name)
        ON DELETE RESTRICT
        ON UPDATE CASCADE;
