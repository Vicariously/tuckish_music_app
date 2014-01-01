CREATE TABLE artist(
	id INT NOT NULL AUTO_INCREMENT,
	name VARCHAR(256),
	genre_id INT,
	PRIMARY KEY (id)
);

CREATE TABLE album(
	id INT NOT NULL AUTO_INCREMENT,
	name VARCHAR(256),
	artist_id INT NOT NULL,
	PRIMARY KEY (id),
	FOREIGN KEY (artist_id) REFERENCES artist(id)
);

CREATE TABLE song( 
	id INT NOT NULL AUTO_INCREMENT, 
	title VARCHAR(256), 
	track TINYINT, 
	comment VARCHAR(50), 
	type VARCHAR(15), 
	filepath VARCHAR(100) NOT NULL, 
	artist_id INT NOT NULL,
	album_id INT NOT NULL,
	PRIMARY KEY (id),
	FOREIGN KEY (artist_id) REFERENCES artist(id),
	FOREIGN KEY (album_id) REFERENCES album(id)
);

CREATE TABLE genre(
	id INT NOT NULL AUTO_INCREMENT,
	name VARCHAR(256),
	PRIMARY KEY (id)
);