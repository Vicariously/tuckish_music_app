-- NOTE: Some of the SQL statements use an insert-select. This ensures the FK matches the required value.

---- Genres ----
INSERT INTO genre (name)
VALUES ('Blues Rock');

---- Artists ----
INSERT INTO artist (genre_id, name)
SELECT g.id, 'Everlast'
FROM genre g
WHERE g.name = 'Blues Rock';

---- Albums ----
INSERT INTO album (artist_id, title) 
SELECT a.id, 'Whitey Ford Sings the Blues'
FROM artist a
WHERE a.name = 'Everlast';

---- Songs ----
INSERT INTO song (artist_id, album_id, title, track, comment, type, filepath)
VALUES (
  (SELECT id FROM artist WHERE name = 'Everlast'),
  (SELECT id FROM album WHERE title = 'Whitey Ford Sings the Blues'),
  'Ends', 3, 'This song is 4:43 long', 'mp3', '/home/meghan/Documents/TestMusicDirectory/Everlast/Whitey Ford Sings the Blues'
);
