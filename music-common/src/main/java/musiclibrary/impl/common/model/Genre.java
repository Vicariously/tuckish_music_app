package musiclibrary.impl.common.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="genre")
public class Genre extends NamedModel{
	
	private static final long serialVersionUID = 1L;
	private List<Artist> artists;
	
	@OneToMany(mappedBy="genre")
	public List<Artist> getArtists() {
		return artists;
	}
	
	public void setArtists(List<Artist> artists) {
		this.artists = artists;
	}
	
	
}
