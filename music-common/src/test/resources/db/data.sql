insert into artist (name, genre_id)
values
('Everlast', 1);

insert into album (name, artist_id)
values
('Whitey Ford Sings The Blues', 1);

insert into song
(title, track, comment, type, filepath, artist_id, album_id)
values
('Ends', 2, 'this is a new comment', 'mp3', '/home/meghan/Documents/TestMusicDirectory/Everlast/Whitey Ford Sings the Blues', 1, 1);

insert into genre
(name)
values
('Blues');