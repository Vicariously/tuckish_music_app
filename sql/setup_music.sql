set foreign_key_checks=0;

DROP TABLE IF EXISTS song;
DROP TABLE IF EXISTS album;

-- ---------------------------------------
-- ---------------------------------------

CREATE TABLE IF NOT EXISTS song( id INT NOT NULL, title VARCHAR(30), track TINYINT, comment VARCHAR(50), type VARCHAR(15), PRIMARY KEY (id) );

CREATE TABLE IF NOT EXISTS album( id INT NOT NULL, PRIMARY KEY (id));

CREATE TABLE IF NOT EXISTS artist(id INT NOT NULL, name VARCHAR(30), filepath VARCHAR(30), PRIMARY KEY(id));

CREATE TABLE IF NOT EXISTS genre(id INT NOT NULL, name VARCHAR(30), PRIMARY KEY(id));

-- ---------------------------------------
-- ---------------------------------------
ALTER TABLE song ADD COLUMN album_id INT NOT NULL;
ALTER TABLE song ADD FOREIGN KEY (album_id) REFERENCES album(id);

ALTER TABLE album ADD COLUMN song_id INT NOT NULL;
ALTER TABLE album ADD FOREIGN KEY (song_id) REFERENCES song(id);

ALTER TABLE artist ADD COLUMN album_id INT NOT NULL;
ALTER TABLE artist ADD FOREIGN KEY (album_id) REFERENCES album(id);

ALTER TABLE artist ADD COLUMN song_id INT NOT NULL;
ALTER TABLE artist ADD FOREIGN KEY(song_id) REFERENCES song(id);

ALTER TABLE artist ADD COLUMN genre_id INT NOT NULL;
ALTER TABLE artist ADD FOREIGN KEY (genre_id) REFERENCES genre(id);

-- ---------------------------------------
-- ---------------------------------------

set foreign_key_checks=1;
