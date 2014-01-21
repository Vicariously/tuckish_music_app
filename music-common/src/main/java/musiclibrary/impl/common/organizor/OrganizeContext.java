package musiclibrary.impl.common.organizor;

import org.springframework.stereotype.Component;

import musiclibrary.impl.common.organizor.strategy.IOrganizer;
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
		return new Stash();
	}
}
