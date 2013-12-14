set foreign_key_checks=0;

DROP TABLE IF EXISTS song;
DROP TABLE IF EXISTS album;
DROP TABLE IF EXISTS artist;
DROP TABLE IF EXISTS genre;

-- ---------------------------------------
-- ---------------------------------------

CREATE TABLE IF NOT EXISTS song( id INT NOT NULL AUTO_INCREMENT, title VARCHAR(30), track TINYINT, comment VARCHAR(50), type VARCHAR(15), filepath VARCHAR(100) NOT NULL, PRIMARY KEY (id) );

CREATE TABLE IF NOT EXISTS album( id INT NOT NULL AUTO_INCREMENT, title VARCHAR(30), PRIMARY KEY (id));

CREATE TABLE IF NOT EXISTS artist(id INT NOT NULL AUTO_INCREMENT, name VARCHAR(30), PRIMARY KEY(id));

CREATE TABLE IF NOT EXISTS genre(id INT NOT NULL AUTO_INCREMENT, name VARCHAR(30), PRIMARY KEY(id));

-- ---------------------------------------
-- ---------------------------------------
ALTER TABLE song ADD COLUMN album_id INT NOT NULL;
ALTER TABLE song ADD FOREIGN KEY (album_id) REFERENCES album(id);
ALTER TABLE song ADD COLUMN artist_id INT NOT NULL;
ALTER TABLE song ADD FOREIGN KEY (artist_id) REFERENCES artist(id);

ALTER TABLE album ADD COLUMN artist_id INT NOT NULL;
ALTER TABLE album ADD FOREIGN KEY (artist_id) REFERENCES artist(id);

ALTER TABLE artist ADD COLUMN genre_id INT NOT NULL;
ALTER TABLE artist ADD FOREIGN KEY (genre_id) REFERENCES genre(id);

-- ---------------------------------------
-- ---------------------------------------

set foreign_key_checks=1;

insert into song(title, track, comment, type, filepath )values('Ends', 2, 'this is a new comment', 'mp3', '/home/meghan/Documents/TestMusicDirectory/Everlast/Whitey Ford Sings the Blues');
