package musiclibrary.impl.common.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "album")
public class Album extends TitledModel {

	private static final long serialVersionUID = 1L;
	private Artist artist;
	private List<Song> songs;

	@ManyToOne
	@JoinColumn(name = "artist_id")
	public Artist getArtist() {
		return this.artist;
	}

	public void setArtist(Artist artist) {
		this.artist = artist;
	}

	@OneToMany(mappedBy = "album")
	public List<Song> getSongs() {
		return this.songs;
	}

	public void setSongs(List<Song> songs) {
		this.songs = songs;
	}
}
