create table translation_mouse(
    id INTEGER PRIMARY KEY,
    language_id INTEGER,
    text VARCHAR(2000),
    created_on TIMESTAMPTZ,
    updated_on TIMESTAMPTZ,
    CONSTRAINT fk_language_id FOREIGN KEY(language_id)
    REFERENCES gamers_market.languages(id),
    unique(id)
);
