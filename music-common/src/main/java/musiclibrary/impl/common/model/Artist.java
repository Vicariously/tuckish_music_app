package musiclibrary.impl.common.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "artist")
public class Artist extends NamedModel {

	private static final long serialVersionUID = 1L;
	private Genre genre;
	private List<Album> albums;

	@ManyToOne
	@JoinColumn(name = "genre_id")
	public Genre getGenre() {
		return this.genre;
	}

	public void setGenre(Genre genre) {
		this.genre = genre;
	}

	@OneToMany(mappedBy = "artist")
	public List<Album> getAlbums() {
		return this.albums;
	}

	public void setAlbums(List<Album> albums) {
		this.albums = albums;
	}
}
