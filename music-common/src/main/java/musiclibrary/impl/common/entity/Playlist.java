package musiclibrary.impl.common.entity;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Playlist extends NamedEntity {

	private static final long serialVersionUID = 1L;

	public Playlist() {
	}

	public Playlist(long id, String name) {
		this.id = id;
		this.name = name;
	}
}
