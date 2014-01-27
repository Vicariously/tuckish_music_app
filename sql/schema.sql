
-- Cleanup ---------------------------------------
DROP TABLE IF EXISTS song;
DROP TABLE IF EXISTS album;
DROP TABLE IF EXISTS artist;
DROP TABLE IF EXISTS genre;

-- Schema ---------------------------------------
CREATE TABLE IF NOT EXISTS genre (
  id BIGINT NOT NULL AUTO_INCREMENT,
  name VARCHAR(30),
  PRIMARY KEY(id)
);

CREATE TABLE IF NOT EXISTS artist (
  id BIGINT NOT NULL AUTO_INCREMENT,
  genre_id BIGINT NOT NULL,
  name VARCHAR(30),
  PRIMARY KEY(id),
  CONSTRAINT FK_GENRE_ARTIST FOREIGN KEY (genre_id) REFERENCES genre (id)
);

CREATE TABLE IF NOT EXISTS album (
  id BIGINT NOT NULL AUTO_INCREMENT,
  artist_id BIGINT NOT NULL,
  title VARCHAR(30),
  PRIMARY KEY (id),
  CONSTRAINT FK_ARTIST_ALBUM FOREIGN KEY (artist_id) REFERENCES artist (id)
);

CREATE TABLE IF NOT EXISTS song (
  id BIGINT NOT NULL AUTO_INCREMENT,
  artist_id BIGINT NOT NULL,
  album_id BIGINT NOT NULL,
  title VARCHAR(30),
  track TINYINT,
  comment VARCHAR(50),
  type VARCHAR(15),
  filepath VARCHAR(100) NOT NULL,
  PRIMARY KEY (id),
  CONSTRAINT FK_ARTIST_SONG FOREIGN KEY (artist_id) REFERENCES artist (id),
  CONSTRAINT FK_ALBUM_SONG FOREIGN KEY (album_id) REFERENCES album (id)
);
