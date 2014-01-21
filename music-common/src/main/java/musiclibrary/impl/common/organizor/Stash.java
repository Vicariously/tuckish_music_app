package musiclibrary.impl.common.organizor;

import java.util.List;
import java.util.Map;

public class Stash {

	List<String> artists;
	List<String> albums;
	List<Map<String,String>> songs;
	List<String> art;
	
	public List<String> getArtists() {
		return artists;
	}
	public void setArtists(List<String> artists) {
		this.artists = artists;
	}
	public List<String> getAlbums() {
		return albums;
	}
	public void setAlbums(List<String> albums) {
		this.albums = albums;
	}
	public List<Map<String, String>> getSongs() {
		return songs;
	}
	public void setSongs(List<Map<String, String>> songs) {
		this.songs = songs;
	}
	public List<String> getArt() {
		return art;
	}
	public void setArt(List<String> art) {
		this.art = art;
	}
	
	
	
}
