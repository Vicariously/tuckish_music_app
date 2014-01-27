SET foreign_key_checks = 0;

DROP TABLE IF EXISTS song;
DROP TABLE IF EXISTS album;
DROP TABLE IF EXISTS artist;
DROP TABLE IF EXISTS genre;

-- ---------------------------------------
-- ---------------------------------------

CREATE TABLE IF NOT EXISTS song(
  id BIGINT NOT NULL AUTO_INCREMENT,
  album_id BIGINT NOT NULL,
  title VARCHAR(30),
  track TINYINT,
  comment VARCHAR(50),
  type VARCHAR(15),
  filepath VARCHAR(100) NOT NULL,
  PRIMARY KEY (id),
  CONSTRAINT FK_ALBUM_SONG FOREIGN KEY (album_id) REFERENCES album(id)
);

CREATE TABLE IF NOT EXISTS album(
  id BIGINT NOT NULL AUTO_INCREMENT,
  title VARCHAR(30),
  PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS artist(
  id BIGINT NOT NULL AUTO_INCREMENT,
  name VARCHAR(30),
  PRIMARY KEY(id)
);

CREATE TABLE IF NOT EXISTS genre(
  id BIGINT NOT NULL AUTO_INCREMENT,
  name VARCHAR(30),
  PRIMARY KEY(id)
);

-- ---------------------------------------
-- ---------------------------------------
-- ALTER TABLE song ADD COLUMN album_id INT NOT NULL;
-- ALTER TABLE song ADD FOREIGN KEY (album_id) REFERENCES album(id);

ALTER TABLE song ADD COLUMN artist_id BIGINT NOT NULL;
ALTER TABLE song ADD FOREIGN KEY (artist_id) REFERENCES artist(id);

ALTER TABLE album ADD COLUMN artist_id BIGINT NOT NULL;
ALTER TABLE album ADD FOREIGN KEY (artist_id) REFERENCES artist(id);

ALTER TABLE artist ADD COLUMN genre_id BIGINT NOT NULL;
ALTER TABLE artist ADD FOREIGN KEY (genre_id) REFERENCES genre(id);

-- ---------------------------------------
-- ---------------------------------------

SET foreign_key_checks = 1;

INSERT INTO song(title, track, comment, type, filepath)
VALUES('Ends', 2, 'this is a new comment', 'mp3', '/home/meghan/Documents/TestMusicDirectory/Everlast/Whitey Ford Sings the Blues');
