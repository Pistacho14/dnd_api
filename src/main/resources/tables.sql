CREATE TABLE IF NOT EXISTS ability_scores (
    `index` VARCHAR(100) NOT NULL PRIMARY KEY,
    name TEXT NOT NULL,
    full_name TEXT NOT NULL,
    description TEXT NOT NULL,
    url TEXT NOT NULL
);

CREATE TABLE IF NOT EXISTS skills (
    `index` VARCHAR(100) NOT NULL PRIMARY KEY,
    name TEXT NOT NULL,
    description TEXT NOT NULL,

    ability_score_index VARCHAR(100) NOT NULL,

    url TEXT NOT NULL,

    FOREIGN KEY (ability_score_index)
        REFERENCES ability_scores(`index`)
);