package musiclibrary.impl.common.organizor;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import musiclibrary.impl.common.organizor.strategy.IOrganizer;
import musiclibrary.impl.common.organizor.strategy.OrganizeArtist;
import musiclibrary.impl.common.organizor.Stash;

@Component
public class OrganizeContext {

	private IOrganizer organizer;
	
	public void setOrganizer(IOrganizer organizer){
		this.organizer = organizer;
	}
	
	public IOrganizer getOrganizer(){
		return this.organizer;
	}
	
	public Stash organize(String file, String fileType){
		
		List list = organizer.execute();
		Stash stash = new Stash();
		stash.setArtists(list); //obviously logic needs to go into this but get the idea
		return stash;
	}
	
}
