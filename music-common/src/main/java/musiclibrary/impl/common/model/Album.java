package musiclibrary.impl.common.model;

import java.util.List;

public class Album extends NamedModel{

	private Artist artist;
	private List<Song> songs;
	private String title;
}
